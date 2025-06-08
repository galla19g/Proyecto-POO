package org.galla.comentarios;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public class ComentarioController {
    private final ComentarioService service;

    public ComentarioController(ComentarioService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/comentarios", this::crear);
        app.get("/comentarios", this::obtenerTodos);
        app.get("/comentarios/{id}", this::obtenerPorId);
        app.put("/comentarios/{id}", this::actualizar);
        app.delete("/comentarios/{id}", this::eliminar);
    }

    private void crear(Context ctx) {
        Comentario comentario = ctx.bodyAsClass(Comentario.class);
        Comentario comentarioCreado = service.agregar(comentario);
        ctx.json(comentarioCreado);
        ctx.status(201);
    }

    private void obtenerTodos(Context ctx) {
        List<Comentario> comentarios = service.obtenerTodos();
        ctx.json(comentarios);
        ctx.status(200);
    }

    private void obtenerPorId(Context ctx) {
        String id = ctx.pathParam("id");
        Comentario comentario = service.obtenerPorId(id);
        ctx.json(comentario);
        ctx.status(200);
    }

    private void actualizar(Context ctx) {
        String id = ctx.pathParam("id");
        Comentario comentarioFromBody = ctx.bodyAsClass(Comentario.class);
        Comentario comentarioActualizado = service.actualizar(id, comentarioFromBody);
        ctx.json(comentarioActualizado);
        ctx.status(200);
    }

    private void eliminar(Context ctx) {
        String id = ctx.pathParam("id");
        service.eliminar(id);
        ctx.status(204);
    }
}