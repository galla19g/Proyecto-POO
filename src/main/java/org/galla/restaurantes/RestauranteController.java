package org.galla.restaurantes;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

import org.galla.compartidos.Mensaje;

public class RestauranteController {
    private final RestauranteService restauranteService;

    public RestauranteController(RestauranteService restauranteService){
        this.restauranteService = restauranteService;
    }

    public void configurarRutas(Javalin app){
        app.post("/restaurantes", this::guardarRestaurante);
        app.get("/restaurantes", this::obtenerTodosLosRestaurantes);
        app.get("/restaurantes/{id}", this::obtenerRestaurantePorId);
        app.delete("/restaurantes/{id}", this::eliminarRestaurante);
        app.put("/restaurantes/{id}", this::actualizarRestaurante);
    }
    
    public void guardarRestaurante(Context ctx){
        ctx.contentType("application/json");
        Restaurante restaurante = ctx.bodyAsClass(Restaurante.class);
        this.restauranteService.agregarRestaurante(restaurante);
        ctx.json(restaurante);
        ctx.status(201);
    }

    public void obtenerTodosLosRestaurantes(Context ctx){
        ctx.contentType("application/json");
        List<Restaurante> restaurantes = this.restauranteService.obtenerRestaurantes();
        ctx.json(restaurantes);
        ctx.status(201);
    }

    public void obtenerRestaurantePorId(Context ctx){
        ctx.contentType("application/json");
        String id = ctx.pathParam("id");
        try {
            Restaurante restaurante = this.restauranteService.obtenerRestaurante(id);
            ctx.json(restaurante);
            ctx.status(200);
        } catch (NumberFormatException e) {
            ctx.status(400).json(new Mensaje<>("El ID proporcionado no es un número válido.", null));
        }
    }

    public void eliminarRestaurante(Context ctx){
        String id = ctx.pathParam("id");
        this.restauranteService.eliminarRestaurante(id);
        ctx.status(204);
        }
    
        public void actualizarRestaurante(Context ctx){
            ctx.contentType("application/json");
            String id = ctx.pathParam("id");
            Restaurante restauranteDelBody = ctx.bodyAsClass(Restaurante.class);
            try {
                Restaurante restauranteActualizado = this.restauranteService.actualizarRestaurante(id, restauranteDelBody);
                ctx.json(restauranteActualizado);
                ctx.status(200);
            }   catch (NumberFormatException e){
                ctx.status(400).json(new Mensaje<>("El ID proporcionado en la URL no es un numero valido.", null));
            }
        }
}
