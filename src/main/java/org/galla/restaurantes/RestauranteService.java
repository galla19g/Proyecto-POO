package org.galla.restaurantes;

import java.util.List;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

public class RestauranteService {
    private final RestauranteRepository restauranteRepository;

    public RestauranteService(RestauranteRepository restauranteRepository){
        this.restauranteRepository = restauranteRepository;
    }

    public void validarRestaurante(Restaurante restaurante) throws BadParameterException{
        if (restaurante == null){
            throw new BadParameterException("el restaurante no puede ser nulo");
        }
        if (restaurante.getnombrerestaurante() == null || restaurante.getnombrerestaurante().trim().isEmpty()){
            throw new BadParameterException("El nombre del restaurante no puede ser nulo o vacio");
        }
        if (restaurante.getdescripcion() == null || restaurante.getdescripcion().trim().isEmpty()){
            throw new BadParameterException("La descripcion del restaurante no puede ser nula o vacia");
        }
        if (restaurante.getdireccion() == null || restaurante.getdireccion().trim().isEmpty()){
            throw new BadParameterException("la idreccion del restaurante no puede ser nula o vacia");
        }
        if (restaurante.gettelefono() ==null || restaurante.gettelefono().trim().isEmpty()){
            throw new BadParameterException("El telefono del restaurante no puede ser nulo o vacio");
        }
        if (restaurante.gethorarioAtencion() == null || restaurante.gethorarioAtencion().trim().isEmpty()){
            throw new BadParameterException("El horario de atencion del restaurante no puede ser nulo o vacio");
        }
        if (restaurante.getrangoPrecios() == null || restaurante.getrangoPrecios().trim().isEmpty()){
            throw new BadParameterException("EL rango de precios del restaurante no puede ser nulo o vacio");
        }
    }

    public void agregarRestaurante(Restaurante restaurante){
        this.validarRestaurante(restaurante);
        this.restauranteRepository.agregarRestaurante(restaurante);
    }

    public void eliminarRestaurante(String id){
        if (id == null){
            throw new NotFoundException("No existe el id de ese restaurante");
        }else{
            Restaurante restaurante = this.restauranteRepository.eliminarRestaurante(Integer.parseInt(id));
            if (restaurante == null){
                throw new NotFoundException("No existe ese restaurante que buscas");
            }
        }
    }

    public Restaurante actualizarRestaurante(String idString, Restaurante datosRestauranteActualizar) throws BadParameterException, NotFoundException{
        if( idString == null){
            throw new NotFoundException("No existe ningun restaurante con ese id ");
        }
        int id;
        try{
            id = Integer.parseInt(idString);
        }catch(NumberFormatException e){
            throw new BadParameterException("El ID del restaurante" + idString + "no es un restaurante valido que se pueda actualizar");
        }

        validarRestaurante(datosRestauranteActualizar);
        datosRestauranteActualizar.setId(id);
        Restaurante restauranteActuaizadaEnRepo = this.restauranteRepository.actualizarRestaurante(id, datosRestauranteActualizar);
        if(restauranteActuaizadaEnRepo == null){
            throw new NotFoundException("No se encontro un restaurante con el id" + id + "para actualizar");
        }
        return restauranteActuaizadaEnRepo;
    }

    public Restaurante obtenerRestaurante(String id){
        if (id == null){
            throw new NotFoundException("No existe ese restaurante que acabas de buscar");
        }else {
            return this.restauranteRepository.obtenerRestaurante(Integer.parseInt(id));
        }
    }

    public List<Restaurante> obtenerRestaurantes(){
        return this.restauranteRepository.obtenerRestaurantes();
    }

}
