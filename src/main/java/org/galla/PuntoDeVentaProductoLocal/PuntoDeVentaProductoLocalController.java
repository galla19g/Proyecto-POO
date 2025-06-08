package org.galla.puntosdeventa;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;

import java.util.List;

public class PuntoDeVentaProductoLocalController {
    private final PuntoDeVentaProductoLocalService puntoDeVentaService;

    public PuntoDeVentaProductoLocalController(PuntoDeVentaProductoLocalService puntoDeVentaService) {
        this.puntoDeVentaService = puntoDeVentaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/puntosdeventa", this::crearPuntoDeVenta);
        app.get("/puntosdeventa", this::obtenerTodosLosPuntosDeVenta);
        app.get("/puntosdeventa/{id}", this::obtenerPuntoDeVentaPorId);
        app.put("/puntosdeventa/{id}", this::actualizarPuntoDeVenta);
        app.delete("/puntosdeventa/{id}", this::eliminarPuntoDeVenta);
    }

    private void crearPuntoDeVenta(Context ctx) {
        PuntoDeVentaProductoLocal puntoDeVenta = ctx.bodyAsClass(PuntoDeVentaProductoLocal.class);
        PuntoDeVentaProductoLocal puntoDeVentaCreado = puntoDeVentaService.agregarPuntoDeVenta(puntoDeVenta);
        ctx.json(new Mensaje<>("Punto de venta creado exitosamente.", puntoDeVentaCreado));
        ctx.status(201);
    }

    private void obtenerTodosLosPuntosDeVenta(Context ctx) {
        List<PuntoDeVentaProductoLocal> puntosDeVenta = puntoDeVentaService.obtenerTodosLosPuntosDeVenta();
        ctx.json(puntosDeVenta);
        ctx.status(200);
    }

    private void obtenerPuntoDeVentaPorId(Context ctx) {
        String id = ctx.pathParam("id");
        PuntoDeVentaProductoLocal puntoDeVenta = puntoDeVentaService.obtenerPuntoDeVentaPorId(id);
        ctx.json(puntoDeVenta);
        ctx.status(200);
    }

    private void actualizarPuntoDeVenta(Context ctx) {
        String id = ctx.pathParam("id");
        PuntoDeVentaProductoLocal puntoDeVentaFromBody = ctx.bodyAsClass(PuntoDeVentaProductoLocal.class);
        PuntoDeVentaProductoLocal puntoDeVentaActualizado = puntoDeVentaService.actualizarPuntoDeVenta(id, puntoDeVentaFromBody);
        ctx.json(new Mensaje<>("Punto de venta actualizado exitosamente.", puntoDeVentaActualizado));
        ctx.status(200);
    }

    private void eliminarPuntoDeVenta(Context ctx) {
        String id = ctx.pathParam("id");
        puntoDeVentaService.eliminarPuntoDeVenta(id);
        ctx.status(204);
    }
}