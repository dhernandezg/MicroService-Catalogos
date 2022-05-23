package com.baz.origen.services;

import com.baz.origen.daos.ActualizarOrigenDao;
import com.baz.origen.daos.ConsultarOrigenDao;
import com.baz.origen.daos.CrearOrigenDao;
import com.baz.origen.daos.EliminarOrigenDao;
import com.baz.origen.models.OrigenModel;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>OrigenService</b>
 * @descripcion: Clase principal del servicio de Origen,
 * dentro se encuentran los métodos CRUDde origen.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 12/05/2022
 */

@Singleton
public class OrigenService {

    @Inject
    CrearOrigenDao crearOrigenDao;

    @Inject
    ConsultarOrigenDao consultarOrigenDao;

    @Inject
    ActualizarOrigenDao actualizarOrigenDao;

    @Inject
    EliminarOrigenDao eliminarOrigenDao;

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
     * <b>crearOrigenDao</b>
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
        return crearOrigenDao.crearOrigen(descripcionOrigen,
                claveOrigen,
                usuarioNombre);
    }

    /**
     * <b>consultarOrigenDao</b>
     * @descripcion: Método para invocar consultar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen
     * @param claveOrigen Clave del origen
     * @ultimaModificacion: 12/05/2022
     */

    public List<OrigenModel> consultarOrigen(Short idOrigen,
                                             String claveOrigen){

        return consultarOrigenDao.consultarOrigen(idOrigen,
                claveOrigen);
    }

    /**
     * <b>actualizarOrigenDao</b>
     * @descripcion: Método para invocar actualizar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen a actualizar
     * @param descripcionOrigen Nueva descripción del origen
     * @param claveOrigen Nueva clave del origen
     * @param idEstatus Nuevo estatus del origen
     * @param usuarioNombre Nombre del usuario que actualiza
     * @ultimaModificacion: 16/05/2022
     */

    public boolean actualizarOrigen(
            Short idOrigen,
            String descripcionOrigen,
            String claveOrigen,
            Short idEstatus,
            String usuarioNombre){
        return actualizarOrigenDao.actualizarOrigen(
                idOrigen,
                descripcionOrigen,
                claveOrigen,
                idEstatus,
                usuarioNombre);
    }

    /**
     * <b>eliminarOrigenDao
     * @descripcion: Método para invocar eliminar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen a eliminar
     * @param usuarioNombre Nombre del usuario que elimina
     * @ultimaModificacion: 16/05/2022
     */

    public boolean eliminarOrigen(Short idOrigen,
                                  String usuarioNombre){

        return eliminarOrigenDao.eliminarOrigen(idOrigen, usuarioNombre);
    }
}
