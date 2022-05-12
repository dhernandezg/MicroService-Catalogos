package com.baz.origen.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.origen.models.OrigenModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarOrigen</b>
 * @descripcion: Clase de acceso a DB para actualizar origen.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 12/05/2022
 */

@ApplicationScoped
public class ActualizarOrigen {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>actualizarOrigen</b>
     * @descripcion: Método para actualizar origen en DB
     * @autor: Diego Vázquez Pérez
     * @param origenModel Entrada como modelo de datos origen, se omite fecha de moficiacion.
     * @ultimaModificacion: 12/05/2022
     */

    public boolean actualizarOrigen(
            OrigenModel origenModel){

        StoredProcedure actualizarOrigenFuncion = new StoredProcedure("FNORIGENUPD", OperacionPsql.class);
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(1, "v_ORIGENID", origenModel.getIdOrigen(), Integer.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(2, "v_DESCORIGEN", origenModel.getDescripcionOrigen(), String.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(3, "v_CLAVEORIGEN", origenModel.getClaveOrigen(), String.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(4, "v_STATUSID", origenModel.getIdStatus(), Integer.class));
        actualizarOrigenFuncion.addParameters(new ProceduredParameter(5, "v_USUARIO", origenModel.getUsuarioNombre(), String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(actualizarOrigenFuncion);

        return data.size() > 0 && data.get(0).estatus == 1;

    }

}
