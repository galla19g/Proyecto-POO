package org.galla.chefs;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ChefRepository {
    private final List<Chef> chefs = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Chef agregar(Chef chef) {
        chef.setId(idCounter.getAndIncrement());
        this.chefs.add(chef);
        return chef;
    }

    public Chef eliminar(int id) {
        Chef chefEliminado = null;
        for (int i = 0; i < this.chefs.size(); i++) {
            if (this.chefs.get(i).getId() == id) {
                chefEliminado = this.chefs.remove(i);
                break;
            }
        }
        return chefEliminado;
    }

    public Chef actualizar(int id, Chef chefActualizado) {
        for (int i = 0; i < this.chefs.size(); i++) {
            if (this.chefs.get(i).getId() == id) {
                chefActualizado.setId(id);
                this.chefs.set(i, chefActualizado);
                return chefActualizado;
            }
        }
        return null;
    }

    public Chef obtenerPorId(int id) {
        for (Chef chef : this.chefs) {
            if (chef.getId() == id) {
                return chef;
            }
        }
        return null;
    }

    public List<Chef> obtenerTodos() {
        return this.chefs;
    }
}