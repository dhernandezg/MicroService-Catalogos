package com.baz.campos.daos;

import com.baz.campos.models.CamposModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * <b>ConsultarCampoDao</b>
 * @descripcion: Método consultarCampoDao para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@ApplicationScoped
public class ConsultarCampoDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>consultarCampos</b>
     * @descripcion: Método consultar campos.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 10/05/2022
     */

    public List<CamposModel> consultarCampos(Integer idCampo,
                                             String descripcionCampo){

        StoredProcedure storedProcedure = new StoredProcedure("FNCAMPOSEL", CamposModel.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_CAMPOID", idCampo, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_DESCCAMPO", descripcionCampo, String.class));

        return baseDeDatosService.obtenerElementos(storedProcedure);

    }
}
