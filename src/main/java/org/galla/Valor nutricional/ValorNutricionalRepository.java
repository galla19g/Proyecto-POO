package org.galla.nutricion;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ValorNutricionalRepository {
    private final List<ValorNutricional> nutriciones = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public ValorNutricional agregarNutricion(ValorNutricional nutricion) {
        nutricion.setIdValorNutricional(idCounter.getAndIncrement());
        nutriciones.add(nutricion);
        return nutricion;
    }

    public ValorNutricional eliminarNutricion(int id) {
        for (int i = 0; i < nutriciones.size(); i++) {
            if (nutriciones.get(i).getIdValorNutricional() == id) {
                return nutriciones.remove(i);
            }
        }
        return null;
    }

    public ValorNutricional actualizarNutricion(int id, ValorNutricional nutricionActualizada) {
        for (int i = 0; i < nutriciones.size(); i++) {
            if (nutriciones.get(i).getIdValorNutricional() == id) {
                nutricionActualizada.setIdValorNutricional(id);
                nutriciones.set(i, nutricionActualizada);
                return nutricionActualizada;
            }
        }
        return null;
    }

    public ValorNutricional obtenerNutricionPorId(int id) {
        for (ValorNutricional nutricion : nutriciones) {
            if (nutricion.getIdValorNutricional() == id) {
                return nutricion;
            }
        }
        return null;
    }

    public List<ValorNutricional> obtenerTodasLasNutriciones() {
        return new ArrayList<>(nutriciones);
    }
}