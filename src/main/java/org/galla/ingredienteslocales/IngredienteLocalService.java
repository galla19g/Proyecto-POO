package org.galla.ingredienteslocales;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class IngredienteLocalService {
    private final IngredienteLocalRepository repository;

    public IngredienteLocalService(IngredienteLocalRepository repository) {
        this.repository = repository;
    }

    private void validar(IngredienteLocal ingrediente) throws BadParameterException {
        if (ingrediente == null) {
            throw new BadParameterException("El ingrediente local no puede ser nulo.");
        }
        if (ingrediente.getNombreComunLocal() == null || ingrediente.getNombreComunLocal().trim().isEmpty()) {
            throw new BadParameterException("El nombre común local del ingrediente no puede ser nulo o vacío.");
        }
        if (ingrediente.getDescripcionCultural() == null || ingrediente.getDescripcionCultural().trim().isEmpty()) {
            throw new BadParameterException("La descripción cultural del ingrediente no puede ser nula o vacía.");
        }
    }

    public IngredienteLocal agregar(IngredienteLocal ingrediente) {
        validar(ingrediente);
        return this.repository.agregar(ingrediente);
    }

    public void eliminar(String idString) {
        try {
            int id = Integer.parseInt(idString);
            IngredienteLocal ingrediente = this.repository.eliminar(id);
            if (ingrediente == null) {
                throw new NotFoundException("No se encontró un ingrediente local con el ID " + id);
            }
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del ingrediente local debe ser un número.");
        }
    }

    public IngredienteLocal actualizar(String idString, IngredienteLocal ingrediente) {
        try {
            int id = Integer.parseInt(idString);
            validar(ingrediente);
            IngredienteLocal actualizado = this.repository.actualizar(id, ingrediente);
            if (actualizado == null) {
                throw new NotFoundException("No se encontró un ingrediente local con el ID " + id + " para actualizar.");
            }
            return actualizado;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del ingrediente local debe ser un número.");
        }
    }

    public IngredienteLocal obtenerPorId(String idString) {
        try {
            int id = Integer.parseInt(idString);
            IngredienteLocal ingrediente = this.repository.obtenerPorId(id);
            if (ingrediente == null) {
                throw new NotFoundException("No se encontró un ingrediente local con el ID " + id);
            }
            return ingrediente;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del ingrediente local debe ser un número.");
        }
    }

    public List<IngredienteLocal> obtenerTodos() {
        return this.repository.obtenerTodos();
    }
}


