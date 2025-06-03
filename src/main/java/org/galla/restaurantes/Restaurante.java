package org.galla.restaurantes;

public class Restaurante {
    private int id;
    private String nombrerestaurante;
    private String descripcion;
    private String direccion;
    private String telefono;
    private String horarioAtencion;
    private String rangoPrecios;

    public Restaurante(){

    }

    public Restaurante(String nombrerestaurante, String descripcion, String direccion, String telefono, String horarioAtencion, String rangoPrecios ){
    
    }

    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getnombrerestaurante(){
        return nombrerestaurante;
    }

    public void setnombrerestaurante(String nombrerestaurante){
        this. nombrerestaurante = nombrerestaurante;
    }

    public String getdescripcion(){
        return descripcion;
    }

    public void setdescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public String getdireccion(){
        return direccion;
    }

    public void setdireccion(String direccion){
        this. direccion = direccion;
    }

    public String gettelefono(){
        return telefono;
    }

    public void settelefono(String telefono){
        this.telefono = telefono;
    }

    public String gethorarioAtencion(){
        return horarioAtencion;
    }

    public void sethorarioAtencion(String horarioAtencion){
        this.horarioAtencion = horarioAtencion;
    }

    public String getrangoPrecios(){
        return rangoPrecios;
    }

    public void setrangoPrecios(String rangoPrecios){
        this.rangoPrecios = rangoPrecios;
    }


}
