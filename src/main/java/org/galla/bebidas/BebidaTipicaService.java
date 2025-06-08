package org.galla.bebidas;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class BebidaTipicaService {
    private final BebidaTipicaRepository bebidaRepository;

    public BebidaTipicaService(BebidaTipicaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    private void validarBebida(BebidaTipica bebida) throws BadParameterException {
        if (bebida == null) {
            throw new BadParameterException("El objeto BebidaTipica no puede ser nulo.");
        }
        if (bebida.getNombre() == null || bebida.getNombre().trim().isEmpty()) {
            throw new BadParameterException("El nombre de la bebida no puede ser nulo o vacío.");
        }
        if (bebida.getDescripcion() == null || bebida.getDescripcion().trim().isEmpty()) {
            throw new BadParameterException("El método de fermentación/preparación no puede ser nulo o vacío.");
        }
        if (bebida.getHistoria() == null || bebida.getHistoria().trim().isEmpty()) {
            throw new BadParameterException("La historia de la bebida no puede ser nula o vacía.");
        }
    }

    public BebidaTipica agregarBebida(BebidaTipica bebida) throws BadParameterException {
        validarBebida(bebida);
        return bebidaRepository.agregarBebida(bebida);
    }

    public void eliminarBebida(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        BebidaTipica bebidaEliminada = bebidaRepository.eliminarBebida(id);
        if (bebidaEliminada == null) {
            throw new NotFoundException("No se encontró una bebida con el ID " + id + " para eliminar.");
        }
    }

    public BebidaTipica actualizarBebida(String idString, BebidaTipica datosBebidaActualizar) 
            throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarBebida(datosBebidaActualizar);
        datosBebidaActualizar.setId(id);
        BebidaTipica bebidaActualizada = bebidaRepository.actualizarBebida(id, datosBebidaActualizar);
        if (bebidaActualizada == null) {
            throw new NotFoundException("No se encontró una bebida con el ID " + id + " para actualizar.");
        }
        return bebidaActualizada;
    }

    public BebidaTipica obtenerBebidaPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        BebidaTipica bebida = bebidaRepository.obtenerBebidaPorId(id);
        if (bebida == null) {
            throw new NotFoundException("No se encontró una bebida con el ID " + id + ".");
        }
        return bebida;
    }

    public List<BebidaTipica> obtenerTodasLasBebidas() {
        return bebidaRepository.obtenerTodasLasBebidas();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID de la bebida no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la bebida '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}