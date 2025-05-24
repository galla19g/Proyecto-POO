package org.galla.mercado;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class MercadoLocalService {
    private final MercadoLocalRepository mercadoLocalRepository;

    public MercadoLocalService(MercadoLocalRepository mercadoLocalRepository) {
        this.mercadoLocalRepository = mercadoLocalRepository;
    }

    private void validarMercadoLocal(MercadoLocal mercado) throws BadParameterException {
        if (mercado == null) {
            throw new BadParameterException("El objeto MercadoLocal no puede ser nulo.");
        }
        if (mercado.getNombre() == null || mercado.getNombre().trim().isEmpty()) {
            throw new BadParameterException("El nombre del mercado no puede ser nulo o vacío.");
        }
        if (mercado.getUbicacionExacta() == null || mercado.getUbicacionExacta().trim().isEmpty()) {
            throw new BadParameterException("La ubicación exacta del mercado no puede ser nula o vacía.");
        }
        if (mercado.getDiasDeMercado() == null || mercado.getDiasDeMercado().trim().isEmpty()) {
            throw new BadParameterException("Los días de mercado no pueden ser nulos o vacíos.");
        }
        if (mercado.getHorarios() == null || mercado.getHorarios().trim().isEmpty()) {
            throw new BadParameterException("Los horarios del mercado no pueden ser nulos o vacíos.");
        }
    
    }

    public MercadoLocal agregarMercado(MercadoLocal mercado) throws BadParameterException {
        validarMercadoLocal(mercado);
        return this.mercadoLocalRepository.agregarMercado(mercado);
    }

    public void eliminarMercado(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        MercadoLocal mercadoEliminado = this.mercadoLocalRepository.eliminarMercado(id);
        if (mercadoEliminado == null) {
            throw new NotFoundException("No se encontró un mercado local con el ID " + id + " para eliminar.");
        }
    }

    public MercadoLocal actualizarMercado(String idString, MercadoLocal datosMercadoActualizar) throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarMercadoLocal(datosMercadoActualizar);
        
        datosMercadoActualizar.setIdMercado(id); 
        MercadoLocal mercadoExistente = this.mercadoLocalRepository.obtenerMercadoPorId(id);
        if (mercadoExistente == null) {
             throw new NotFoundException("No se encontró un mercado local con el ID " + id + " para actualizar.");
        }

        MercadoLocal mercadoActualizado = this.mercadoLocalRepository.actualizarMercado(id, datosMercadoActualizar);
        if (mercadoActualizado == null) {
            throw new NotFoundException("No se pudo actualizar el mercado local con ID " + id + ".");
        }
        return mercadoActualizado;
    }

    public MercadoLocal obtenerMercadoPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        MercadoLocal mercado = this.mercadoLocalRepository.obtenerMercadoPorId(id);
        if (mercado == null) {
            throw new NotFoundException("No se encontró un mercado local con el ID " + id + ".");
        }
        return mercado;
    }

    public List<MercadoLocal> obtenerTodosLosMercados() {
        return this.mercadoLocalRepository.obtenerTodosLosMercados();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID del mercado local no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del mercado local '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}