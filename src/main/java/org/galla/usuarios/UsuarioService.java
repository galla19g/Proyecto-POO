package org.galla.usuarios;

import java.util.List;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    private void validarUsuario(Usuario usuario) throws BadParameterException {
        if (usuario == null) {
            throw new BadParameterException("El objeto Usuario no puede ser nulo.");
        }
        if (usuario.getnombre() == null || usuario.getnombre().trim().isEmpty()) {
            throw new BadParameterException("El nombre del usuario no puede estar vacío.");
        }
        if (usuario.getapellido() == null || usuario.getapellido().trim().isEmpty()){
            throw new BadParameterException("El apellido del usuario no puede estar vacio");
        }
        if (usuario.getemail() == null || usuario.getemail().trim().isEmpty()) {
            throw new BadParameterException("El email del usuario no puede estar vacío.");
        }
        if (usuario.getcontraseña() == null || usuario.getcontraseña().trim().isEmpty()){
            throw new BadParameterException("La contraseña del usuario no puede estar vacia");
        }
    }

    public void agregarUsuario(Usuario usuario) {
        this.validarUsuario(usuario);
        this.usuarioRepository.agregarUsuario(usuario);
    }


    public void eliminarUsuario(String id) { 
        if (id == null) {
            throw new NotFoundException("No existe el usuario "); 
        } else {
            Usuario usuario = this.usuarioRepository.eliminarUsuarios(Integer.parseInt(id));
            if (usuario == null) { 
                throw new NotFoundException("No existe el usuario "); 
            }
        }
    }

    public Usuario actualizarUsuario(String idString, Usuario datosUsuarioActualizar) throws BadParameterException, NotFoundException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID del usuario para actualizar no puede ser nulo o vacío.");
        }
        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del usuario '" + idString + "' no es un número válido para actualizar.");
        }
        validarUsuario(datosUsuarioActualizar);
        datosUsuarioActualizar.setId(id);
        Usuario usuarioActualizadoEnRepo = this.usuarioRepository.actualizarUsuario(id, datosUsuarioActualizar);

        if (usuarioActualizadoEnRepo == null) {
            throw new NotFoundException("No se encontró el usuario con ID: " + id + " para actualizar.");
        }
        return usuarioActualizadoEnRepo;
    }

    public Usuario obtenerUsuario(String id) {
    if (id == null) {
        throw new NotFoundException("No existe el usuario ");
    } else {
        return this.usuarioRepository.obtenerUsuario(Integer.parseInt(id));
            }

    }

    public List<Usuario> obtenerUsuarios() {
        return this.usuarioRepository.obtenerUsuario();
    }
}