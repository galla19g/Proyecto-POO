package org.galla.ComunidadIndígenaGastronomia;

import org.galla.ComunidadIndígenaGastronomia.ComunidadIndigenaGastronomia;
import org.galla.compartidos.BadParameterException;
import org.galla.compartidos.NotFoundException;

import java.util.List;

public class ComunidadIndigenaGastronomiaService {
    private final org.galla.comunidadad.ComunidadIndigenaGastronomiaRepository comunidadRepository;

    public ComunidadIndigenaGastronomiaService(org.galla.comunidades.ComunidadIndigenaGastronomiaRepository comunidadRepository) {
        this.comunidadRepository = comunidadRepository;
    }

    private void validarComunidad(ComunidadIndigenaGastronomia comunidad) throws BadParameterException {
        if (comunidad == null) {
            throw new BadParameterException("El objeto ComunidadIndigenaGastronomia no puede ser nulo.");
        }
        if (comunidad.getNombreComunidad() == null || comunidad.getNombreComunidad().trim().isEmpty()) {
            throw new BadParameterException("El nombre de la comunidad no puede ser nulo o vacío.");
        }
        if (comunidad.getZonaGeograficaDeInfluencia() == null || comunidad.getZonaGeograficaDeInfluencia().trim().isEmpty()) {
            throw new BadParameterException("La zona geográfica de influencia no puede ser nula o vacía.");
        }
    }

    public ComunidadIndigenaGastronomia agregarComunidad(ComunidadIndigenaGastronomia comunidad) throws BadParameterException {
        validarComunidad(comunidad);
        return comunidadRepository.agregarComunidad(comunidad);
    }

    public void eliminarCom