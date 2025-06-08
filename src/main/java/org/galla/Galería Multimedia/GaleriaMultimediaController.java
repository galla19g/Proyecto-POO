package org.galla.multimedia;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class GaleriaMultimediaController {
    private final org.galla.multimedia.GaleriaMultimediaService multimediaService;

    public GaleriaMultimediaController(org.galla.multimedia.GaleriaMultimediaService multimediaService) {
        this.multimediaService = multimediaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/multimedia", this::crearMultimedia);
        app.get("/multimedia", this::obtenerTodoElMultimedia);
        app.get("/multimedia/{id}", this::obtenerMultimediaPorId);
        app.put("/multimedia/{id}", this::actualizarMultimedia);
        app.delete("/multimedia/{id}", this::eliminarMultimedia);
    }

    private void crearMultimedia(Context ctx) {
        GaleriaMultimedia multimedia = ctx.bodyAsClass(GaleriaMultimedia.class);
        GaleriaMultimedia multimediaCreado = multimediaService.agregarMultimedia(multimedia);
        ctx.json(new Mensaje<>("Multimedia creado exitosamente.", multimediaCreado));
        ctx.status(201);
    }

    private void obtenerTodoElMultimedia(Context ctx) {
        List<GaleriaMultimedia> multimedia = multimediaService.obtenerTodoElMultimedia();
        ctx.json(multimedia);
        ctx.status(200);
    }

    private void obtenerMultimediaPorId(@NotNull Context ctx) {
        String id = ctx.pathParam("id");
        GaleriaMultimedia multimedia = multimediaService.obtenerMultimediaPorId(id);
        ctx.json(multimedia);
        ctx.status(200);
    }

    private void actualizarMultimedia(Context ctx) {
        String id = ctx.pathParam("id");
        GaleriaMultimedia multimediaFromBody = ctx.bodyAsClass(GaleriaMultimedia.class);
        GaleriaMultimedia multimediaActualizado = multimediaService.actualizarMultimedia(id, multimediaFromBody);
        ctx.json(new Mensaje<>("Multimedia actualizado exitosamente.", multimediaActualizado));
        ctx.status(200);
    }

    private void eliminarMultimedia(Context ctx) {
        String id = ctx.pathParam("id");
        multimediaService.eliminarMultimedia(id);
        ctx.status(204);
    }
}