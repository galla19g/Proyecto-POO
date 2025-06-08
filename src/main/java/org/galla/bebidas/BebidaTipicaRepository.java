package org.galla.bebidas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BebidaTipicaRepository {
    private final List<BebidaTipica> bebidas = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public BebidaTipica agregarBebida(BebidaTipica bebida) {
        bebida.setIdBebida(idCounter.getAndIncrement());
        bebidas.add(bebida);
        return bebida;
    }

    public BebidaTipica eliminarBebida(int id) {
        for (int i = 0; i < bebidas.size(); i++) {
            if (bebidas.get(i).getIdBebida() == id) {
                return bebidas.remove(i);
            }
        }
        return null;
    }

    public BebidaTipica actualizarBebida(int id, BebidaTipica bebidaActualizada) {
        for (int i = 0; i < bebidas.size(); i++) {
            if (bebidas.get(i).getIdBebida() == id) {
                bebidaActualizada.setIdBebida(id);
                bebidas.set(i, bebidaActualizada);
                return bebidaActualizada;
            }
        }
        return null;
    }

    public BebidaTipica obtenerBebidaPorId(int id) {
        for (BebidaTipica bebida : bebidas) {
            if (bebida.getIdBebida() == id) {
                return bebida;
            }
        }
        return null;
    }

    public List<BebidaTipica> obtenerTodasLasBebidas() {
        return new ArrayList<>(bebidas);
    }
}