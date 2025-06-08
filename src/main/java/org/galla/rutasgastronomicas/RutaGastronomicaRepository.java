package org.galla.rutasgastronomicas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RutaGastronomicaRepository {
    private final List<RutaGastronomica> rutas = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public RutaGastronomica agregar(RutaGastronomica ruta) {
        ruta.setId(idCounter.getAndIncrement());
        this.rutas.add(ruta);
        return ruta;
    }

    public RutaGastronomica eliminar(int id) {
        RutaGastronomica rutaEliminada = null;
        for (int i = 0; i < this.rutas.size(); i++) {
            if (this.rutas.get(i).getId() == id) {
                rutaEliminada = this.rutas.remove(i);
                break;
            }
        }
        return rutaEliminada;
    }

    public RutaGastronomica actualizar(int id, RutaGastronomica rutaActualizada) {
        for (int i = 0; i < this.rutas.size(); i++) {
            if (this.rutas.get(i).getId() == id) {
                rutaActualizada.setId(id);
                this.rutas.set(i, rutaActualizada);
                return rutaActualizada;
            }
        }
        return null;
    }

    public RutaGastronomica obtenerPorId(int id) {
        for (RutaGastronomica ruta : this.rutas) {
            if (ruta.getId() == id) {
                return ruta;
            }
        }
        return null;
    }

    public List<RutaGastronomica> obtenerTodas() {
        return this.rutas;
    }
}