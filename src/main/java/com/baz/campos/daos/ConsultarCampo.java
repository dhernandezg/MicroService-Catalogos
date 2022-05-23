package com.baz.campos.daos;

import com.baz.campos.models.CamposModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * <b>ConsultarCampo</b>
 * @descripcion: Método consultarCampoDao para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@ApplicationScoped
public class ConsultarCampo {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>consultarCampos</b>
     * @descripcion: Método consultar campos.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 19/05/2022
     */

    public List<CamposModel> consultarCampos(Integer idCampo,
                                             String descripcionCampo){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCAMPOSEL", CamposModel.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FICAMPOID", idCampo, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_FCCAMPO", descripcionCampo, String.class));

        return baseDeDatosService.obtenerElementos(storedProcedure);

    }
}
