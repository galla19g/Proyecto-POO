package org.galla.Valornutricional;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class ValorNutricionalService {
    private final ValorNutricionalRepository nutricionRepository;

    public ValorNutricionalService(ValorNutricionalRepository nutricionRepository) {
        this.nutricionRepository = nutricionRepository;
    }

    private void validarNutricion(ValorNutricional nutricion) throws BadParameterException {
        if (nutricion == null) {
            throw new BadParameterException("El objeto ValorNutricional no puede ser nulo.");
        }
        if (nutricion.getPorcionReferencia() == null || nutricion.getPorcionReferencia().trim().isEmpty()) {
            throw new BadParameterException("La porción de referencia no puede ser nula o vacía.");
        }
        if (nutricion.getCalorias() < 0) {
            throw new BadParameterException("Las calorías no pueden ser negativas.");
        }
    }

    public ValorNutricional agregarNutricion(ValorNutricional nutricion) throws BadParameterException {
        validarNutricion(nutricion);
        return nutricionRepository.agregarNutricion(nutricion);
    }

    public void eliminarNutricion(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        ValorNutricional nutricionEliminada = nutricionRepository.eliminarNutricion(id);
        if (nutricionEliminada == null) {
            throw new NotFoundException("No se encontró información nutricional con el ID " + id + " para eliminar.");
        }
    }

    public ValorNutricional actualizarNutricion(String idString, ValorNutricional datosNutricionActualizar) 
            throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarNutricion(datosNutricionActualizar);
        datosNutricionActualizar.setIdValorNutricional(id);
        ValorNutricional nutricionActualizada = nutricionRepository.actualizarNutricion(id, datosNutricionActualizar);
        if (nutricionActualizada == null) {
            throw new NotFoundException("No se encontró información nutricional con el ID " + id + " para actualizar.");
        }
        return nutricionActualizada;
    }

    public ValorNutricional obtenerNutricionPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        ValorNutricional nutricion = nutricionRepository.obtenerNutricionPorId(id);
        if (nutricion == null) {
            throw new NotFoundException("No se encontró información nutricional con el ID " + id + ".");
        }
        return nutricion;
    }

    public List<ValorNutricional> obtenerTodasLasNutriciones() {
        return nutricionRepository.obtenerTodasLasNutriciones();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID de la información nutricional no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la información nutricional '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}