package org.galla.ComunidadIndígenaGastronomia;

import org.galla.productos.Producto;
import org.galla.recetas.Receta;

import java.util.List;
import java.util.Objects;

public class ComunidadIndigenaGastronomia {
    private int idComunidad;
    private String nombreComunidad;
    private String descripcionCulturalGastronomica;
    private List<Receta> platosEmblematicos;
    private List<Producto> ingredientesSagradosOTradicionales;
    private String zonaGeograficaDeInfluencia;
    private String contactoParaColaboracion;

    public ComunidadIndigenaGastronomia() {}

    public ComunidadIndigenaGastronomia(String nombreComunidad, String descripcionCulturalGastronomica, 
                                       List<Receta> platosEmblematicos, List<Producto> ingredientesSagradosOTradicionales, 
                                       String zonaGeograficaDeInfluencia, String contactoParaColaboracion) {
        this.nombreComunidad = nombreComunidad;
        this.descripcionCulturalGastronomica = descripcionCulturalGastronomica;
        this.platosEmblematicos = platosEmblematicos;
        this.ingredientesSagradosOTradicionales = ingredientesSagradosOTradicionales;
        this.zonaGeograficaDeInfluencia = zonaGeograficaDeInfluencia;
        this.contactoParaColaboracion = contactoParaColaboracion;
    }

    // Getters and Setters
    public int getIdComunidad() { return idComunidad; }
    public void setIdComunidad(int idComunidad) { this.idComunidad = idComunidad; }
    public String getNombreComunidad() { return nombreComunidad; }
    public void setNombreComunidad(String nombreComunidad) { this.nombreComunidad = nombreComunidad; }
    public String getDescripcionCulturalGastronomica() { return descripcionCulturalGastronomica; }
    public void setDescripcionCulturalGastronomica(String descripcionCulturalGastronomica) { 
        this.descripcionCulturalGastronomica = descripcionCulturalGastronomica; 
    }
    public List<Receta> getPlatosEmblematicos() { return platosEmblematicos; }
    public void setPlatosEmblematicos(List<Receta> platosEmblematicos) { this.platosEmblematicos = platosEmblematicos; }
    public List<Producto> getIngredientesSagradosOTradicionales() { return ingredientesSagradosOTradicionales; }
    public void setIngredientesSagradosOTradicionales(List<Producto> ingredientesSagradosOTradicionales) { 
        this.ingredientesSagradosOTradicionales = ingredientesSagradosOTradicionales; 
    }
    public String getZonaGeograficaDeInfluencia() { return zonaGeograficaDeInfluencia; }
    public void setZonaGeograficaDeInfluencia(String zonaGeograficaDeInfluencia) { 
        this.zonaGeograficaDeInfluencia = zonaGeograficaDeInfluencia; 
    }
    public String getContactoParaColaboracion() { return contactoParaColaboracion; }
    public void setContactoParaColaboracion(String contactoParaColaboracion) { 
        this.contactoParaColaboracion = contactoParaColaboracion; 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComunidadIndigenaGastronomia that = (ComunidadIndigenaGastronomia) o;
        return idComunidad == that.idComunidad && Objects.equals(nombreComunidad, that.nombreComunidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComunidad, nombreComunidad);
    }
}