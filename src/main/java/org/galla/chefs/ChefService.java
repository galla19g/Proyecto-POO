package org.galla.chefs;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;
import java.util.List;

public class ChefService {
    private final ChefRepository repository;

    public ChefService(ChefRepository repository) {
        this.repository = repository;
    }

    private void validar(Chef chef) throws BadParameterException {
        if (chef == null) {
            throw new BadParameterException("El chef no puede ser nulo.");
        }
        if (chef.getnombrecompleto() == null || chef.getnombrecompleto().trim().isEmpty()) {
            throw new BadParameterException("El nombre del chef no puede ser nulo o vacío.");
        }
        if (chef.getbiografia() == null || chef.getbiografia().trim().isEmpty()){
            throw new BadParameterException("La biografia del chef no puede ser nula o vacia");
        }
        if (chef.getespecialidad() == null || chef.getespecialidad().trim().isEmpty()) {
            throw new BadParameterException("La especialidad del chef no puede ser nula o vacía.");
        }
        if (chef.getcontacto() == null || chef.getcontacto().trim().isEmpty()){
            throw new BadParameterException("EL contacto del chef no puede ser nulo o vacio");
        }
    }

    public Chef agregar(Chef chef) {
        validar(chef);
        return this.repository.agregar(chef);
    }

    public void eliminar(String idString) {
        try {
            int id = Integer.parseInt(idString);
            Chef chef = this.repository.eliminar(id);
            if (chef == null) {
                throw new NotFoundException("No se encontró un chef con el ID " + id);
            }
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del chef debe ser un número.");
        }
    }

    public Chef actualizar(String idString, Chef chef) {
        try {
            int id = Integer.parseInt(idString);
            validar(chef);
            Chef actualizado = this.repository.actualizar(id, chef);
            if (actualizado == null) {
                throw new NotFoundException("No se encontró un chef con el ID " + id + " para actualizar.");
            }
            return actualizado;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del chef debe ser un número.");
        }
    }

    public Chef obtenerPorId(String idString) {
        try {
            int id = Integer.parseInt(idString);
            Chef chef = this.repository.obtenerPorId(id);
            if (chef == null) {
                throw new NotFoundException("No se encontró un chef con el ID " + id);
            }
            return chef;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del chef debe ser un número.");
        }
    }

    public List<Chef> obtenerTodos() {
        return this.repository.obtenerTodos();
    }
}