package org.galla.puntosdeventa;

import org.galla.productos.Producto;

import java.util.List;
import java.util.Objects;

public class PuntoDeVentaProductoLocal {
    private int idPuntoVenta;
    private String nombre;
    private String direccion;
    private String tipoDeEstablecimiento; // e.g., "Tienda de artesanías", "Cooperativa agrícola"
    private List<Producto> productosQueOfrece;
    private String horario;
    private String contacto;

    public PuntoDeVentaProductoLocal() {}

    public PuntoDeVentaProductoLocal(String nombre, String direccion, String tipoDeEstablecimiento, 
                                    List<Producto> productosQueOfrece, String horario, String contacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipoDeEstablecimiento = tipoDeEstablecimiento;
        this.productosQueOfrece = productosQueOfrece;
        this.horario = horario;
        this.contacto = contacto;
    }

    // Getters and Setters
    public int getIdPuntoVenta() { return idPuntoVenta; }
    public void setIdPuntoVenta(int idPuntoVenta) { this.idPuntoVenta = idPuntoVenta; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTipoDeEstablecimiento() { return tipoDeEstablecimiento; }
    public void setTipoDeEstablecimiento(String tipoDeEstablecimiento) { this.tipoDeEstablecimiento = tipoDeEstablecimiento; }
    public List<Producto> getProductosQueOfrece() { return productosQueOfrece; }
    public void setProductosQueOfrece(List<Producto> productosQueOfrece) { this.productosQueOfrece = productosQueOfrece; }
    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
    public String getContacto() { return contacto; }
    public void setContacto(String contacto) { this.contacto = contacto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuntoDeVentaProductoLocal that = (PuntoDeVentaProductoLocal) o;
        return idPuntoVenta == that.idPuntoVenta && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPuntoVenta, nombre);
    }
}