package org.galla.chefs;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public class ChefController {
    private final ChefService service;

    public ChefController(ChefService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/chefs", this::crear);
        app.get("/chefs", this::obtenerTodos);
        app.get("/chefs/{id}", this::obtenerPorId);
        app.put("/chefs/{id}", this::actualizar);
        app.delete("/chefs/{id}", this::eliminar);
    }

    private void crear(Context ctx) {
        Chef chef = ctx.bodyAsClass(Chef.class);
        Chef chefCreado = service.agregar(chef);
        ctx.json(chefCreado);
        ctx.status(201);
    }

    private void obtenerTodos(Context ctx) {
        List<Chef> chefs = service.obtenerTodos();
        ctx.json(chefs);
        ctx.status(200);
    }

    private void obtenerPorId(Context ctx) {
        String id = ctx.pathParam("id");
        Chef chef = service.obtenerPorId(id);
        ctx.json(chef);
        ctx.status(200);
    }

    private void actualizar(Context ctx) {
        String id = ctx.pathParam("id");
        Chef chefFromBody = ctx.bodyAsClass(Chef.class);
        Chef chefActualizado = service.actualizar(id, chefFromBody);
        ctx.json(chefActualizado);
        ctx.status(200);
    }

    private void eliminar(Context ctx) {
        String id = ctx.pathParam("id");
        service.eliminar(id);
        ctx.status(204);
    }
}