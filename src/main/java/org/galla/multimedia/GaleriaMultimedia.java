package org.galla.multimedia;

import java.util.Date;
import java.util.Objects;

public class GaleriaMultimedia {
    private int idMultimedia;
    private String urlArchivo;
    private String tipoArchivo; // e.g., "imagen_jpg", "video_mp4"
    private String titulo;
    private String descripcionCorta;
    private Date fechaDeCarga;
    private int entidadAsociadaId;
    private String tipoEntidadAsociada; // e.g., "Receta", "MercadoLocal"

    public GaleriaMultimedia() {}

    public GaleriaMultimedia(String urlArchivo, String tipoArchivo, String titulo, String descripcionCorta, 
                            Date fechaDeCarga, int entidadAsociadaId, String tipoEntidadAsociada) {
        this.urlArchivo = urlArchivo;
        this.tipoArchivo = tipoArchivo;
        this.titulo = titulo;
        this.descripcionCorta = descripcionCorta;
        this.fechaDeCarga = fechaDeCarga;
        this.entidadAsociadaId = entidadAsociadaId;
        this.tipoEntidadAsociada = tipoEntidadAsociada;
    }

    // Getters and Setters
    public int getIdMultimedia() { return idMultimedia; }
    public void setIdMultimedia(int idMultimedia) { this.idMultimedia = idMultimedia; }
    public String getUrlArchivo() { return urlArchivo; }
    public void setUrlArchivo(String urlArchivo) { this.urlArchivo = urlArchivo; }
    public String getTipoArchivo() { return tipoArchivo; }
    public void setTipoArchivo(String tipoArchivo) { this.tipoArchivo = tipoArchivo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcionCorta() { return descripcionCorta; }
    public void setDescripcionCorta(String descripcionCorta) { this.descripcionCorta = descripcionCorta; }
    public Date getFechaDeCarga() { return fechaDeCarga; }
    public void setFechaDeCarga(Date fechaDeCarga) { this.fechaDeCarga = fechaDeCarga; }
    public int getEntidadAsociadaId() { return entidadAsociadaId; }
    public void setEntidadAsociadaId(int entidadAsociadaId) { this.entidadAsociadaId = entidadAsociadaId; }
    public String getTipoEntidadAsociada() { return tipoEntidadAsociada; }
    public void setTipoEntidadAsociada(String tipoEntidadAsociada) { this.tipoEntidadAsociada = tipoEntidadAsociada; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GaleriaMultimedia that = (GaleriaMultimedia) o;
        return idMultimedia == that.idMultimedia && Objects.equals(urlArchivo, that.urlArchivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMultimedia, urlArchivo);
    }
}