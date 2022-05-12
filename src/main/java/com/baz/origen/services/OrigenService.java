package com.baz.origen.services;

import com.baz.origen.daos.ActualizarOrigen;
import com.baz.origen.daos.ConsultarOrigen;
import com.baz.origen.daos.CrearOrigen;
import com.baz.origen.daos.EliminarOrigen;
import com.baz.origen.models.OrigenModel;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * <b>crearOrigen</b>
     * @descripcion: Método para invocar crear origen.
     * @autor: Diego Vázquez Pérez
     * @param descripcionOrigen Descripción del origen
     * @param claveOrigen Clave del origen
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 12/05/2022
     */

    public boolean crearOrigen(String descripcionOrigen,
                               String claveOrigen,
                               String usuarioNombre){
        return crearOrigen.crearOrigen(descripcionOrigen,
                claveOrigen,
                usuarioNombre);
    }

    /**
     * <b>consultarOrigen</b>
     * @descripcion: Método para invocar consultar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen
     * @param descripcionOrigen Descripción del origen
     * @param claveOrigen Clave del origen
     * @ultimaModificacion: 12/05/2022
     */

    public List<OrigenModel> consultarOrigen(Integer idOrigen,
                                             String descripcionOrigen,
                                             String claveOrigen){

        return consultarOrigen.consultarOrigen(idOrigen,
                descripcionOrigen,
                claveOrigen);
    }

    /**
     * <b>actualizarOrigen</b>
     * @descripcion: Método para invocar actualizar origen
     * @autor: Diego Vázquez Pérez
     * @param origenModel Modelo de atributos del tipo Origen
     * @ultimaModificacion: 12/05/2022
     */

    public boolean actualizarOrigen(OrigenModel origenModel){
        return actualizarOrigen.actualizarOrigen(origenModel);
    }
}
