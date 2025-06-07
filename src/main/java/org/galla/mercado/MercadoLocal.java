package org.galla.mercado;

import java.util.List;

public class MercadoLocal {
    private int idMercado;
    private String nombre;
    private String ubicacionExacta;
    private String diasDeMercado; 
    private String horarios; 
    private String tipoDeProductosPrincipales; 

    public MercadoLocal() {
    }

    public MercadoLocal(String nombre, String ubicacionExacta, String diasDeMercado, String horarios, String tipoDeProductosPrincipales) {

    }


    public int getIdMercado() {
        return idMercado;
    }

    public void setIdMercado(int idMercado) {
        this.idMercado = idMercado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacionExacta() {
        return ubicacionExacta;
    }

    public void setUbicacionExacta(String ubicacionExacta) {
        this.ubicacionExacta = ubicacionExacta;
    }

    public String getDiasDeMercado() {
        return diasDeMercado;
    }

    public void setDiasDeMercado(String diasDeMercado) {
        this.diasDeMercado = diasDeMercado;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String gettipoDeProductosPrincipales() {
        return tipoDeProductosPrincipales;
    }

    public void settipoDeProductosPrincipales(String tipoDeProductosPrincipales) {
        this.tipoDeProductosPrincipales = tipoDeProductosPrincipales;
    }

}