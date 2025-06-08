package org.galla.rutasgastronomicas;

import java.util.List;

public class RutaGastronomica {
    private int id;
    private String nombre;
    private String descripcion;
    private List<String> paradas; // Lista de nombres o IDs de los lugares
    private String duracionEstimada;
    private String transporteRecomendado;


    public RutaGastronomica() {
    }

    // Getters y Setters
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

    public List<String> getParadas() {
        return paradas;
    }

    public void setParadas(List<String> paradas) {
        this.paradas = paradas;
    }

    public String getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(String duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public String getTransporteRecomendado() {
        return transporteRecomendado;
    }

    public void setTransporteRecomendado(String transporteRecomendado) {
        this.transporteRecomendado = transporteRecomendado;
    }
}