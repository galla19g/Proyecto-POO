package org.galla.productos;

import java.util.List;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    private void validarProducto(Producto producto) throws BadParameterException {
        if (producto == null) {
            throw new BadParameterException("El objeto Producto no puede ser nulo.");
        }
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new BadParameterException("El nombre del producto no puede estar vacío.");
        }
        if (producto.getPrecio() <= 0.0) { 
            throw new BadParameterException("El precio del producto no puede ser menor o igual a cero.");
        }
        if (producto.getCantidad() <= 0) {
            throw new BadParameterException("La cantidad del producto no puede ser menor o igual a cero.");
        }
    }

    public void agregarProducto(Producto producto) {
        this.validarProducto(producto);
        this.productoRepository.agregarProducto(producto);
    }


    public void eliminarProducto(String id) { 
        if (id == null) {
            throw new NotFoundException("No existe el producto "); 
        } else {
            Producto producto = this.productoRepository.eliminarProducto(Integer.parseInt(id));
            if (producto == null) { 
                throw new NotFoundException("No existe el producto "); 
            }
        }
    }

    public Producto actualizarProducto(String idString, Producto datosProductoActualizar) throws BadParameterException, NotFoundException {
        if (idString == null || idString.trim().isEmpty()) {
            throw new BadParameterException("El ID del producto para actualizar no puede ser nulo o vacío.");
        }
        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID del producto '" + idString + "' no es un número válido para actualizar.");
        }
        validarProducto(datosProductoActualizar);
        datosProductoActualizar.setId(id);
        Producto productoActualizadoEnRepo = this.productoRepository.actualizarProducto(id, datosProductoActualizar);

        if (productoActualizadoEnRepo == null) {
            throw new NotFoundException("No se encontró el producto con ID: " + id + " para actualizar.");
        }
        return productoActualizadoEnRepo;
    }

    public Producto obtenerProducto(String id) {
    if (id == null) {
        throw new NotFoundException("No existe el producto ");
    } else {
        return this.productoRepository.ObtenerProducto(Integer.parseInt(id));
            }

    }

    public List<Producto> obtenerProductos() {
        return this.productoRepository.obtenerProductos();
    }
}