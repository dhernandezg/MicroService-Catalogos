package com.baz.origen.daos;

import com.baz.origen.models.OrigenModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * <b>ConsultarOrigen</b>
 * @descripcion: Clase consultar origen para acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@ApplicationScoped
public class ConsultarOrigen {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>consultarOrigen</b>
     * @descripcion: Método para consultar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen
     * @param descripcionOrigen Descripcion del tipo de catálogo
     * @param claveOrigen Clave del origen
     * @ultimaModificacion: 10/05/2022
     */

    public List<OrigenModel> consultarOrigen(
            Integer idOrigen,
            String descripcionOrigen,
            String claveOrigen){

        StoredProcedure storedProcedure = new StoredProcedure("FNORIGENSEL", OrigenModel.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_ORIGENID", idOrigen, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_DESCORIGEN", descripcionOrigen, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "v_CLAVEORIGEN", claveOrigen, String.class));

        return baseDeDatosService.<OrigenModel>obtenerElementos(storedProcedure);

    }
}
