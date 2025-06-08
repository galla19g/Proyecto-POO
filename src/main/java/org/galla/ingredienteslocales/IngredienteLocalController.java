package org.galla.ingredienteslocales;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public class IngredienteLocalController {
    private final IngredienteLocalService service;

    public IngredienteLocalController(IngredienteLocalService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/ingredienteslocales", this::crear);
        app.get("/ingredienteslocales", this::obtenerTodos);
        app.get("/ingredienteslocales/{id}", this::obtenerPorId);
        app.put("/ingredienteslocales/{id}", this::actualizar);
        app.delete("/ingredienteslocales/{id}", this::eliminar);
    }

    private void crear(Context ctx) {
        IngredienteLocal ingrediente = ctx.bodyAsClass(IngredienteLocal.class);
        IngredienteLocal ingredienteCreado = service.agregar(ingrediente);
        ctx.json(ingredienteCreado);
        ctx.status(201);
    }

    private void obtenerTodos(Context ctx) {
        List<IngredienteLocal> ingredientes = service.obtenerTodos();
        ctx.json(ingredientes);
        ctx.status(200);
    }

    private void obtenerPorId(Context ctx) {
        String id = ctx.pathParam("id");
        IngredienteLocal ingrediente = service.obtenerPorId(id);
        ctx.json(ingrediente);
        ctx.status(200);
    }

    private void actualizar(Context ctx) {
        String id = ctx.pathParam("id");
        IngredienteLocal ingredienteFromBody = ctx.bodyAsClass(IngredienteLocal.class);
        IngredienteLocal ingredienteActualizado = service.actualizar(id, ingredienteFromBody);
        ctx.json(ingredienteActualizado);
        ctx.status(200);
    }

    private void eliminar(Context ctx) {
        String id = ctx.pathParam("id");
        service.eliminar(id);
        ctx.status(204);
    }
}