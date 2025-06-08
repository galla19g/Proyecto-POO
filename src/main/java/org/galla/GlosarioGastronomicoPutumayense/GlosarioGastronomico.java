package org.galla.GlosarioGastronomico;

import java.util.List;
import java.util.Objects;

public class GlosarioGastronomico {
    private int idTermino;
    private String terminoLocal;
    private String definicion;
    private String contextoDeUso;
    private List<String> variantesRegionales;

    public GlosarioGastronomico() {}

    public GlosarioGastronomico(String terminoLocal, String definicion, String contextoDeUso, List<String> variantesRegionales) {
        this.terminoLocal = terminoLocal;
        this.definicion = definicion;
        this.contextoDeUso = contextoDeUso;
        this.variantesRegionales = variantesRegionales;
    }

    // Getters and Setters
    public int getIdTermino() { return idTermino; }
    public void setIdTermino(int idTermino) { this.idTermino = idTermino; }
    public String getTerminoLocal() { return terminoLocal; }
    public void setTerminoLocal(String terminoLocal) { this.terminoLocal = terminoLocal; }
    public String getDefinicion() { return definicion; }
    public void setDefinicion(String definicion) { this.definicion = definicion; }
    public String getContextoDeUso() { return contextoDeUso; }
    public void setContextoDeUso(String contextoDeUso) { this.contextoDeUso = contextoDeUso; }
    public List<String> getVariantesRegionales() { return variantesRegionales; }
    public void setVariantesRegionales(List<String> variantesRegionales) { this.variantesRegionales = variantesRegionales; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GlosarioGastronomico that = (GlosarioGastronomico) o;
        return idTermino == that.idTermino && Objects.equals(terminoLocal, that.terminoLocal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTermino, terminoLocal);
    }
}