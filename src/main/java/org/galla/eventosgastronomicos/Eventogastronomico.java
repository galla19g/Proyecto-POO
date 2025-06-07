package org.galla.eventosgastronomicos;

public class Eventogastronomico {
    private int id;
    private String nombreEvento;
    private String descripcion;
    private String fechaInicio;
    private String fechaFin;
    private String ubicacion;
    private String organizador;
    private String tipoEvento;

    public Eventogastronomico(){

    }

    public Eventogastronomico(String nombreEvento, String descripcion, String fechaInicio, String fechaFin, String ubicacion, String organizador, String tipoEvento){
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getnombreEvento(){
        return nombreEvento;
    }

    public void setnombreEvento(String nombreEvento){
        this.nombreEvento = nombreEvento;
    }

    public String getdescripcion(){
        return descripcion;
    }

    public void setdescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getfechaInicio(){
        return fechaInicio;
    }

    public void setfechaInicio(String fechaInicio){
        this.fechaInicio = fechaInicio;
    }

    public String getfechaFin(){
        return fechaFin;
    }

    public void setFechafin(String fechaFin){
        this.fechaFin = fechaFin;
    }

    public String getubicacion(){
        return ubicacion;
    }

    public void setubicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public String getorganizador(){
        return organizador;
    }

    public void setorganizador(String organizador){
        this.organizador = organizador;
    }

    public  String gettipoEvento(){
        return tipoEvento;
    }

    public void settipoEvento( String tipoEvento){
        this.tipoEvento = tipoEvento;
    }
}
