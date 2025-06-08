package org.galla.GlosarioGastronomico;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;

import java.util.List;

public class GlosarioGastronomicoController {
    private final org.galla.glosario.GlosarioGastronomicoService glosarioService;

    public GlosarioGastronomicoController(org.galla.glosario.GlosarioGastronomicoService glosarioService) {
        this.glosarioService = glosarioService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/glosario", this::crearTermino);
        app.get("/glosario", this::obtenerTodosLosTerminos);
        app.get("/glosario/{id}", this::obtenerTerminoPorId);
        app.put("/glosario/{id}", this::actualizarTermino);
        app.delete("/glosario/{id}", this::eliminarTermino);
    }

    private void crearTermino(Context ctx) {
        org.galla.glosario.GlosarioGastronomico termino;
        termino = ctx.bodyAsClass(org.galla.glosario.GlosarioGastronomico.class);
        org.galla.glosario.GlosarioGastronomico terminoCreado = glosarioService.agregarTermino(termino);
        ctx.json(new Mensaje<>("Término creado exitosamente.", terminoCreado));
        ctx.status(201);
    }

    private void obtenerTodosLosTerminos(Context ctx) {
        List<org.galla.glosario.GlosarioGastronomico> terminos = glosarioService.obtenerTodosLosTerminos();
        ctx.json(terminos);
        ctx.status(200);
    }

    private void obtenerTerminoPorId(Context ctx) {
        String id = ctx.pathParam("id");
        org.galla.glosario.GlosarioGastronomico termino = glosarioService.obtenerTerminoPorId(id);
        ctx.json(termino);
        ctx.status(200);
    }

    private void actualizarTermino(Context ctx) {
        String id = ctx.pathParam("id");
        GlosarioGastronomico terminoFromBody = ctx.bodyAsClass(GlosarioGastronomico.class);
        GlosarioGastronomico terminoActualizado = glosarioService.actualizarTermino(id, terminoFromBody);
        ctx.json(new Mensaje<>("Término actualizado exitosamente.", terminoActualizado));
        ctx.status(200);
    }

    private void eliminarTermino(Context ctx) {
        String id = ctx.pathParam("id");
        glosarioService.eliminarTermino(id);
        ctx.status(204);
    }
}