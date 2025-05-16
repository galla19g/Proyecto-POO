package org.galla.controller;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.model.Producto;
import org.galla.model.Mensaje;
import org.galla.service.ProductoService;

public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/productos", this::guardarProducto);
        app.get("/productos", this::obtenerProductos);
        app.delete("/productos/:id", this::eliminarProducto);
        app.put("/productos/:id", this::actualizarProducto);
        app.get("/productos/:id", this::listarProducto);
    }

    public void guardarProducto(Context ctx) {
        ctx.contentType("application/json");
        Producto Producto = (Producto) ctx.bodyAsClass(Producto.class);
        this.productoService.agregarProducto(Producto);
        Mensaje <Producto> mensaje = new Mensaje <Producto> ("Producto agregado correctamente", Producto);
        ctx.json(mensaje);
        ctx.status(201);
    }

    public void obtenerProductos(Context ctx) {
        String id = ctx.pathParam("id");
        Producto producto = this.productoService.obtenerProducto(id);
        ctx.json(producto);
    }

    public void eliminarProducto(Context ctx) {
        String id = ctx.pathParam("id");
        this.productoService.eliminarProducto(id);
        Mensaje <String> mensaje = new Mensaje("Producto eliminado correctamente", id);
        ctx.json(mensaje);
        ctx.status(200);
    }

    public void actualizarProducto(Context ctx) {
        String id = ctx.pathParam("id");
        Producto productoActualizado = (Producto) ctx.bodyAsClass(Producto.class);
        this.productoService.actualizarProducto(id, productoActualizado);
        Mensaje <Producto> mensaje = new Mensaje("Producto actualizado correctamente", productoActualizado);
        ctx.json(mensaje);
        ctx.status(200);
    }

    public void listarProducto(Context ctx) {
        ctx.json(this.productoService.obtenerProductos());
    }
}