package com.baz.categorias.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarCategoriaDao</b>
 * @descripcion: Método ActualizarCategoriaDAO para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 09/05/2022
 */

@ApplicationScoped
public class ActualizarCategoriaDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    public boolean actualizarCategoria(Integer idCategoria,
                                       String descripcionCategoria,
                                       Integer idStatus,
                                       String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("FNCATEGORIAUPD", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", idCategoria, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_DESCCATEG", descripcionCategoria, String.class));
        storedProcedure.addParameters(new ProceduredParameter(3, "v_STATUSID", idStatus, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(4, "v_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;

    }
}
