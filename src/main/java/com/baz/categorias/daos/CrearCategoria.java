package com.baz.categorias.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>CrearCategoria</b>
 * @descripcion: Clase DAO para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 09/05/2022
 */

@ApplicationScoped
public class CrearCategoria {

    @Inject
    BaseDeDatosService baseDeDatosService;


    /**
     * <b>crearCategoria</b>
     * @descripcion: Método que permite crear una categoría.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 18/05/2022
     */

    public boolean crearCategoria(
            String descripcionCategoria,
            String usuarioNombre) {

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCATEGOINS", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FCDESCCATEG", descripcionCategoria, String.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;

    }
}
