package org.galla.mercado;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;

import java.util.List;

public class MercadoLocalController {
    private final MercadoLocalService mercadoLocalService;

    public MercadoLocalController(MercadoLocalService mercadoLocalService) {
        this.mercadoLocalService = mercadoLocalService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/mercadoslocales", this::crearMercadoLocal);
        app.get("/mercadoslocales", this::obtenerTodosLosMercadosLocales);
        app.get("/mercadoslocales/{id}", this::obtenerMercadoLocalPorId);
        app.put("/mercadoslocales/{id}", this::actualizarMercadoLocal);
        app.delete("/mercadoslocales/{id}", this::eliminarMercadoLocal);
    }

    private void crearMercadoLocal(Context ctx) {
        MercadoLocal mercado = ctx.bodyAsClass(MercadoLocal.class);
        MercadoLocal mercadoCreado = mercadoLocalService.agregarMercado(mercado);
        ctx.json(new Mensaje<>("Mercado local creado exitosamente.", mercadoCreado)); 
        ctx.status(201);
    }

    private void obtenerTodosLosMercadosLocales(Context ctx) {
        List<MercadoLocal> mercados = mercadoLocalService.obtenerTodosLosMercados();
        ctx.json(mercados);
        ctx.status(200);
    }

    private void obtenerMercadoLocalPorId(Context ctx) {
        String id = ctx.pathParam("id");
        MercadoLocal mercado = mercadoLocalService.obtenerMercadoPorId(id);
        ctx.json(mercado);
        ctx.status(200);
    }

    private void actualizarMercadoLocal(Context ctx) {
        String id = ctx.pathParam("id");
        MercadoLocal mercadoFromBody = ctx.bodyAsClass(MercadoLocal.class);
        MercadoLocal mercadoActualizado = mercadoLocalService.actualizarMercado(id, mercadoFromBody);
        ctx.json(new Mensaje<>("Mercado local actualizado exitosamente.", mercadoActualizado));
        ctx.status(200);
    }

    private void eliminarMercadoLocal(Context ctx) {
        String id = ctx.pathParam("id");
        mercadoLocalService.eliminarMercado(id);
        ctx.status(204); // No content
    }
}