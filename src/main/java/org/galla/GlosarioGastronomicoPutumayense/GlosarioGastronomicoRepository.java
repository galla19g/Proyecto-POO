package org.galla.glosario;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GlosarioGastronomicoRepository {
    private final List<org.galla.GlosarioGastronomico.GlosarioGastronomico> terminos = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public org.galla.GlosarioGastronomico.GlosarioGastronomico agregarTermino(org.galla.GlosarioGastronomico.GlosarioGastronomico termino) {
        termino.setIdTermino(idCounter.getAndIncrement());
        terminos.add(termino);
        return termino;
    }

    public org.galla.GlosarioGastronomico.GlosarioGastronomico eliminarTermino(int id) {
        for (int i = 0; i < terminos.size(); i++) {
            if (terminos.get(i).getIdTermino() == id) {
                return terminos.remove(i);
            }
        }
        return null;
    }

    public GlosarioGastronomico actualizarTermino(int id, GlosarioGastronomico terminoActualizado) {
        for (int i = 0; i < terminos.size(); i++) {
            if (terminos.get(i).getIdTermino() == id) {
                terminoActualizado.setIdTermino(id);
                terminos.set(i, terminoActualizado);
                return terminoActualizado;
            }
        }
        return null;
    }

    public GlosarioGastronomico obtenerTerminoPorId(int id) {
        for (GlosarioGastronomico termino : terminos) {
            if (termino.getIdTermino() == id) {
                return termino;
            }
        }
        return null;
    }

    public List<GlosarioGastronomico> obtenerTodosLosTerminos() {
        return new ArrayList<>(terminos);
    }
}