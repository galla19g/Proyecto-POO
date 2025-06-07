package org.galla.eventosgastronomicos;

import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class EventogastronomicoService {
    private final EventogastronomicoRepository eventoRepository;

    public EventogastronomicoService(EventogastronomicoRepository eventogastronomicoRepository){
        this.eventoRepository = eventogastronomicoRepository;
    }

    public void validarEvento(Eventogastronomico eventogastronomico) throws BadParameterException{
        if (eventogastronomico == null){
            throw new BadParameterException("El evento gastronomico no puede ser nulo");
        }
        if (eventogastronomico.getnombreEvento() == null || eventogastronomico.getnombreEvento().trim().isEmpty()){
            throw new BadParameterException ("El nombre del evento gastronomico no puede ser nulo o vacio");
        }
        if (eventogastronomico.getdescripcion() == null || eventogastronomico.getdescripcion().trim().isEmpty()){
            throw new BadParameterException ("La descripcion del evento gastronomico no puede ser nula o vacia");
        }
        if (eventogastronomico.getfechaInicio() == null || eventogastronomico.getfechaInicio().trim().isEmpty()){
            throw new BadParameterException ("La fecha de inicio del evento gastronomico no puede ser nula o vacia");
        }
        if (eventogastronomico.getfechaFin() == null || eventogastronomico.getfechaFin().trim().isEmpty()){
            throw new BadParameterException("La fecha de fin de evento gastronomico no puede ser nula o vacia");
        }
        if (eventogastronomico.getubicacion() == null || eventogastronomico.getubicacion().trim().isEmpty()){
            throw new BadParameterException(" La ubicacion del evento gastronomico no puede ser nula o vacia");
        }
        if (eventogastronomico.getorganizador() == null || eventogastronomico.getorganizador().trim().isEmpty()){
            throw new BadParameterException("El organizador del evento gastronomico no puede ser nulo o vacio");
        }
        if (eventogastronomico.gettipoEvento() == null || eventogastronomico.gettipoEvento().trim().isEmpty()){
            throw new BadParameterException("El tipo del evento gastronomico no puede ser nulo o vacio");
        }
    }

    public Eventogastronomico agregarEvento(Eventogastronomico eventogastronomico){
        validarEvento(eventogastronomico);
        return this.eventoRepository.agregarevento(eventogastronomico);
        
    }

    public void eliminarEventoGastronomico(String id){
        if (id == null){
            throw new NotFoundException("No existe un evento con ese id");
        }else{
            Eventogastronomico evento = this.eventoRepository.eliminarEventogastronomico(Integer.parseInt(id));
            if (evento == null){
                throw new NotFoundException("No existe un evento gastronomico que se pueda eliminar con el id que proporcionaste");
            }
        }
    }

    public Eventogastronomico actualizarEventoGastronomico(String idString, Eventogastronomico datosEventoGastronomicoactualizar) throws BadParameterException, NotFoundException{
        if (idString == null){
            throw new NotFoundException("No existe ningun evento gastronomico para actualizar con ese id que proporcionaste");
        }
        int id;
        try{
            id = Integer.parseInt(idString);
        } catch (NumberFormatException e){
            throw new BadParameterException("El id del evento gastronomico" + idString + "no es valido para actualizar");
        }

        validarEvento(datosEventoGastronomicoactualizar);
        datosEventoGastronomicoactualizar.setId(id);
        Eventogastronomico eventogastronomicoActualizarEnRepo = this.eventoRepository.actualizarEventogastronomico(id, datosEventoGastronomicoactualizar);

        if (eventogastronomicoActualizarEnRepo == null){
            throw new NotFoundException("No se encontroo un evento gastronomico con el id" +id+ "para actualizar");
        }
        return eventogastronomicoActualizarEnRepo;
    }

    public Eventogastronomico obtenerEventogastronomico(String id){
        if (id == null){
            throw new NotFoundException("NO existe un evento gastronomico con ese id");
        } else {
            return this.eventoRepository.obtenerEventogastronomico(Integer.parseInt(id));
        }
    }

    public List<Eventogastronomico> obtenerEventos(){
        return this.eventoRepository.obtenerEventos();
    }

}
