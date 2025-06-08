package org.galla.ComunidadIndigenaGastronomica;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;

import java.util.List;

public class ComunidadIndigenaGastronomicaController {
    private final ComunidadIndigenaGastronomicaService comunidadService;

    public ComunidadIndigenaGastronomicaController(ComunidadIndigenaGastronomicaService comunidadService) {
        this.comunidadService = comunidadService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/comunidades", this::crearComunidad);
        app.get("/comunidades", this::obtenerTodasLasComunidades);
        app.get("/comunidades/{id}", this::obtenerComunidadPorId);
        app.put("/comunidades/{id}", this::actualizarComunidad);
        app.delete("/comunidades/{id}", this::eliminarComunidad);
    }

    private void crearComunidad(Context ctx) {
        ComunidadIndigenaGastronomia comunidad = ctx.bodyAsClass(ComunidadIndigenaGastronomia.class);
        ComunidadIndigenaGastronomia comunidadCreada = comunidadService.agregarComunidad(comunidad);
        ctx.json(new Mensaje<>("Comunidad creada exitosamente.", comunidadCreada));
        ctx.status(201);
    }

    private void obtenerTodasLasComunidades(Context ctx) {
        List<ComunidadIndigenaGastronomia> comunidades = comunidadService.obtenerTodasLasComunidades();
        ctx.json(comunidades);
        ctx.status(200);
    }

    private void obtenerComunidadPorId(Context ctx) {
        String id = ctx.pathParam("id");
        ComunidadIndigenaGastronomia comunidad = comunidadService.obtenerComunidadPorId(id);
        ctx.json(comunidad);
        ctx.status(200);
    }

    private void actualizarComunidad(Context ctx) {
        String id = ctx.pathParam("id");
        ComunidadIndigenaGastronomia comunidadFromBody = ctx.bodyAsClass(ComunidadIndigenaGastronomia.class);
        ComunidadIndigenaGastronomia comunidadActualizada = comunidadService.actualizarComunidad(id, comunidadFromBody);
        ctx.json(new Mensaje<>("Comunidad actualizada exitosamente.", comunidadActualizada));
        ctx.status(200);
    }

    private void eliminarComunidad(Context ctx) {
        String id = ctx.pathParam("id");
        comunidadService.eliminarComunidad(id);
        ctx.status(204);
    }
}
