package org.galla.recetas;

import java.util.List;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

public class RecetaService {
    private final RecetaRepository recetaRepository;

    public RecetaService(RecetaRepository recetaRepository) {
        this.recetaRepository = recetaRepository;
    }

    private void validarReceta(Receta receta) throws BadParameterException  {
        if (receta == null) {
            throw new BadParameterException("La receta no puede ser nula");
        }
        if (receta.getNombre() == null || receta.getNombre().trim().isEmpty()){
            throw new BadParameterException("El nombre de la receta no puede ser nulo o vacio");
        }
        if (receta.getIngredientes() == null || receta.getIngredientes().trim().isEmpty()){
            throw new BadParameterException("Los ingredientes de la receta no pueden estar vacias");
        }
        if (receta.getInstrucciones() == null || receta.getInstrucciones().trim().isEmpty()){
            throw new BadParameterException("Las instrucciones de la receta no pueden estar vacias");
        }
        if (receta.getTiempoDePreparacion() <= 0){
            throw new BadParameterException("Debes poner un tiempo de preparacion ");
        }
    }

    public void agregarReceta (Receta receta) {
        this.validarReceta(receta);
        this.recetaRepository.agregarReceta(receta);
    }

    public void eliminarReceta(String id ){
        if (id == null){
            throw new NotFoundException("No existe el id de la receta");
        }else {
            Receta receta = this.recetaRepository.eliminarReceta(Integer.parseInt(id));
            if (receta == null){
                throw new NotFoundException("No existe esa receta que buscaste");
            }
        }
    }

    public Receta actualizarReceta(String idString , Receta datosRecetaActualizar) throws BadParameterException, NotFoundException{
        if (idString == null){
            throw new NotFoundException ("no existe ese id de alguna receta para actualizar");
        }
        int id;
        try {
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e) {
            throw new BadParameterException("El ID de la receta" + idString + " no es un numero valido que se pueda actualizar");
        }

        validarReceta(datosRecetaActualizar);
        datosRecetaActualizar.setId(id);
        Receta recetaActualizadaEnRepo = this.recetaRepository.actualizarReceta(id, datosRecetaActualizar);

        if (recetaActualizadaEnRepo == null){
            throw new NotFoundException("No se encontro una receta con el id" + id + "para actualziar");
        }
        return recetaActualizadaEnRepo;
    }

    public Receta obtenerReceta(String id){
        if (id == null){
            throw new NotFoundException("No existe esa receta que buscaste");
        } else {
            return this.recetaRepository.obtenerReceta(Integer.parseInt(id));
        }
    }

    public List<Receta> obtenerRecetas(){
        return this.recetaRepository.obtenerRecetas();
    }
}

