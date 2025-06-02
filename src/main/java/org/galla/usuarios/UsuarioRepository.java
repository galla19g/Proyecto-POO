package org.galla.usuarios;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class UsuarioRepository {
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final AtomicInteger id = new AtomicInteger(1);

    public void agregarUsuario(Usuario usuario){
        usuario.setId(this.id.incrementAndGet());
        this.usuarios.add(usuario);    
    }

    public Usuario eliminarUsuarios(int id){
        Usuario usuarioeliminado = null;
        for (int i = 0; i < this.usuarios.size(); i++) {
            if (this.usuarios.get(i).getId() == id) {
                usuarioeliminado =this.usuarios.remove(i);
                break;
            }
        }return usuarioeliminado;
    }

    public Usuario actualizarUsuario(int id, Usuario usuarioActualizado){
        for(int i = 0; i < this.usuarios.size(); i++){
            if(this.usuarios.get(i).getId() == id){
                this.usuarios.set(i, usuarioActualizado);
                return usuarioActualizado;
            }
        }return null;
    }

    public Usuario obtenerUsuario(int id){
        for (Usuario usuario : this.usuarios){
            if(usuario.getId() == id){
                return usuario;
            }
        }return null;
    }


    public ArrayList<Usuario> obtenerUsuario(){
        return this.usuarios;
    }
}
