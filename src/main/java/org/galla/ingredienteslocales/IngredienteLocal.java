package org.galla.ingredienteslocales;

public class IngredienteLocal {
    private int id;
    private String nombreComunLocal;
    private String nombreCientifico;
    private String descripcionCultural;
    private String zonaProduccionEspecifica;
    private String disponibilidadEstacional;
    private int productorLocalId;

    public IngredienteLocal() {
    }

    public IngredienteLocal(String nombreComunLocal, String nombreCientifico, String descripcionCultural, String zonaProduccionEspecifica, String disponibilidadEstacional, int productorLocalId) {
        this.nombreComunLocal = nombreComunLocal;
        this.nombreCientifico = nombreCientifico;
        this.descripcionCultural = descripcionCultural;
        this.zonaProduccionEspecifica = zonaProduccionEspecifica;
        this.disponibilidadEstacional = disponibilidadEstacional;
        this.productorLocalId = productorLocalId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComunLocal() {
        return nombreComunLocal;
    }

    public void setNombreComunLocal(String nombreComunLocal) {
        this.nombreComunLocal = nombreComunLocal;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcionCultural() {
        return descripcionCultural;
    }

    public void setDescripcionCultural(String descripcionCultural) {
        this.descripcionCultural = descripcionCultural;
    }

    public String getZonaProduccionEspecifica() {
        return zonaProduccionEspecifica;
    }

    public void setZonaProduccionEspecifica(String zonaProduccionEspecifica) {
        this.zonaProduccionEspecifica = zonaProduccionEspecifica;
    }

    public String getDisponibilidadEstacional() {
        return disponibilidadEstacional;
    }

    public void setDisponibilidadEstacional(String disponibilidadEstacional) {
        this.disponibilidadEstacional = disponibilidadEstacional;
    }

    public int getProductorLocalId() {
        return productorLocalId;
    }

    public void setProductorLocalId(int productorLocalId) {
        this.productorLocalId = productorLocalId;
    }
}