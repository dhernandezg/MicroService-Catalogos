package com.baz.origen.services;

import com.baz.origen.daos.ActualizarOrigen;
import com.baz.origen.daos.ConsultarOrigen;
import com.baz.origen.daos.CrearOrigen;
import com.baz.origen.daos.EliminarOrigen;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;

/**
 * <b>${nombreClase}</b>
 * @descripcion: breve descripción del contenido
 * @autor: ${user}, Desarrollador
 * @param String Descripcion
 * @ultimaModificacion: ${date}
 */

@Singleton
public class OrigenService {

    @Inject
    CrearOrigen crearOrigen;

    @Inject
    ConsultarOrigen consultarOrigen;

    @Inject
    ActualizarOrigen actualizarOrigen;

    @Inject
    EliminarOrigen eliminarOrigen;

    /**
     * <b>listaOperacionesOrigen</b>
     * @descripcion: Método para generar lista de operaciones
     * que pueden ejecutarse en el servicio.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 12/05/2022
     */

    public ArrayList listaOperacionesOrigen(){

        ArrayList<String> lista = new ArrayList<>();

        lista.add(Constantes.CREATE + Constantes.ORIGEN);
        lista.add(Constantes.READ + Constantes.ORIGEN);
        lista.add(Constantes.UPDATE + Constantes.ORIGEN);
        lista.add(Constantes.DELETE + Constantes.ORIGEN);

        return lista;
    }
}
