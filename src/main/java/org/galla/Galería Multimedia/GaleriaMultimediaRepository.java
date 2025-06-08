package org.galla.multimedia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class GaleriaMultimediaRepository {
    private final List<GaleriaMultimedia> multimedia = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public GaleriaMultimedia agregarMultimedia(GaleriaMultimedia multimediaItem) {
        multimediaItem.setIdMultimedia(idCounter.getAndIncrement());
        multimedia.add(multimediaItem);
        return multimediaItem;
    }

    public GaleriaMultimedia eliminarMultimedia(int id) {
        for (int i = 0; i < multimedia.size(); i++) {
            if (multimedia.get(i).getIdMultimedia() == id) {
                return multimedia.remove(i);
            }
        }
        return null;
    }

    public GaleriaMultimedia actualizarMultimedia(int id, GaleriaMultimedia multimediaActualizado) {
        for (int i = 0; i < multimedia.size(); i++) {
            if (multimedia.get(i).getIdMultimedia() == id) {
                multimediaActualizado.setIdMultimedia(id);
                multimedia.set(i, multimediaActualizado);
                return multimediaActualizado;
            }
        }
        return null;
    }

    public GaleriaMultimedia obtenerMultimediaPorId(int id) {
        for (GaleriaMultimedia multimediaItem : multimedia) {
            if (multimediaItem.getIdMultimedia() == id) {
                return multimediaItem;
            }
        }
        return null;
    }

    public List<GaleriaMultimedia> obtenerTodoElMultimedia() {
        return new ArrayList<>(multimedia);
    }
}