package org.galla.bebidas;

import java.util.List;
import java.util.Objects;

public class BebidaTipica {
    private int idBebida;
    private String nombre;
    private boolean esAlcoholica;
    private List<String> ingredientesClave;
    private String metodoDeFermentacionOPreparacion;
    private String ocasionesDeConsumoTradicional;

    public BebidaTipica() {}

    public BebidaTipica(String nombre, boolean esAlcoholica, List<String> ingredientesClave, 
                        String metodoDeFermentacionOPreparacion, String ocasionesDeConsumoTradicional) {
        this.nombre = nombre;
        this.esAlcoholica = esAlcoholica;
        this.ingredientesClave = ingredientesClave;
        this.metodoDeFermentacionOPreparacion = metodoDeFermentacionOPreparacion;
        this.ocasionesDeConsumoTradicional = ocasionesDeConsumoTradicional;
    }

    // Getters and Setters
    public int getIdBebida() { return idBebida; }
    public void setIdBebida(int idBebida) { this.idBebida = idBebida; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public boolean isEsAlcoholica() { return esAlcoholica; }
    public void setEsAlcoholica(boolean esAlcoholica) { this.esAlcoholica = esAlcoholica; }
    public List<String> getIngredientesClave() { return ingredientesClave; }
    public void setIngredientesClave(List<String> ingredientesClave) { this.ingredientesClave = ingredientesClave; }
    public String getMetodoDeFermentacionOPreparacion() { return metodoDeFermentacionOPreparacion; }
    public void setMetodoDeFermentacionOPreparacion(String metodoDeFermentacionOPreparacion) { 
        this.metodoDeFermentacionOPreparacion = metodoDeFermentacionOPreparacion; 
    }
    public String getOcasionesDeConsumoTradicional() { return ocasionesDeConsumoTradicional; }
    public void setOcasionesDeConsumoTradicional(String ocasionesDeConsumoTradicional) { 
        this.ocasionesDeConsumoTradicional = ocasionesDeConsumoTradicional; 
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BebidaTipica that = (BebidaTipica) o;
        return idBebida == that.idBebida && Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBebida, nombre);
    }
}