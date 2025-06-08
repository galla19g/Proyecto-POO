package org.galla.comentarios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ComentarioRepository {
    private final List<Comentario> comentarios = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Comentario agregar(Comentario comentario) {
        comentario.setId(idCounter.getAndIncrement());
        this.comentarios.add(comentario);
        return comentario;
    }

    public Comentario eliminar(int id) {
        Comentario comentarioEliminado = null;
        for (int i = 0; i < this.comentarios.size(); i++) {
            if (this.comentarios.get(i).getId() == id) {
                comentarioEliminado = this.comentarios.remove(i);
                break;
            }
        }
        return comentarioEliminado;
    }

    public Comentario actualizar(int id, Comentario comentarioActualizado) {
        for (int i = 0; i < this.comentarios.size(); i++) {
            if (this.comentarios.get(i).getId() == id) {
                comentarioActualizado.setId(id);
                this.comentarios.set(i, comentarioActualizado);
                return comentarioActualizado;
            }
        }
        return null;
    }

    public Comentario obtenerPorId(int id) {
        for (Comentario comentario : this.comentarios) {
            if (comentario.getId() == id) {
                return comentario;
            }
        }
        return null;
    }

    public List<Comentario> obtenerTodos() {
        return this.comentarios;
    }
}