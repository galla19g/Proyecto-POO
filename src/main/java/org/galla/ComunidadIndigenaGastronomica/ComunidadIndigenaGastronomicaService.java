package org.galla.ComunidadIndigenaGastronomica;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class ComunidadIndigenaGastronomicaService {
    private final ComunidadIndigenaGastronomiaRepository comunidadRepository;

    public ComunidadIndigenaGastronomicaService(ComunidadIndigenaGastronomiaRepository comunidadRepository) {
        this.comunidadRepository = comunidadRepository;
    }

    private void validarComunidad(ComunidadIndigenaGastronomia comunidad) throws BadParameterException {
        if (comunidad == null) {
            throw new BadParameterException("El objeto ComunidadIndigenaGastronomia no puede ser nulo.");
        }
        if (comunidad.getNombreComunidad() == null || comunidad.getNombreComunidad().trim().isEmpty()) {
            throw new BadParameterException("El nombre de la comunidad no puede ser nulo o vacío.");
        }
        if (comunidad.getZonaGeograficaDeInfluencia() == null || comunidad.getZonaGeograficaDeInfluencia().trim().isEmpty()) {
            throw new BadParameterException("La zona geográfica de influencia no puede ser nula o vacía.");
        }
    }

    public ComunidadIndigenaGastronomia agregarComunidad(ComunidadIndigenaGastronomia comunidad) throws BadParameterException {
        validarComunidad(comunidad);
        return comunidadRepository.agregarComunidad(comunidad);
    }

    public void eliminarComunidad(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        ComunidadIndigenaGastronomia comunidadEliminada = comunidadRepository.eliminarComunidad(id);
        if (comunidadEliminada == null) {
            throw new NotFoundException("No se encontró una comunidad con el ID " + id + " para eliminar.");
        }
    }

    public ComunidadIndigenaGastronomia actualizarComunidad(String idString, ComunidadIndigenaGastronomia datosComunidadActualizar)
            throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarComunidad(datosComunidadActualizar);
        datosComunidadActualizar.setIdComunidad(id);
        ComunidadIndigenaGastronomia comunidadActualizada = comunidadRepository.actualizarComunidad(id, datosComunidadActualizar);
        if (comunidadActualizada == null) {
            throw new NotFoundException("No se encontró una comunidad con el ID " + id + " para actualizar.");
        }
        return comunidadActualizada;
    }

    public ComunidadIndigenaGastronomia obtenerComunidadPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        ComunidadIndigenaGastronomia comunidad = comunidadRepository.obtenerComunidadPorId(id);
        if (comunidad == null) {
            throw new NotFoundException("No se encontró una comunidad con el ID " + id + ".");
        }
        return comunidad;
    }

    public List<ComunidadIndigenaGastronomia> obtenerTodasLasComunidades() {
        return comunidadRepository.obtenerTodasLasComunidades();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID de la comunidad no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la comunidad '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}