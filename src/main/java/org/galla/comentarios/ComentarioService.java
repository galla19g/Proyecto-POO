package org.galla.comentarios;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;
import java.util.List;

public class ComentarioService {
    private final ComentarioRepository repository;

    public ComentarioService(ComentarioRepository repository) {
        this.repository = repository;
    }

    private void validar(Comentario comentario) throws BadParameterException {
        if (comentario == null) {
            throw new BadParameterException("El comentario no puede ser nulo.");
        }
        if (comentario.getTexto() == null || comentario.getTexto().trim().isEmpty()) {
            throw new BadParameterException("El texto del comentario no puede ser nulo o vacío.");
        }
        if (comentario.getValoracion() < 1 || comentario.getValoracion() > 5) {
            throw new BadParameterException("La valoración debe estar entre 1 y 5.");
        }
        if (comentario.getUsuarioId() <= 0) {
            throw new BadParameterException("El ID del usuario es inválido.");
        }
        if (comentario.getElementoAsociadoId() <= 0) {
            throw new BadParameterException("El ID del elemento asociado es inválido.");
        }
        if (comentario.getTipoElementoAsociado() == null || comentario.getTipoElementoAsociado().trim().isEmpty()) {
            throw new BadParameterException("El tipo de elemento asociado no puede ser nulo o vacío.");
        }
    }

    public Comentario agregar(Comentario comentario) {
        validar(comentario);
        return this.repository.agregar(comentario);
    }

    public void eliminar(String idString) {
        try {
            int id = Integer.parseInt(idString);
            Comentario comentario = this.repository.eliminar(id);
            if (comentario == null) {
                throw new NotFoundException("No se encontró un comentario con el ID " + id);
            }
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del comentario debe ser un número.");
        }
    }

    public Comentario actualizar(String idString, Comentario comentario) {
        try {
            int id = Integer.parseInt(idString);
            validar(comentario);
            Comentario actualizado = this.repository.actualizar(id, comentario);
            if (actualizado == null) {
                throw new NotFoundException("No se encontró un comentario con el ID " + id + " para actualizar.");
            }
            return actualizado;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del comentario debe ser un número.");
        }
    }

    public Comentario obtenerPorId(String idString) {
        try {
            int id = Integer.parseInt(idString);
            Comentario comentario = this.repository.obtenerPorId(id);
            if (comentario == null) {
                throw new NotFoundException("No se encontró un comentario con el ID " + id);
            }
            return comentario;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del comentario debe ser un número.");
        }
    }

    public List<Comentario> obtenerTodos() {
        return this.repository.obtenerTodos();
    }
}