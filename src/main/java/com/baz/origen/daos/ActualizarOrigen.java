package com.baz.origen.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.origen.models.OrigenModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarOrigen</b>
 * @descripcion: Clase de acceso a DB para actualizar origen.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 12/05/2022
 */

@ApplicationScoped
public class ActualizarOrigen {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>actualizarOrigen</b>
     * @descripcion: Método para actualizar origen en DB
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen a actualizar
     * @param descripcionOrigen Nueva descripción del origen
     * @param claveOrigen Nueva clave del origen
     * @param idStatus Nuevo status del origen
     * @param usuarioNombre Nombre del usuario que actualiza
     * @ultimaModificacion: 16/05/2022
     */

    public boolean actualizarOrigen(
            Integer idOrigen,
            String descripcionOrigen,
            String claveOrigen,
            Integer idStatus,
            String usuarioNombre){

        StoredProcedure actualizarOrigenFuncion = new StoredProcedure("FNORIGENUPD", OperacionPsql.class);
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(1, "v_ORIGENID", idOrigen, Integer.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(2, "v_DESCORIGEN", descripcionOrigen, String.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(3, "v_CLAVEORIGEN", claveOrigen, String.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(4, "v_STATUSID", idStatus, Integer.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(5, "v_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(actualizarOrigenFuncion);

        return data.size() > 0 && data.get(0).estatus == 1;

    }

}
