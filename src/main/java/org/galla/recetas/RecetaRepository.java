package org.galla.recetas;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RecetaRepository {
    private final ArrayList<Receta> recetas = new ArrayList();
    private final AtomicInteger id = new AtomicInteger(1);

    public void agregarReceta(Receta receta){
        receta.setId(this.id.incrementAndGet());
        this.recetas.add(receta);
    }

    public Receta eliminarReceta(int id){
        Receta recetaEliminada = null;
        for (int i = 0; i < this.recetas.size(); i++) { 
            if (this.recetas.get(i).getId() == id) { 
                recetaEliminada = this.recetas.remove(i); 
                break; 
            }
        }
        return recetaEliminada;
    }

    public Receta actualizarReceta(int id, Receta recetaActualizada){
        for(int i = 0; i < this.recetas.size(); i++){
            if(this.recetas.get(i).getId() == id){
                this.recetas.set(i, recetaActualizada);
                return recetaActualizada;
            }
        }
        return null;
    }

    public Receta obtenerReceta(int id){
        for(Receta receta : this.recetas){
            if(receta.getId() == id){
                return receta;
            }
        }
        return null;
    }

    public ArrayList<Receta> obtenerRecetas(){
        return this.recetas;
    }
}


    

