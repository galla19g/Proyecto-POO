package org.galla;

import io.javalin.Javalin;

import org.galla.compartidos.ExceptionController;
import org.galla.compartidos.HealthController;
import org.galla.productos.ProductoController;
import org.galla.productos.ProductoRepository;
import org.galla.productos.ProductoService;
import org.galla.recetas.RecetaController;
import org.galla.recetas.RecetaRepository;
import org.galla.recetas.RecetaService;

public class Main {
    public static void main(String[] args) {
        ProductoRepository productoRepository = new ProductoRepository();
        ProductoService productoService = new ProductoService(productoRepository);
        ProductoController productoController = new ProductoController(productoService);
        ExceptionController exceptionController = new ExceptionController();
        HealthController healthController = new HealthController();
        RecetaRepository recetaRepository = new RecetaRepository();
        RecetaService recetaService = new RecetaService(recetaRepository);
        RecetaController recetaController = new RecetaController(recetaService);
        Javalin app = Javalin.create();
        exceptionController.iniciarControl(app);
        healthController.configurarRutas(app);
        productoController.configurarRutas(app);
        recetaController.configurarRutas(app);
        app.before((ctx) ->ctx.header("content-type", "application/json"));
        app.start(8080);
    
    }
}
