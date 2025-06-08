package org.galla.nutricion;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;

import java.util.List;

public class ValorNutricionalController {
    private final ValorNutricionalService nutricionService;

    public ValorNutricionalController(ValorNutricionalService nutricionService) {
        this.nutricionService = nutricionService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/nutricion", this::crearNutricion);
        app.get("/nutricion", this::obtenerTodasLasNutriciones);
        app.get("/nutricion/{id}", this::obtenerNutricionPorId);
        app.put("/nutricion/{id}", this::actualizarNutricion);
        app.delete("/nutricion/{id}", this::eliminarNutricion);
    }

    private void crearNutricion(Context ctx) {
        ValorNutricional nutricion = ctx.bodyAsClass(ValorNutricional.class);
        ValorNutricional nutricionCreada = nutricionService.agregarNutricion(nutricion);
        ctx.json(new Mensaje<>("Información nutricional creada exitosamente.", nutricionCreada));
        ctx.status(201);
    }

    private void obtenerTodasLasNutriciones(Context ctx) {
        List<ValorNutricional> nutriciones = nutricionService.obtenerTodasLasNutriciones();
        ctx.json(nutriciones);
        ctx.status(200);
    }

    private void obtenerNutricionPorId(Context ctx) {
        String id = ctx.pathParam("id");
        ValorNutricional nutricion = nutricionService.obtenerNutricionPorId(id);
        ctx.json(nutricion);
        ctx.status(200);
    }

    private void actualizarNutricion(Context ctx) {
        String id = ctx.pathParam("id");
        ValorNutricional nutricionFromBody = ctx.bodyAsClass(ValorNutricional.class);
        ValorNutricional nutricionActualizada = nutricionService.actualizarNutricion(id, nutricionFromBody);
        ctx.json(new Mensaje<>("Información nutricional actualizada exitosamente.", nutricionActualizada));
        ctx.status(200);
    }

    private void eliminarNutricion(Context ctx) {
        String id = ctx.pathParam("id");
        nutricionService.eliminarNutricion(id);
        ctx.status(204);
    }
}