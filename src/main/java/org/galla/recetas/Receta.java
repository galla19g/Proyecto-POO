package org.galla.recetas;

public class Receta {
    private int id;
    private String nombre;
    private String ingredientes;
    private String instrucciones;
    private int tiempoDePreparacion;
    

    public Receta(String nombre, String ingredientes, String instrucciones, int tiempoDePreparacion) {

    }

    public Receta() {
    }

    public int getId() {
        return id;
    }


    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getIngredientes(){
        return ingredientes;
    }

    public void setIngredientes(String ingredientes){
        this.ingredientes = ingredientes;
    }

    public String getInstrucciones(){
        return instrucciones;
    }

    public int getTiempoDePreparacion(){
    return tiempoDePreparacion;
    }

    public void setTiempoDePreparacion(int tiempoDePreparacion){
    this.tiempoDePreparacion = tiempoDePreparacion;
    }

}