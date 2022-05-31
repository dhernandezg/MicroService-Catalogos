package com.baz.origen.daos;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarOrigenDao</b>
 * @descripcion: Clase de acceso a DB para actualizar origen.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 12/05/2022
 */

@ApplicationScoped
public class ActualizarOrigenDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>actualizarOrigen</b>
     * @descripcion: Método para actualizar origen en DB
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen a actualizar
     * @param descripcionOrigen Nueva descripción del origen
     * @param claveOrigen Nueva clave del origen
     * @param idEstatus Nuevo status del origen
     * @param usuarioNombre Nombre del usuario que actualiza
     * @ultimaModificacion: 16/05/2022
     */

    public boolean actualizarOrigen(
            Short idOrigen,
            String descripcionOrigen,
            String claveOrigen,
            Short idEstatus,
            String usuarioNombre){

        StoredProcedure actualizarOrigenFuncion = new StoredProcedure("SC_CATREM.FNORIGENUPD", OperacionPsql.class);
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(1, "PA_FIORIGENID", idOrigen, Short.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuarioNombre, String.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(3, "PA_FCDESCORIGEN", descripcionOrigen, String.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(4, "PA_FCCLAVEORIGEN", claveOrigen, String.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(5, "PA_FIESTATUSID", idEstatus, Short.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(actualizarOrigenFuncion);

        return data.size() > 0 && data.get(0).estatus == 1;

    }

}
