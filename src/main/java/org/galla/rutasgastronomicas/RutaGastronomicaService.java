package org.galla.rutasgastronomicas;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;
import java.util.List;

public class RutaGastronomicaService {
    private final RutaGastronomicaRepository repository;

    public RutaGastronomicaService(RutaGastronomicaRepository repository) {
        this.repository = repository;
    }

    private void validar(RutaGastronomica ruta) throws BadParameterException {
        if (ruta == null) {
            throw new BadParameterException("La ruta gastronómica no puede ser nula.");
        }
        if (ruta.getNombre() == null || ruta.getNombre().trim().isEmpty()) {
            throw new BadParameterException("El nombre de la ruta no puede ser nulo o vacío.");
        }
        if (ruta.getParadas() == null || ruta.getParadas().isEmpty()) {
            throw new BadParameterException("La ruta debe tener al menos una parada.");
        }
    }

    public RutaGastronomica agregar(RutaGastronomica ruta) {
        validar(ruta);
        return this.repository.agregar(ruta);
    }

    public void eliminar(String idString) {
        try {
            int id = Integer.parseInt(idString);
            RutaGastronomica ruta = this.repository.eliminar(id);
            if (ruta == null) {
                throw new NotFoundException("No se encontró una ruta gastronómica con el ID " + id);
            }
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la ruta debe ser un número.");
        }
    }

    public RutaGastronomica actualizar(String idString, RutaGastronomica ruta) {
        try {
            int id = Integer.parseInt(idString);
            validar(ruta);
            RutaGastronomica actualizada = this.repository.actualizar(id, ruta);
            if (actualizada == null) {
                throw new NotFoundException("No se encontró una ruta con el ID " + id + " para actualizar.");
            }
            return actualizada;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la ruta debe ser un número.");
        }
    }

    public RutaGastronomica obtenerPorId(String idString) {
        try {
            int id = Integer.parseInt(idString);
            RutaGastronomica ruta = this.repository.obtenerPorId(id);
            if (ruta == null) {
                throw new NotFoundException("No se encontró una ruta con el ID " + id);
            }
            return ruta;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la ruta debe ser un número.");
        }
    }

    public List<RutaGastronomica> obtenerTodas() {
        return this.repository.obtenerTodas();
    }
}