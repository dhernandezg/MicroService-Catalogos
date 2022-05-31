package com.baz.estatus.daos;

import com.baz.estatus.models.EstatusModel;
import com.baz.utils.BaseDeDatosService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>ConsultarEstatusDao</b>
 * @descripcion: Clase de acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@ApplicationScoped
public class ConsultarEstatusDao {

    /**
     * Inyección de dependencia para acceso a DB
     */
    @Inject
    BaseDeDatosService baseDeDatosService;

    public List<EstatusModel> consultarEstatus(
            Short idEstatus,
            String descripcionEstatus){

        StoredProcedure consultaEstatus = new StoredProcedure("SC_CATREM.FNESTATUSSEL", EstatusModel.class);
        consultaEstatus.addParameters(new ProceduredParameter(1, "PA_FIESTATUSID", idEstatus, Short.class));
        consultaEstatus.addParameters(new ProceduredParameter(2, "PA_FCDESCESTATUS", descripcionEstatus, String.class));

        return baseDeDatosService.obtenerElementos(consultaEstatus);
    }
}
