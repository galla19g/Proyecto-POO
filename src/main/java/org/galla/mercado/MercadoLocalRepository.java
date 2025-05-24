package org.galla.mercado;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MercadoLocalRepository {
    private final List<MercadoLocal> mercados = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public MercadoLocal agregarMercado(MercadoLocal mercado) {
        mercado.setIdMercado(idCounter.getAndIncrement());
        this.mercados.add(mercado);
        return mercado;
    }

    public MercadoLocal eliminarMercado(int id) {
        MercadoLocal mercadoEliminado = null;
        for (int i = 0; i < this.mercados.size(); i++) {
            if (this.mercados.get(i).getIdMercado() == id) {
                mercadoEliminado = this.mercados.remove(i);
                break;
            }
        }
        return mercadoEliminado;
    }

    public MercadoLocal actualizarMercado(int id, MercadoLocal mercadoActualizado) {
        for (int i = 0; i < this.mercados.size(); i++) {
            if (this.mercados.get(i).getIdMercado() == id) {
                mercadoActualizado.setIdMercado(id); 
                this.mercados.set(i, mercadoActualizado);
                return mercadoActualizado;
            }
        }
        return null; 
    }

    public MercadoLocal obtenerMercadoPorId(int id) {
        for (MercadoLocal mercado : this.mercados) {
            if (mercado.getIdMercado() == id) {
                return mercado;
            }
        }
        return null;
    }

    public List<MercadoLocal> obtenerTodosLosMercados() {
        return new ArrayList<>(this.mercados); 
    }
}