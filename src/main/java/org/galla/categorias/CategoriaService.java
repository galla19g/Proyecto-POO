package org.galla.categorias;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;
import java.util.Arrays;

public class CategoriaService {
    private final CategoriaRepository repository;
    private final List<String> tiposValidos = Arrays.asList("Receta", "Producto");


    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    private void validar(Categoria categoria) throws BadParameterException {
        if (categoria == null) {
            throw new BadParameterException("La categoría no puede ser nula.");
        }
        if (categoria.getNombre() == null || categoria.getNombre().trim().isEmpty()) {
            throw new BadParameterException("El nombre de la categoría no puede ser nulo o vacío.");
        }
        if (categoria.getTipo() == null || !tiposValidos.contains(categoria.getTipo())) {
            throw new BadParameterException("El tipo de categoría debe ser 'Receta' or 'Producto'.");
        }
    }

    public Categoria agregar(Categoria categoria) {
        validar(categoria);
        return this.repository.agregar(categoria);
    }

    public void eliminar(String idString) {
        try {
            int id = Integer.parseInt(idString);
            Categoria categoria = this.repository.eliminar(id);
            if (categoria == null) {
                throw new NotFoundException("No se encontró una categoría con el ID " + id);
            }
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la categoría debe ser un número.");
        }
    }

    public Categoria actualizar(String idString, Categoria categoria) {
        try {
            int id = Integer.parseInt(idString);
            validar(categoria);
            Categoria actualizada = this.repository.actualizar(id, categoria);
            if (actualizada == null) {
                throw new NotFoundException("No se encontró una categoría con el ID " + id + " para actualizar.");
            }
            return actualizada;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la categoría debe ser un número.");
        }
    }

    public Categoria obtenerPorId(String idString) {
        try {
            int id = Integer.parseInt(idString);
            Categoria categoria = this.repository.obtenerPorId(id);
            if (categoria == null) {
                throw new NotFoundException("No se encontró una categoría con el ID " + id);
            }
            return categoria;
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la categoría debe ser un número.");
        }
    }

    public List<Categoria> obtenerTodos() {
        return this.repository.obtenerTodos();
    }
}
