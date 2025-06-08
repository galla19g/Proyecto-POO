package org.galla.utensilios;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class UtensilioTradicionalService {
    private final UtensilioTradicionalRepository utensilioRepository;

    public UtensilioTradicionalService(UtensilioTradicionalRepository utensilioRepository) {
        this.utensilioRepository = utensilioRepository;
    }

    private void validarUtensilio(UtensilioTradicional utensilio) throws BadParameterException {
        if (utensilio == null) {
            throw new BadParameterException("El objeto UtensilioTradicional no puede ser nulo.");
        }
        if (utensilio.getNombreLocal() == null || utensilio.getNombreLocal().trim().isEmpty()) {
            throw new BadParameterException("El nombre local del utensilio no puede ser nulo o vacío.");
        }
        if (utensilio.getUsoPrincipal() == null || utensilio.getUsoPrincipal().trim().isEmpty()) {
            throw new BadParameterException("El uso principal del utensilio no puede ser nulo o vacío.");
        }
    }

    public UtensilioTradicional agregarUtensilio(UtensilioTradicional utensilio) throws BadParameterException {
        validarUtensilio(utensilio);
        return utensilioRepository.agregarUtensilio(utensilio);
    }

    public void eliminarUtensilio(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        UtensilioTradicional utensilioEliminado = utensilioRepository.eliminarUtensilio(id);
        if (utensilioEliminado == null) {
            throw new NotFoundException("No se encontró un utensilio con el ID " + id + " para eliminar.");
        }
    }

    public UtensilioTradicional actualizarUtensilio(String idString, UtensilioTradicional datosUtensilioActualizar) 
            throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarUtensilio(datosUtensilioActualizar);
        datosUtensilioActualizar.setIdUtensilio(id);
        UtensilioTradicional utensilioActualizado = utensilioRepository.actualizarUtensilio(id, datosUtensilioActualizar);
        if (utensilioActualizado == null) {
            throw new NotFoundException("No se encontró un utensilio con el ID " + id + " para actualizar.");
        }
        return utensilioActualizado;
    }

    public UtensilioTradicional obtenerUtensilioPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        UtensilioTradicional utensilio = utensilioRepository.obtenerUtensilioPorId(id);
        if (utensilio == null) {
            throw new NotFoundException("No se encontró un utensilio con el ID " + id + ".");
        }
        return utensilio;
    }

    public List<UtensilioTradicional> obtenerTodosLosUtensilios() {
        return utensilioRepository.obtenerTodosLosUtensilios();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID del utensilio no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del utensilio '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}