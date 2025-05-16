package org.galla.productos.repository;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import org.galla.productos.model.Producto;

public class ProductoRepository {
    private final ArrayList<Producto> productos = new ArrayList();
    private final AtomicInteger id = new AtomicInteger(1);

    public void agregarProducto(Producto producto) {
        producto.setId(this.id.incrementAndGet());
        this.productos.add(producto);
    }

    public Producto eliminarProducto(int id) {
        Producto producto = null;

        for(int i = 0; i < this.productos.size(); i++) {
            if (((Producto) this.productos.get(i)).getId() == id) {
                producto = (Producto) this.productos.get(i);
                break;
            }
            }
        return producto;
    }

    public Producto actualizarProducto(int id, Producto productoActualizado) {
        Producto producto = null;

        for(int i = 0; i < this.productos.size(); i++) {
            if (((Producto) this.productos.get(i)).getId() == id) {
                this.productos.set(i, productoActualizado);
                producto = productoActualizado;
                break;
            }
        }
        return producto;
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