package org.galla.productos;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ProductoRepository {
    private final ArrayList<Producto> productos = new ArrayList();
    private final AtomicInteger id = new AtomicInteger(1);

    public void agregarProducto(Producto producto) {
        producto.setId(this.id.incrementAndGet());
        this.productos.add(producto);
    }

    public Producto eliminarProducto(int id) {
        Producto productoEliminado = null;
        for (int i = 0; i < this.productos.size(); i++) { 
            if (this.productos.get(i).getId() == id) { 
                productoEliminado = this.productos.remove(i); 
                break; 
            }
        }
        return productoEliminado;
    }

    public Producto actualizarProducto(int id, Producto productoActualizado) {
        for (int i = 0; i < this.productos.size(); i++) {
            if (this.productos.get(i).getId() == id) {
                this.productos.set(i, productoActualizado);
                return productoActualizado;
            }
        }
        return null;
    }

    public Producto ObtenerProducto(int id) {
        for(Producto producto : this.productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    public ArrayList<Producto> obtenerProductos() {
        return this.productos;
    }
}