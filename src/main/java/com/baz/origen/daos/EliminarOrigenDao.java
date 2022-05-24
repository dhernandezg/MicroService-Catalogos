package com.baz.origen.daos;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>EliminarOrigenDao</b>
 * @descripcion: Clase eliminar origen para acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 12/05/2022
 */

@ApplicationScoped
public class EliminarOrigenDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>eliminarOrigen</b>
     * @descripcion: Método para eliminar origen en DB
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 12/05/2022
     */

    public boolean eliminarOrigen(
            Short idOrigen,
            String usuarioNombre){

        StoredProcedure eliminar = new StoredProcedure("SC_CATREM.FNORIGENDEL", OperacionPsql.class);
        eliminar.addParameters(new ProceduredParameter(1, "PA_FIORIGENID", idOrigen, Short.class));
        eliminar.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(eliminar);

        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
