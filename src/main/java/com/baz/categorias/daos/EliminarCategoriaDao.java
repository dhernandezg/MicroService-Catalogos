package com.baz.categorias.daos;

import com.baz.categorias.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>EliminarCategoriaDao</b>
 * @descripcion: Método ELiminar Categorías DAO para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@ApplicationScoped
public class EliminarCategoriaDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>${nombreClase}</b>
     * @descripcion: Método que permite eliminar una categoría mediante parámetros.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoría.
     * @param descripcionCategoria Descripción de la categoría.
     * @ultimaModificacion: 10/05/2022
     */

    public boolean eliminarCategoria(Integer idCategoria,
                                     String descripcionCategoria){

        StoredProcedure storedProcedure = new StoredProcedure("FNCATEGORIADEL", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", idCategoria, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "v_USUARIO", descripcionCategoria, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;
    }
}