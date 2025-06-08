package org.galla.categorias;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/categorias", this::crear);
        app.get("/categorias", this::obtenerTodos);
        app.get("/categorias/{id}", this::obtenerPorId);
        app.put("/categorias/{id}", this::actualizar);
        app.delete("/categorias/{id}", this::eliminar);
    }

    private void crear(Context ctx) {
        Categoria categoria = ctx.bodyAsClass(Categoria.class);
        Categoria categoriaCreada = service.agregar(categoria);
        ctx.json(categoriaCreada);
        ctx.status(201);
    }

    private void obtenerTodos(Context ctx) {
        List<Categoria> categorias = service.obtenerTodos();
        ctx.json(categorias);
        ctx.status(200);
    }

    private void obtenerPorId(Context ctx) {
        String id = ctx.pathParam("id");
        Categoria categoria = service.obtenerPorId(id);
        ctx.json(categoria);
        ctx.status(200);
    }

    private void actualizar(Context ctx) {
        String id = ctx.pathParam("id");
        Categoria categoriaFromBody = ctx.bodyAsClass(Categoria.class);
        Categoria categoriaActualizada = service.actualizar(id, categoriaFromBody);
        ctx.json(categoriaActualizada);
        ctx.status(200);
    }

    private void eliminar(Context ctx) {
        String id = ctx.pathParam("id");
        service.eliminar(id);
        ctx.status(204);
    }
}
