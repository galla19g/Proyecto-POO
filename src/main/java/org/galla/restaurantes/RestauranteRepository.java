package org.galla.restaurantes;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class RestauranteRepository {
    private final ArrayList<Restaurante> restaurantes = new ArrayList();
    private final AtomicInteger id = new AtomicInteger(1);

    public void agregarRestaurante(Restaurante restaurante){
        restaurante.setId(this.id.incrementAndGet());
        this.restaurantes.add(restaurante);
    }

    public Restaurante eliminarRestaurante(int id){
        Restaurante restauranteEliminado = null;
        for(int i = 0;  i < this.restaurantes.size(); i++){
            if(this.restaurantes.get(i).getId() == id){
                restauranteEliminado = this.restaurantes.remove(i);
                break;
            }
        }return restauranteEliminado;
    }

    public Restaurante actualizarRestaurante(int id, Restaurante restauranteActualizado){
        for(int i = 0; i < this.restaurantes.size(); i++){
            if(this.restaurantes.get(i).getId() == id){
                this.restaurantes.set(i, restauranteActualizado);
                return restauranteActualizado;
            }
        }return null;
    }

    public Restaurante obtenerRestaurante(int id){
        for (Restaurante restaurante : this.restaurantes){
            if(restaurante.getId() == id){
                return restaurante;
            }
        }return null;
    }

    public ArrayList<Restaurante> obtenerRestaurantes(){
        return this.restaurantes;
    }
}
