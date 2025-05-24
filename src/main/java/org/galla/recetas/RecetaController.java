package org.galla.recetas;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

import org.galla.compartidos.Mensaje;

public class RecetaController {
    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService){
        this.recetaService = recetaService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/recetas", this::guardarReceta);
        app.get("/recetas", this::obtenerTodasLasRecetas); 
        app.get("/recetas/{id}", this::obtenerRecetaPorId);
        app.delete("/recetas/{id}", this::eliminarReceta);
        app.put("/recetas/{id}", this::actualizarReceta);
    }
    
    public void guardarReceta(Context ctx){
        ctx.contentType("application/json");
        Receta receta = ctx.bodyAsClass(Receta.class);
        this.recetaService.agregarReceta(receta);
        ctx.json(receta);
        ctx.status(201);
    }

    public void obtenerTodasLasRecetas(Context ctx){
    ctx.contentType("application/json");
    List<Receta> recetas = this.recetaService.obtenerRecetas();
    ctx.json(recetas);
    ctx.status(201);  
    }

        public void obtenerRecetaPorId(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id");
        try {
            Receta receta = this.recetaService.obtenerReceta(id);
            ctx.json(receta);
            ctx.status(200);
        } catch (NumberFormatException e) {
            ctx.status(400).json(new Mensaje<>("El ID proporcionado no es un número válido.", null));
        }
    }

    public void eliminarReceta(Context ctx){
        String id = ctx.pathParam("id");
        this.recetaService.eliminarReceta(id);
        ctx.status(204);
    }

    public void actualizarReceta(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id"); // Obtiene el ID de la URL
        Receta recetaDelBody = ctx.bodyAsClass(Receta.class); // Obtiene los datos del cuerpo de la solicitud
        try {
            Receta recetaActualizada = this.recetaService.actualizarReceta(id, recetaDelBody);
            ctx.json(recetaActualizada);
            ctx.status(200); // OK
        } catch (NumberFormatException e) {
            ctx.status(400).json(new Mensaje<>("El ID proporcionado en la URL no es un número válido.", null));
        }

    }
}

