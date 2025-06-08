package org.galla.bebidas;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;

import java.util.List;

public class BebidaTipicaController {
    private final org.galla.bebidas.BebidaTipicaService bebidaService;

    public BebidaTipicaController(org.galla.bebidas.BebidaTipicaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/bebidas", this::crearBebida);
        app.get("/bebidas", this::obtenerTodasLasBebidas);
        app.get("/bebidas/{id}", this::obtenerBebidaPorId);
        app.put("/bebidas/{id}", this::actualizarBebida);
        app.delete("/bebidas/{id}", this::eliminarBebida);
    }

    private void crearBebida(Context ctx) {
        BebidaTipica bebida = ctx.bodyAsClass(BebidaTipica.class);
        BebidaTipica bebidaCreada = bebidaService.agregarBebida(bebida);
        ctx.json(new Mensaje<>("Bebida creada exitosamente.", bebidaCreada));
        ctx.status(201);
    }

    private void obtenerTodasLasBebidas(Context ctx) {
        List<BebidaTipica> bebidas = bebidaService.obtenerTodasLasBebidas();
        ctx.json(bebidas);
        ctx.status(200);
    }

    private void obtenerBebidaPorId(Context ctx) {
        String id = ctx.pathParam("id");
        BebidaTipica bebida = bebidaService.obtenerBebidaPorId(id);
        ctx.json(bebida);
        ctx.status(200);
    }

    private void actualizarBebida(Context ctx) {
        String id = ctx.pathParam("id");
        BebidaTipica bebidaFromBody = ctx.bodyAsClass(BebidaTipica.class);
        BebidaTipica bebidaActualizada = bebidaService.actualizarBebida(id, bebidaFromBody);
        ctx.json(new Mensaje<>("Bebida actualizada exitosamente.", bebidaActualizada));
        ctx.status(200);
    }

    private void eliminarBebida(Context ctx) {
        String id = ctx.pathParam("id");
        bebidaService.eliminarBebida(id);
        ctx.status(204);
    }
}