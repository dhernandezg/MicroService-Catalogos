package com.baz.campos.daos;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarCampoDao</b>
 * @descripcion: Método Actualizar Campo para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 23/05/2022
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
     * @param idEstatus Identificador del status.
     * @param usuarioNombre Nombre del usuario.
     * @ultimaModificacion: 23/05/2022
     */

    public boolean actualizarCampo(Short idCampo,
                                   String usuarioNombre,
                                   String nombreCampo,
                                   String descripcionCampo,
                                   Short idEstatus){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCAMPOUPD", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FICAMPOID", idCampo, Short.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuarioNombre, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "PA_FCCAMPO", nombreCampo, String.class));
        storedProcedure.addParameters(new ProceduredParameter(4, "PA_FCDESCCAMPO", descripcionCampo, String.class));
        storedProcedure.addParameters(new ProceduredParameter(5, "PA_FIESTATUSID", idEstatus, Short.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
