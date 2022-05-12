package com.baz.origen.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.origen.models.OrigenModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.inject.Inject;

/**
 * <b>${nombreClase}</b>
 * @descripcion: breve descripción del contenido
 * @autor: ${user}, Desarrollador
 * @param String Descripcion
 * @ultimaModificacion: ${date}
 */

public class DaoActualizarOrigen {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>${nombreClase}</b>
     * @descripcion: breve descripción del contenido
     * @autor: ${user}, Desarrollador
     * @param String Descripcion
     * @ultimaModificacion: ${date}
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
