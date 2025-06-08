package org.galla.multimedia;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class GaleriaMultimediaService {
    private final org.galla.multimedia.GaleriaMultimediaRepository multimediaRepository;

    public GaleriaMultimediaService(org.galla.multimedia.GaleriaMultimediaRepository multimediaRepository) {
        this.multimediaRepository = multimediaRepository;
    }

    private void validarMultimedia(GaleriaMultimedia multimedia) throws BadParameterException {
        if (multimedia == null) {
            throw new BadParameterException("El objeto GaleriaMultimedia no puede ser nulo.");
        }
        if (multimedia.getUrlArchivo() == null || multimedia.getUrlArchivo().trim().isEmpty()) {
            throw new BadParameterException("La URL del archivo no puede ser nula o vacía.");
        }
        if (multimedia.getTipoArchivo() == null || multimedia.getTipoArchivo().trim().isEmpty()) {
            throw new BadParameterException("El tipo de archivo no puede ser nulo o vacío.");
        }
        if (multimedia.getTipoEntidadAsociada() == null || multimedia.getTipoEntidadAsociada().trim().isEmpty()) {
            throw new BadParameterException("El tipo de entidad asociada no puede ser nulo o vacío.");
        }
    }

    public GaleriaMultimedia agregarMultimedia(GaleriaMultimedia multimedia) throws BadParameterException {
        validarMultimedia(multimedia);
        return multimediaRepository.agregarMultimedia(multimedia);
    }

    public void eliminarMultimedia(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        GaleriaMultimedia multimediaEliminado = multimediaRepository.eliminarMultimedia(id);
        if (multimediaEliminado == null) {
            throw new NotFoundException("No se encontró multimedia con el ID " + id + " para eliminar.");
        }
    }

    public GaleriaMultimedia actualizarMultimedia(String idString, GaleriaMultimedia datosMultimediaActualizar)
            throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarMultimedia(datosMultimediaActualizar);
        datosMultimediaActualizar.setIdMultimedia(id);
        GaleriaMultimedia multimediaActualizado = multimediaRepository.actualizarMultimedia(id, datosMultimediaActualizar);
        if (multimediaActualizado == null) {
            throw new NotFoundException("No se encontró multimedia con el ID " + id + " para actualizar.");
        }
        return multimediaActualizado;
    }

    public GaleriaMultimedia obtenerMultimediaPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        GaleriaMultimedia multimedia = multimediaRepository.obtenerMultimediaPorId(id);
        if (multimedia == null) {
            throw new NotFoundException("No se encontró multimedia con el ID " + id + ".");
        }
        return multimedia;
    }

    public List<GaleriaMultimedia> obtenerTodoElMultimedia() {
        return multimediaRepository.obtenerTodoElMultimedia();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID del multimedia no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del multimedia '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}