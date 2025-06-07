package org.galla.eventosgastronomicos;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.galla.compartidos.Mensaje;


import java.util.List;

public class EventogastronomicoController {
    private final EventogastronomicoService eventogastronomicoService;

    public EventogastronomicoController(EventogastronomicoService eventogastronomicoService){
        this.eventogastronomicoService = eventogastronomicoService;
    }

    public void configurarRutas(Javalin app){
        app.post("/eventos", this::crearEvento);
        app.get("/eventos", this::obtenerTodosLosEventos);
        app.get("/eventos/{id}",this::obtenerEventoPorId);
        app.put("/eventos/{id}", this::actualizarEvento);
        app.delete("/eventos/{id}",this::eliminarEvento);
    }

    public void crearEvento(Context ctx){
        Eventogastronomico evento = ctx.bodyAsClass(Eventogastronomico.class);
        Eventogastronomico eventoCreado = eventogastronomicoService.agregarEvento(evento);
        ctx.json(new Mensaje <>("El evento gastronomico se ha creado con exito", eventoCreado));
        ctx.status(201);
    }

    public void obtenerTodosLosEventos(Context ctx){
        List<Eventogastronomico> eventos = eventogastronomicoService.obtenerEventos();
        ctx.json(eventos);
        ctx.status(200);
    }

    public void obtenerEventoPorId(Context ctx){
        String id = ctx.pathParam("id");
        Eventogastronomico evento = eventogastronomicoService.obtenerEventogastronomico(id);
        ctx.json(evento);
        ctx.status(200);
    }

    public void actualizarEvento(Context ctx){
        String id = ctx.pathParam("id");
        Eventogastronomico eventoFromBody = ctx.bodyAsClass(Eventogastronomico.class);
        Eventogastronomico eventoactualizado = eventogastronomicoService.actualizarEventoGastronomico(id, eventoFromBody);
        ctx.json(new Mensaje<>("El evento gastronomico se ha actualizado con exito", eventoactualizado));
        ctx.status(200);
    }

    public void eliminarEvento(Context ctx){
        String id = ctx.pathParam("id");
        eventogastronomicoService.eliminarEventoGastronomico(id);
        ctx.status(204);
    }
}
