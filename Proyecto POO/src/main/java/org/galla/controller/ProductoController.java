package org.galla.controller;

import com.google.gson.Gson;
import org.galla.model.Producto;
import org.galla.repository.ProductoRepository;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;

public class ProductoController {
    private final ProductoRepository repository;
    private final Gson gson;

    public ProductoController(ProductoRepository repository) {
        this.repository = repository;
        this.gson = new Gson();
    }


    public void obtenerTodos(Context ctx) {
       ctx.contentType("application/json");
       ctx.json(repository.obtenerTodos());
    }

    public String obtenerPorId(Context ctx) {
       ctx.contentType("application/json");
        String id = ctx.pathParam("id");
        return repository.obtenerPorId(id)
                .map(gson::toJson)
                .orElseGet(() -> {
                    ctx.status(404);
                    return crearMensajeError("Producto no encontrado");
                });
    }

    public String crearProducto(Context ctx) {
        ctx.contentType("application/json");
        try {
            Producto nuevoProducto = gson.fromJson(ctx.body(), Producto.class);
            Producto productoCreado = repository.agregarProducto(nuevoProducto);
            ctx.status(201);
            return gson.toJson(productoCreado);
        } catch (Exception e) {
            ctx.status(400);
            return crearMensajeError("Error al crear el producto: " + e.getMessage());
        }
    }

    public String actualizarProducto(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id");
        try {
            Producto productoActualizado = gson.fromJson(ctx.body(), Producto.class);
            boolean actualizado = repository.actualizarProducto(id, productoActualizado);
            if (actualizado) {
                return gson.toJson(repository.obtenerPorId(id).get());
            } else {
                ctx.status(404);
                return crearMensajeError("Producto no encontrado");
            }
        } catch (Exception e) {
            ctx.status(400);
            return crearMensajeError("Error al actualizar el producto: " + e.getMessage());
        }
    }

    public String eliminarProducto(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id");
        boolean eliminado = repository.eliminarProducto(id);
        if (eliminado) {
            ctx.status(204);
            return "";
        } else {
            ctx.status(404);
            return crearMensajeError("Producto no encontrado");
        }
    }

    public String buscarPorCategoria(Context ctx) {
        ctx.contentType("application/json");
        String categoria = ctx.pathParam("categoria");
        return gson.toJson(repository.buscarPorCategoria(categoria));
    }

    private String crearMensajeError(String mensaje) {
        Map<String, String> error = new HashMap<>();
        error.put("error", mensaje);
        return gson.toJson(error);
    }
}