package com.baz.estatus.daos;

import com.baz.estatus.models.EstatusModel;
import com.baz.utils.BaseDeDatosService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

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

        StoredProcedure consultaEstatus = new StoredProcedure("SC_CATREM.FNSTATUSSEL", EstatusModel.class);
        consultaEstatus.addParameters(new ProceduredParameter(1, "PA_FISTATUSID", idEstatus, Short.class));
        consultaEstatus.addParameters(new ProceduredParameter(2, "PA_FCDESCSTATUS", descripcionEstatus, String.class));

        return baseDeDatosService.obtenerElementos(consultaEstatus);
    }
}
