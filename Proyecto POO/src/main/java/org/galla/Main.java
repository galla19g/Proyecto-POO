
package org.galla;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import org.galla.controller.ProductoController;
import org.galla.repository.ProductoRepository;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.plugins.enableCors(cors -> {
                cors.add(it -> it.anyHost());
            });
            // Agregar configuración para el manejo de errores
            config.http.defaultContentType = "application/json";
        }).start(8080);

        // Manejo global de excepciones
        app.exception(Exception.class, (e, ctx) -> {
            ctx.status(500);
            ctx.json(Map.of("error", "Error interno del servidor: " + e.getMessage()));
        });

        ProductoRepository repository = new ProductoRepository();
        ProductoController controller = new ProductoController(repository);

        app.routes(() -> {
            ApiBuilder.path("/api", () -> {
                ApiBuilder.get("/productos", controller::obtenerTodos);
                ApiBuilder.get("/productos/{id}", controller::obtenerPorId);
                ApiBuilder.post("/productos", controller::crearProducto);
                ApiBuilder.put("/productos/{id}", controller::actualizarProducto);
                ApiBuilder.delete("/productos/{id}", controller::eliminarProducto);
                ApiBuilder.get("/productos/categoria/{categoria}", controller::buscarPorCategoria);
            });
        });

        app.get("/", ctx -> ctx.result("Bienvenido a la API del Restaurante"));
    }
}