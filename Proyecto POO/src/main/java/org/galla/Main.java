package org.galla;

import io.javalin.Javalin;
import org.galla.controller.ProductoController;
import org.galla.repository.ProductoRepository;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.plugins.enableCors(cors -> {
                cors.add(it -> it.anyHost());
            });
            config.http.defaultContentType = "application/json";
        });

        // Inicializa Repositorio y Controlador
        ProductoRepository repository = new ProductoRepository();
        ProductoController controller = new ProductoController(repository);

        // Define las rutas directamente con app
        app.get("/api/productos", controller::obtenerTodos);
        app.get("/api/productos/{id}", controller::obtenerPorId);
        app.post("/api/productos", controller::crearProducto);
        app.put("/api/productos/{id}", controller::actualizarProducto);
        app.delete("/api/productos/{id}", controller::eliminarProducto);
        app.get("/api/productos/categoria/{categoria}", controller::buscarPorCategoria);
        app.get("/", ctx -> ctx.result("Bienvenido a la API del Restaurante"));

        // Manejo Global de Excepciones
        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.json(Map.of("error", "Error interno del servidor: " + e.getMessage()));
        });

        // Inicia el servidor DESPUÉS de la configuración
        app.start(8080);
    }
}