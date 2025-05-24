package org.galla.productos;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

import org.galla.compartidos.Mensaje;

public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/productos", this::guardarProducto);
        app.get("/productos", this::obtenerTodosLosProductos); // Cambiado a un método más descriptivo
        app.get("/productos/{id}", this::obtenerProductoPorId); // Cambiado a un método más descriptivo
        app.delete("/productos/{id}", this::eliminarProducto);
        app.put("/productos/{id}", this::actualizarProducto);
    }

    public void guardarProducto(Context ctx) {
        ctx.contentType("application/json");
        Producto producto = ctx.bodyAsClass(Producto.class);
        this.productoService.agregarProducto(producto);
        ctx.json(producto);
        ctx.status(201);
    }

    public void obtenerTodosLosProductos(Context ctx) {
        ctx.contentType("application/json");
        List<Producto> productos = this.productoService.obtenerProductos();
        ctx.json(productos);
        ctx.status(200);
    }

    public void obtenerProductoPorId(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id");
        try {
            Producto producto = this.productoService.obtenerProducto(id);
            ctx.json(producto);
            ctx.status(200);
        } catch (NumberFormatException e) {
            ctx.status(400).json(new Mensaje<>("El ID proporcionado no es un número válido.", null));
        }
    }


    public void eliminarProducto(Context ctx) {
        String id = ctx.pathParam("id");
        this.productoService.eliminarProducto(id);
        ctx.status(204);
    }

    // En ProductoController.java
    public void actualizarProducto(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id"); // Obtiene el ID de la URL
        Producto productoDelBody = ctx.bodyAsClass(Producto.class); // Obtiene los datos del cuerpo de la solicitud
        try {
            Producto productoActualizado = this.productoService.actualizarProducto(id, productoDelBody);
            ctx.json(productoActualizado);
            ctx.status(200); // OK
        } catch (NumberFormatException e) {
            ctx.status(400).json(new Mensaje<>("El ID proporcionado en la URL no es un número válido.", null));
        }

    }

}