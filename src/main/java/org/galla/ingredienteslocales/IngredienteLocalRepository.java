package org.galla.ingredienteslocales;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IngredienteLocalRepository {
    private final List<IngredienteLocal> ingredientes = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public IngredienteLocal agregar(IngredienteLocal ingrediente) {
        ingrediente.setId(idCounter.getAndIncrement());
        this.ingredientes.add(ingrediente);
        return ingrediente;
    }

    public IngredienteLocal eliminar(int id) {
        IngredienteLocal ingredienteEliminado = null;
        for (int i = 0; i < this.ingredientes.size(); i++) {
            if (this.ingredientes.get(i).getId() == id) {
                ingredienteEliminado = this.ingredientes.remove(i);
                break;
            }
        }
        return ingredienteEliminado;
    }

    public IngredienteLocal actualizar(int id, IngredienteLocal ingredienteActualizado) {
        for (int i = 0; i < this.ingredientes.size(); i++) {
            if (this.ingredientes.get(i).getId() == id) {
                ingredienteActualizado.setId(id);
                this.ingredientes.set(i, ingredienteActualizado);
                return ingredienteActualizado;
            }
        }
        return null;
    }

    public IngredienteLocal obtenerPorId(int id) {
        for (IngredienteLocal ingrediente : this.ingredientes) {
            if (ingrediente.getId() == id) {
                return ingrediente;
            }
        }
        return null;
    }

    public List<IngredienteLocal> obtenerTodos() {
        return this.ingredientes;
    }
}