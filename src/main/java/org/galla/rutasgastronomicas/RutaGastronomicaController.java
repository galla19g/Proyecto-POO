package org.galla.rutasgastronomicas;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.util.List;

public class RutaGastronomicaController {
    private final RutaGastronomicaService service;

    public RutaGastronomicaController(RutaGastronomicaService service) {
        this.service = service;
    }

    public void configurarRutas(Javalin app) {
        app.post("/rutasgastronomicas", this::crear);
        app.get("/rutasgastronomicas", this::obtenerTodas);
        app.get("/rutasgastronomicas/{id}", this::obtenerPorId);
        app.put("/rutasgastronomicas/{id}", this::actualizar);
        app.delete("/rutasgastronomicas/{id}", this::eliminar);
    }

    private void crear(Context ctx) {
        RutaGastronomica ruta = ctx.bodyAsClass(RutaGastronomica.class);
        RutaGastronomica rutaCreada = service.agregar(ruta);
        ctx.json(rutaCreada);
        ctx.status(201);
    }

    private void obtenerTodas(Context ctx) {
        List<RutaGastronomica> rutas = service.obtenerTodas();
        ctx.json(rutas);
        ctx.status(200);
    }

    private void obtenerPorId(Context ctx) {
        String id = ctx.pathParam("id");
        RutaGastronomica ruta = service.obtenerPorId(id);
        ctx.json(ruta);
        ctx.status(200);
    }

    private void actualizar(Context ctx) {
        String id = ctx.pathParam("id");
        RutaGastronomica rutaFromBody = ctx.bodyAsClass(RutaGastronomica.class);
        RutaGastronomica rutaActualizada = service.actualizar(id, rutaFromBody);
        ctx.json(rutaActualizada);
        ctx.status(200);
    }

    private void eliminar(Context ctx) {
        String id = ctx.pathParam("id");
        service.eliminar(id);
        ctx.status(204);
    }
}