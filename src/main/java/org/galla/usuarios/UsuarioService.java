package org.galla.usuarios;

import java.util.List;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

public class UsuarioService {
    private final UsuarioRepository usuariosRepository;
    
    public UsuarioService(UsuarioRepository usuariosrepository){
        this.usuariosRepository = usuariosrepository;
    }

    public void validarUsuarios(Usuario usuarios) throws BadParameterException{
        if (usuarios == null){
            throw new BadParameterException("El usuario no puede ser nulo");
        }
        if (usuarios.getusername() == null || usuarios.getusername().trim().isEmpty()){
            throw new BadParameterException("El nombre del usuario no puede ser nulo o vacio");
        }
        if (usuarios.getapellido() == null || usuarios.getapellido().trim().isEmpty()){
            throw new BadParameterException("El apellido del usuario no puede ser nulo o vacio");
        }
        if (usuarios.getcontraseña() == null || usuarios.getcontraseña().trim().isEmpty()){
            throw new BadParameterException("La contraseña del usuario no puede ser nula o vacia");
        }
        if (usuarios.getemail() == null || usuarios.getemail().trim().isEmpty()){
            throw new BadParameterException("El email del usuario no puede ser nulo o vacio");
        }
    }

    public void agregarUsuario(Usuario usuario){
        this.validarUsuarios(usuario);
        this.usuariosRepository.agregarUsuario(usuario);
    }

    public void eliminarUsuarios(String id ){
        if (id == null){
            throw new NotFoundException("No existe el id de la usuario");
        }else {
            Usuario usuarios = this.usuariosRepository.eliminarUsuarios(Integer.parseInt(id));
            if (usuarios == null){
                throw new NotFoundException("No existe esa receta que buscaste");
            }
        }
    }

    public Usuario actualizarUsuario(String idString , Usuario datosUsuariosActualizar) throws BadParameterException, NotFoundException{
        if (idString == null){
            throw new NotFoundException ("no existe ese id de algun usuario para actualizar");
        }
        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de usuario" + idString + " no es un usuario valido que se pueda actualizar");
        }

        validarUsuarios(datosUsuariosActualizar);
        datosUsuariosActualizar.setId(id);
        Usuario usuarioActualizadaEnRepo = this.usuariosRepository.actualizarUsuario(id, datosUsuariosActualizar);

        if (usuarioActualizadaEnRepo == null){
            throw new NotFoundException("No se encontro un usuarios con el id" + id + "para actualziar");
        }
        return usuarioActualizadaEnRepo;
    }

    public Usuario obtenerUsuario(String id){
        if (id == null){
            throw new NotFoundException("No existe esa usuario que buscaste");
        } else {
            return this.usuariosRepository.obtenerUsuario(Integer.parseInt(id));
        }
    }

    public List<Usuario> obtenerUsuarios(){
        return this.usuariosRepository.obtenerUsuario();
    }
}


