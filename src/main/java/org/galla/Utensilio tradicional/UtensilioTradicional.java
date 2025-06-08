package org.galla.utensilios;

import java.util.Objects;

public class UtensilioTradicional {
    private int idUtensilio;
    private String nombreLocal;
    private String nombreComun;
    private String materialDeFabricacion;
    private String usoPrincipal;
    private String descripcionHistoricaOCultural;
    private String imagenUrl;

    public UtensilioTradicional() {}

    public UtensilioTradicional(String nombreLocal, String nombreComun, String materialDeFabricacion, 
                                String usoPrincipal, String descripcionHistoricaOCultural, String imagenUrl) {
        this.nombreLocal = nombreLocal;
        this.nombreComun = nombreComun;
        this.materialDeFabricacion = materialDeFabricacion;
        this.usoPrincipal = usoPrincipal;
        this.descripcionHistoricaOCultural = descripcionHistoricaOCultural;
        this.imagenUrl = imagenUrl;
    }

    // Getters and Setters
    public int getIdUtensilio() { return idUtensilio; }
    public void setIdUtensilio(int idUtensilio) { this.idUtensilio = idUtensilio; }
    public String getNombreLocal() { return nombreLocal; }
    public void setNombreLocal(String nombreLocal) { this.nombreLocal = nombreLocal; }
    public String getNombreComun() { return nombreComun; }
    public void setNombreComun(String nombreComun) { this.nombreComun = nombreComun; }
    public String getMaterialDeFabricacion() { return materialDeFabricacion; }
    public void setMaterialDeFabricacion(String materialDeFabricacion) { this.materialDeFabricacion = materialDeFabricacion; }
    public String getUsoPrincipal() { return usoPrincipal; }
    public void setUsoPrincipal(String usoPrincipal) { this.usoPrincipal = usoPrincipal; }
    public String getDescripcionHistoricaOCultural() { return descripcionHistoricaOCultural; }
    public void setDescripcionHistoricaOCultural(String descripcionHistoricaOCultural) { this.descripcionHistoricaOCultural = descripcionHistoricaOCultural; }
    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtensilioTradicional that = (UtensilioTradicional) o;
        return idUtensilio == that.idUtensilio &&
                Objects.equals(nombreLocal, that.nombreLocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtensilio, nombreLocal);
    }
}