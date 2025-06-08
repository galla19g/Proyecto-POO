package org.galla.Utensilios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UtensilioTradicionalRepository {
    private final List<UtensilioTradicional> utensilios = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public UtensilioTradicional agregarUtensilio(UtensilioTradicional utensilio) {
        utensilio.setIdUtensilio(idCounter.getAndIncrement());
        utensilios.add(utensilio);
        return utensilio;
    }

    public UtensilioTradicional eliminarUtensilio(int id) {
        for (int i = 0; i < utensilios.size(); i++) {
            if (utensilios.get(i).getIdUtensilio() == id) {
                return utensilios.remove(i);
            }
        }
        return null;
    }

    public UtensilioTradicional actualizarUtensilio(int id, UtensilioTradicional utensilioActualizado) {
        for (int i = 0; i < utensilios.size(); i++) {
            if (utensilios.get(i).getIdUtensilio() == id) {
                utensilioActualizado.setIdUtensilio(id);
                utensilios.set(i, utensilioActualizado);
                return utensilioActualizado;
            }
        }
        return null;
    }

    public UtensilioTradicional obtenerUtensilioPorId(int id) {
        for (UtensilioTradicional utensilio : utensilios) {
            if (utensilio.getIdUtensilio() == id) {
                return utensilio;
            }
        }
        return null;
    }

    public List<UtensilioTradicional> obtenerTodosLosUtensilios() {
        return new ArrayList<>(utensilios);
    }
}