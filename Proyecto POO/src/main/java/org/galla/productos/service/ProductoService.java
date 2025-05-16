package org.galla.productos.service;

import java.util.List;
import org.galla.exception.BadParameterException;
import org.galla.exception.NotFoundException;
import org.galla.productos.model.Producto;
import org.galla.productos.repository.ProductoRepository;

public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    private void validarProducto(Producto producto) throws BadParameterException {
        if (producto == null) {
            throw new BadParameterException("Producto no puede estar vacio");
            }else if (producto.getNombre() != null && producto.getNombre().isEmpty()) {
        if(producto.getPrecio()<=(double)0.0F) {
                throw new BadParameterException("El precio del producto no puede ser menor o igual a cero");
                    }else if (producto.getCantidad()<=0) {
                throw new BadParameterException("La cantidad del producto no puede ser menor a cero");
                    }else if (producto.getCategoria() != null || producto.getCategoria().isEmpty()) {
                throw new BadParameterException("La categoria del producto no puede estar vacia");
                }
            }else {
        throw new BadParameterException("El nombre del producto no puede estar vacio");
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

    public void actualizarProducto(String id, Producto productoActualizar) {
        if (id == null) {
            throw new NotFoundException("No existe el producto ");
        } else {
            this.validarProducto(productoActualizar);
            Producto producto = this.productoRepository.actualizarProducto(Integer.parseInt(id), productoActualizar);
            if (producto == null) {
            throw new NotFoundException("No existe el producto ");
            }
        }
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