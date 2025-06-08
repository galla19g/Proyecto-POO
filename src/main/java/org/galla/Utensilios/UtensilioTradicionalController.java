package org.galla.Utensilios;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;

import java.util.List;

public class UtensilioTradicionalController {
    private final UtensilioTradicionalService utensilioService;

    public UtensilioTradicionalController(UtensilioTradicionalService utensilioService) {
        this.utensilioService = utensilioService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/utensilios", this::crearUtensilio);
        app.get("/utensilios", this::obtenerTodosLosUtensilios);
        app.get("/utensilios/{id}", this::obtenerUtensilioPorId);
        app.put("/utensilios/{id}", this::actualizarUtensilio);
        app.delete("/utensilios/{id}", this::eliminarUtensilio);
    }

    private void crearUtensilio(Context ctx) {
        UtensilioTradicional utensilio = ctx.bodyAsClass(UtensilioTradicional.class);
        UtensilioTradicional utensilioCreado = utensilioService.agregarUtensilio(utensilio);
        ctx.json(new Mensaje<>("Utensilio creado exitosamente.", utensilioCreado));
        ctx.status(201);
    }

    private void obtenerTodosLosUtensilios(Context ctx) {
        List<UtensilioTradicional> utensilios = utensilioService.obtenerTodosLosUtensilios();
        ctx.json(utensilios);
        ctx.status(200);
    }

    private void obtenerUtensilioPorId(Context ctx) {
        String id = ctx.pathParam("id");
        UtensilioTradicional utensilio = utensilioService.obtenerUtensilioPorId(id);
        ctx.json(utensilio);
        ctx.status(200);
    }

    private void actualizarUtensilio(Context ctx) {
        String id = ctx.pathParam("id");
        UtensilioTradicional utensilioFromBody = ctx.bodyAsClass(UtensilioTradicional.class);
        UtensilioTradicional utensilioActualizado = utensilioService.actualizarUtensilio(id, utensilioFromBody);
        ctx.json(new Mensaje<>("Utensilio actualizado exitosamente.", utensilioActualizado));
        ctx.status(200);
    }

    private void eliminarUtensilio(Context ctx) {
        String id = ctx.pathParam("id");
        utensilioService.eliminarUtensilio(id);
        ctx.status(204);
    }
}