package com.baz.origen.daos;

import com.baz.origen.models.OrigenModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * <b>ConsultarOrigenDao</b>
 * @descripcion: Clase consultar origen para acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 23/05/2022
 */

@ApplicationScoped
public class ConsultarOrigenDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>consultarOrigen</b>
     * @descripcion: Método para consultar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen
     * @param claveOrigen Clave del origen
     * @ultimaModificacion: 23/05/2022
     */

    public List<OrigenModel> consultarOrigen(
            Short idOrigen,
            String claveOrigen){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNORIGENSEL", OrigenModel.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FIORIGENID", idOrigen, Short.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_FCCLAVEORIGEN", claveOrigen, String.class));

        return baseDeDatosService.<OrigenModel>obtenerElementos(storedProcedure);

    }
}
