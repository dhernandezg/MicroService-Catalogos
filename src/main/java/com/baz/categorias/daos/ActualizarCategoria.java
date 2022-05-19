package com.baz.categorias.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarCategoria</b>
 * @descripcion: Método ActualizarCategoriaDAO para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 09/05/2022
 */

@ApplicationScoped
public class ActualizarCategoria {

    @Inject
    BaseDeDatosService baseDeDatosService;

    public boolean actualizarCategoria(Integer idCategoria,
                                       String descripcionCategoria,
                                       Integer idStatus,
                                       String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCATEGOUPD", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", idCategoria, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuarioNombre, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "PA_FCDESCCATEG", descripcionCategoria, String.class));
        storedProcedure.addParameters(new ProceduredParameter(4, "PA_FISTATUSID", idStatus, Integer.class));


        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;

    }
}
