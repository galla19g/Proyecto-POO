package org.galla.comentarios;

public class Comentario {
    private int id;
    private String texto;
    private int valoracion; // Puntuación de 1 a 5
    private String fecha;
    private int usuarioId;
    private int elementoAsociadoId;
    private String tipoElementoAsociado; // "Receta", "Restaurante", etc.

    public Comentario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getElementoAsociadoId() {
        return elementoAsociadoId;
    }

    public void setElementoAsociadoId(int elementoAsociadoId) {
        this.elementoAsociadoId = elementoAsociadoId;
    }

    public String getTipoElementoAsociado() {
        return tipoElementoAsociado;
    }

    public void setTipoElementoAsociado(String tipoElementoAsociado) {
        this.tipoElementoAsociado = tipoElementoAsociado;
    }
}
