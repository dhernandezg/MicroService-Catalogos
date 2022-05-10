package com.baz.campos.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarCampoDao</b>
 * @descripcion: Método Actualizar Campo para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@ApplicationScoped
public class ActualizarCampoDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>actualizarCampo</b>
     * @descripcion: Método para actualizar campo.
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo.
     * @param descripcionCampo Descripción del campo.
     * @param idStatus Identificador del status.
     * @param usuarioNombre Nombre del usuario.
     * @ultimaModificacion: 10/05/2022
     */

    public boolean actualizarCampo(Integer idCampo,
                                   String descripcionCampo,
                                   Integer idStatus,
                                   String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("FNCAMPOUPD", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_CAMPOID", idCampo, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_DESCCAMPO", descripcionCampo, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "v_STATUSID", idStatus, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(4, "v_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
