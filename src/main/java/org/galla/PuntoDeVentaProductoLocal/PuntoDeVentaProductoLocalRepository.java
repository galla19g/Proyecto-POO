package org.galla.puntosdeventa;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PuntoDeVentaProductoLocalRepository {
    private final List<PuntoDeVentaProductoLocal> puntosDeVenta = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public PuntoDeVentaProductoLocal agregarPuntoDeVenta(PuntoDeVentaProductoLocal puntoDeVenta) {
        puntoDeVenta.setIdPuntoVenta(idCounter.getAndIncrement());
        puntosDeVenta.add(puntoDeVenta);
        return puntoDeVenta;
    }

    public PuntoDeVentaProductoLocal eliminarPuntoDeVenta(int id) {
        for (int i = 0; i < puntosDeVenta.size(); i++) {
            if (puntosDeVenta.get(i).getIdPuntoVenta() == id) {
                return puntosDeVenta.remove(i);
            }
        }
        return null;
    }

    public PuntoDeVentaProductoLocal actualizarPuntoDeVenta(int id, PuntoDeVentaProductoLocal puntoDeVentaActualizado) {
        for (int i = 0; i < puntosDeVenta.size(); i++) {
            if (puntosDeVenta.get(i).getIdPuntoVenta() == id) {
                puntoDeVentaActualizado.setIdPuntoVenta(id);
                puntosDeVenta.set(i, puntoDeVentaActualizado);
                return puntoDeVentaActualizado;
            }
        }
        return null;
    }

    public PuntoDeVentaProductoLocal obtenerPuntoDeVentaPorId(int id) {
        for (PuntoDeVentaProductoLocal puntoDeVenta : puntosDeVenta) {
            if (puntoDeVenta.getIdPuntoVenta() == id) {
                return puntoDeVenta;
            }
        }
        return null;
    }

    public List<PuntoDeVentaProductoLocal> obtenerTodosLosPuntosDeVenta() {
        return new ArrayList<>(puntosDeVenta);
    }
}