package org.galla.ComunidadIndigenaGastronomica;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



public class ComunidadIndigenaGastronomiaRepository {
    private final List<ComunidadIndigenaGastronomia> comunidades = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public ComunidadIndigenaGastronomia agregarComunidad(ComunidadIndigenaGastronomia comunidad) {
        comunidad.setIdComunidad(idCounter.getAndIncrement());
        comunidades.add(comunidad);
        return comunidad;
    }

    public ComunidadIndigenaGastronomia eliminarComunidad(int id) {
        for (int i = 0; i < comunidades.size(); i++) {
            if (comunidades.get(i).getIdComunidad() == id) {
                return comunidades.remove(i);
            }
        }
        return null;
    }

    public ComunidadIndigenaGastronomia actualizarComunidad(int id, ComunidadIndigenaGastronomia comunidadActualizada) {
        for (int i = 0; i < comunidades.size(); i++) {
            if (comunidades.get(i).getIdComunidad() == id) {
                comunidadActualizada.setIdComunidad(id);
                comunidades.set(i, comunidadActualizada);
                return comunidadActualizada;
            }
        }
        return null;
    }

    public ComunidadIndigenaGastronomia obtenerComunidadPorId(int id) {
        for (ComunidadIndigenaGastronomia comunidad : comunidades) {
            if (comunidad.getIdComunidad() == id) {
                return comunidad;
            }
        }
        return null;
    }

    public List<ComunidadIndigenaGastronomia> obtenerTodasLasComunidades() {
        return new ArrayList<>(comunidades);
    }
}