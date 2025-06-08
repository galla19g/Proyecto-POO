package org.galla.glosario;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class GlosarioGastronomicoService {
    private final org.galla.glosario.GlosarioGastronomicoRepository glosarioRepository;

    public GlosarioGastronomicoService(org.galla.glosario.GlosarioGastronomicoRepository glosarioRepository) {
        this.glosarioRepository = glosarioRepository;
    }

    private void validarTermino(org.galla.GlosarioGastronomico.GlosarioGastronomico termino) throws BadParameterException {
        if (termino == null) {
            throw new BadParameterException("El objeto GlosarioGastronomico no puede ser nulo.");
        }
        if (termino.getTerminoLocal() == null || termino.getTerminoLocal().trim().isEmpty()) {
            throw new BadParameterException("El término local no puede ser nulo o vacío.");
        }
        if (termino.getDefinicion() == null || termino.getDefinicion().trim().isEmpty()) {
            throw new BadParameterException("La definición no puede ser nula o vacía.");
        }
    }

    public org.galla.GlosarioGastronomico.GlosarioGastronomico agregarTermino(org.galla.GlosarioGastronomico.GlosarioGastronomico termino) throws BadParameterException {
        validarTermino(termino);
        return glosarioRepository.agregarTermino(termino);
    }

    public void eliminarTermino(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        org.galla.GlosarioGastronomico.GlosarioGastronomico terminoEliminado = glosarioRepository.eliminarTermino(id);
        if (terminoEliminado == null) {
            throw new NotFoundException("No se encontró un término con el ID " + id + " para eliminar.");
        }
    }

    public org.galla.GlosarioGastronomico.GlosarioGastronomico actualizarTermino(String idString, org.galla.GlosarioGastronomico.GlosarioGastronomico datosTerminoActualizar)
            throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarTermino(datosTerminoActualizar);
        datosTerminoActualizar.setIdTermino(id);
        org.galla.GlosarioGastronomico.GlosarioGastronomico terminoActualizado = glosarioRepository.actualizarTermino(id, datosTerminoActualizar);
        if (terminoActualizado == null) {
            throw new NotFoundException("No se encontró un término con el ID " + id + " para actualizar.");
        }
        return terminoActualizado;
    }

    public org.galla.GlosarioGastronomico.GlosarioGastronomico obtenerTerminoPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        GlosarioGastronomico termino = glosarioRepository.obtenerTerminoPorId(id);
        if (termino == null) {
            throw new NotFoundException("No se encontró un término con el ID " + id + ".");
        }
        return termino;
    }

    public List<org.galla.GlosarioGastronomico.GlosarioGastronomico> obtenerTodosLosTerminos() {
        return glosarioRepository.obtenerTodosLosTerminos();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID del término no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del término '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}