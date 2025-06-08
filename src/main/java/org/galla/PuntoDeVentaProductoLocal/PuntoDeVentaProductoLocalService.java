package org.galla.puntosdeventa;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class PuntoDeVentaProductoLocalService {
    private final PuntoDeVentaProductoLocalRepository puntoDeVentaRepository;

    public PuntoDeVentaProductoLocalService(PuntoDeVentaProductoLocalRepository puntoDeVentaRepository) {
        this.puntoDeVentaRepository = puntoDeVentaRepository;
    }

    private void validarPuntoDeVenta(PuntoDeVentaProductoLocal puntoDeVenta) throws BadParameterException {
        if (puntoDeVenta == null) {
            throw new BadParameterException("El objeto PuntoDeVentaProductoLocal no puede ser nulo.");
        }
        if (puntoDeVenta.getNombre() == null || puntoDeVenta.getNombre().trim().isEmpty()) {
            throw new BadParameterException("El nombre del punto de venta no puede ser nulo o vacío.");
        }
        if (puntoDeVenta.getDireccion() == null || puntoDeVenta.getDireccion().trim().isEmpty()) {
            throw new BadParameterException("La dirección del punto de venta no puede ser nula o vacía.");
        }
    }

    public PuntoDeVentaProductoLocal agregarPuntoDeVenta(PuntoDeVentaProductoLocal puntoDeVenta) throws BadParameterException {
        validarPuntoDeVenta(puntoDeVenta);
        return puntoDeVentaRepository.agregarPuntoDeVenta(puntoDeVenta);
    }

    public void eliminarPuntoDeVenta(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "eliminar");
        PuntoDeVentaProductoLocal puntoDeVentaEliminado = puntoDeVentaRepository.eliminarPuntoDeVenta(id);
        if (puntoDeVentaEliminado == null) {
            throw new NotFoundException("No se encontró un punto de venta con el ID " + id + " para eliminar.");
        }
    }

    public PuntoDeVentaProductoLocal actualizarPuntoDeVenta(String idString, PuntoDeVentaProductoLocal datosPuntoDeVentaActualizar) 
            throws BadParameterException, NotFoundException {
        int id = parseId(idString, "actualizar");
        validarPuntoDeVenta(datosPuntoDeVentaActualizar);
        datosPuntoDeVentaActualizar.setIdPuntoVenta(id);
        PuntoDeVentaProductoLocal puntoDeVentaActualizado = puntoDeVentaRepository.actualizarPuntoDeVenta(id, datosPuntoDeVentaActualizar);
        if (puntoDeVentaActualizado == null) {
            throw new NotFoundException("No se encontró un punto de venta con el ID " + id + " para actualizar.");
        }
        return puntoDeVentaActualizado;
    }

    public PuntoDeVentaProductoLocal obtenerPuntoDeVentaPorId(String idString) throws NotFoundException, BadParameterException {
        int id = parseId(idString, "obtener");
        PuntoDeVentaProductoLocal puntoDeVenta = puntoDeVentaRepository.obtenerPuntoDeVentaPorId(id);
        if (puntoDeVenta == null) {
            throw new NotFoundException("No se encontró un punto de venta con el ID " + id + ".");
        }
        return puntoDeVenta;
    }

    public List<PuntoDeVentaProductoLocal> obtenerTodosLosPuntosDeVenta() {
        return puntoDeVentaRepository.obtenerTodosLosPuntosDeVenta();
    }

    private int parseId(String idString, String operation) throws BadParameterException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID del punto de venta no puede ser nulo o vacío para la operación de " + operation + ".");
        }
        try {
            return Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del punto de venta '" + idString + "' no es un número válido para la operación de " + operation + ".");
        }
    }
}