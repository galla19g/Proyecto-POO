package org.galla.nutricion;

import java.util.List;
import java.util.Objects;

public class ValorNutricional {
    private int idValorNutricional;
    private int productoAsociadoId; // Can be null if associated with Receta
    private int recetaAsociadaId;   // Can be null if associated with Producto
    private String porcionReferencia; // e.g., "100g"
    private double calorias;
    private double proteinas;
    private double carbohidratos;
    private double grasasTotales;
    private double fibra;
    private List<String> vitaminasPrincipales;
    private List<String> mineralesPrincipales;

    public ValorNutricional() {}

    public ValorNutricional(int productoAsociadoId, int recetaAsociadaId, String porcionReferencia, double calorias,
                            double proteinas, double carbohidratos, double grasasTotales, double fibra,
                            List<String> vitaminasPrincipales, List<String> mineralesPrincipales) {
        this.productoAsociadoId = productoAsociadoId;
        this.recetaAsociadaId = recetaAsociadaId;
        this.porcionReferencia = porcionReferencia;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasasTotales = grasasTotales;
        this.fibra = fibra;
        this.vitaminasPrincipales = vitaminasPrincipales;
        this.mineralesPrincipales = mineralesPrincipales;
    }

    // Getters and Setters
    public int getIdValorNutricional() { return idValorNutricional; }
    public void setIdValorNutricional(int idValorNutricional) { this.idValorNutricional = idValorNutricional; }
    public int getProductoAsociadoId() { return productoAsociadoId; }
    public void setProductoAsociadoId(int productoAsociadoId) { this.productoAsociadoId = productoAsociadoId; }
    public int getRecetaAsociadaId() { return recetaAsociadaId; }
    public void setRecetaAsociadaId(int recetaAsociadaId) { this.recetaAsociadaId = recetaAsociadaId; }
    public String getPorcionReferencia() { return porcionReferencia; }
    public void setPorcionReferencia(String porcionReferencia) { this.porcionReferencia = porcionReferencia; }
    public double getCalorias() { return calorias; }
    public void setCalorias(double calorias) { this.calorias = calorias; }
    public double getProteinas() { return proteinas; }
    public void setProteinas(double proteinas) { this.proteinas = proteinas; }
    public double getCarbohidratos() { return carbohidratos; }
    public void setCarbohidratos(double carbohidratos) { this.carbohidratos = carbohidratos; }
    public double getGrasasTotales() { return grasasTotales; }
    public void setGrasasTotales(double grasasTotales) { this.grasasTotales = grasasTotales; }
    public double getFibra() { return fibra; }
    public void setFibra(double fibra) { this.fibra = fibra; }
    public List<String> getVitaminasPrincipales() { return vitaminasPrincipales; }
    public void setVitaminasPrincipales(List<String> vitaminasPrincipales) { this.vitaminasPrincipales = vitaminasPrincipales; }
    public List<String> getMineralesPrincipales() { return mineralesPrincipales; }
    public void setMineralesPrincipales(List<String> mineralesPrincipales) { this.mineralesPrincipales = mineralesPrincipales; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ValorNutricional that = (ValorNutricional) o;
        return idValorNutricional == that.idValorNutricional;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idValorNutricional);
    }
}