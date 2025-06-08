package org.galla.categorias;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CategoriaRepository {
    private final List<Categoria> categorias = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Categoria agregar(Categoria categoria) {
        categoria.setId(idCounter.getAndIncrement());
        this.categorias.add(categoria);
        return categoria;
    }

    public Categoria eliminar(int id) {
        Categoria categoriaEliminada = null;
        for (int i = 0; i < this.categorias.size(); i++) {
            if (this.categorias.get(i).getId() == id) {
                categoriaEliminada = this.categorias.remove(i);
                break;
            }
        }
        return categoriaEliminada;
    }

    public Categoria actualizar(int id, Categoria categoriaActualizada) {
        for (int i = 0; i < this.categorias.size(); i++) {
            if (this.categorias.get(i).getId() == id) {
                categoriaActualizada.setId(id);
                this.categorias.set(i, categoriaActualizada);
                return categoriaActualizada;
            }
        }
        return null;
    }

    public Categoria obtenerPorId(int id) {
        for (Categoria categoria : this.categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }

    public List<Categoria> obtenerTodos() {
        return this.categorias;
    }
}
