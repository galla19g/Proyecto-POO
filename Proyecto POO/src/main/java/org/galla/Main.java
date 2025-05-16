package org.galla;

import io.javalin.Javalin;
import org.galla.productos.controller.ExceptionController;
import org.galla.productos.controller.HealthController;
import org.galla.productos.controller.ProductoController;
import org.galla.productos.repository.ProductoRepository;
import org.galla.productos.service.ProductoService;

public class Main {
    public static void main(String[] args) {
        ProductoRepository productoRepository = new ProductoRepository();
        ProductoService productoService = new ProductoService(productoRepository);
        ProductoController productoController = new ProductoController(productoService);
        ExceptionController exceptionController = new ExceptionController();
        HealthController healthController = new HealthController();
        Javalin app = Javalin.create();
        exceptionController.iniciarControl(app);
        healthController.configurarRutas(app);
        productoController.configurarRutas(app);
        app.before((ctx) ->ctx.header("content-type", "application/json"));
        app.start(8080);
    
}
}