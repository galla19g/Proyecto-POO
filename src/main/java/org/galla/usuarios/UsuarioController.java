package org.galla.usuarios;

import io.javalin.Javalin;
import io.javalin.http.Context;

import java.util.List;

import org.galla.compartidos.Mensaje;

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    public void configurarRutas(Javalin app) {
        app.post("/usuarios", this::guardarUsuario);
        app.get("/usuarios", this::obtenerTodasLosUsuarios); 
        app.get("/usuarios/{id}", this::obtenerUsuarioPorId);
        app.delete("/usuarios/{id}", this::eliminarUsuario);
        app.put("/usuarios/{id}", this::actualizarUsuario);
    }
    
    public void guardarUsuario(Context ctx){
        ctx.contentType("application/json");
        Usuario usuario = ctx.bodyAsClass(Usuario.class);
        this.usuarioService.agregarUsuario(usuario);
        ctx.json(usuario);
        ctx.status(201);
    }

    public void obtenerTodasLosUsuarios(Context ctx){
    ctx.contentType("application/json");
    List<Usuario> usuarios = this.usuarioService.obtenerUsuarios();
    ctx.json(usuarios);
    ctx.status(201);  
    }

        public void obtenerUsuarioPorId(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id");
        try {
            Usuario usuario = this.usuarioService.obtenerUsuario(id);
            ctx.json(usuario);
            ctx.status(200);
        } catch (NumberFormatException e) {
            ctx.status(400).json(new Mensaje<>("El ID proporcionado no es un número válido.", null));
        }
    }

    public void eliminarUsuario(Context ctx){
        String id = ctx.pathParam("id");
        this.usuarioService.eliminarUsuarios(id);
        ctx.status(204);
    }

    public void actualizarUsuario(Context ctx) {
        ctx.contentType("application/json");
        String id = ctx.pathParam("id"); // Obtiene el ID de la URL
        Usuario usuarioDelBody = ctx.bodyAsClass(Usuario.class); // Obtiene los datos del cuerpo de la solicitud
        try {
            Usuario usuarioActualizada = this.usuarioService.actualizarUsuario(id, usuarioDelBody);
            ctx.json(usuarioActualizada);
            ctx.status(200); // OK
        } catch (NumberFormatException e) {
            ctx.status(400).json(new Mensaje<>("El ID proporcionado en la URL no es un número válido.", null));
        }

    }
}

