package org.galla.bebidas;

public class BebidaTipica {
    private int id;
    private String nombre;
    private String descripcion;
    private String historia;

    public BebidaTipica(String nombre, String descripcion, String historia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.historia = historia;
    }

    public BebidaTipica() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }
}