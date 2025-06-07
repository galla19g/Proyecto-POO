package org.galla.eventosgastronomicos;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class EventogastronomicoRepository {
    private final ArrayList<Eventogastronomico> eventos = new ArrayList();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public Eventogastronomico agregarevento(Eventogastronomico eventogastronomico){
        eventogastronomico.setId(this.idCounter.incrementAndGet());
        this.eventos.add(eventogastronomico);
        return eventogastronomico;
    }

    public Eventogastronomico eliminarEventogastronomico (int id){
        Eventogastronomico eventoEliminado = null;
        for(int i=0; i<this.eventos.size(); i++){
            if(this.eventos.get(i).getId() == id){
                eventoEliminado = this.eventos.remove(i);
                break;
            }
        }return eventoEliminado;
    } 

    public Eventogastronomico actualizarEventogastronomico(int id, Eventogastronomico eventoActualizado){
        for(int i=0; i<this.eventos.size(); i++){
            if(this.eventos.get(i).getId() == id){
                this.eventos.set(i, eventoActualizado);
                return eventoActualizado;
            }
        }return null;
    }

    public Eventogastronomico obtenerEventogastronomico(int id){
        for(Eventogastronomico evento : this.eventos){
            if(evento.getId() == id){
                return evento;
            }
        }return null;
    }

    public ArrayList<Eventogastronomico> obtenerEventos(){
        return this.eventos;
    }   
}
