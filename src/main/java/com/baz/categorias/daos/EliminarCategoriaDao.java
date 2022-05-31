package com.baz.categorias.daos;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>EliminarCategoriaDao</b>
 * @descripcion: Método ELiminar Categorías DAO para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 19/05/2022
 */

@ApplicationScoped
public class EliminarCategoriaDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>$eliminarCategoria</b>
     * @descripcion: Método que permite eliminar una categoría mediante parámetros.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoría.
     * @param usuarioNombre Nombre del usuario.
     * @ultimaModificacion: 19/05/2022
     */

    public boolean eliminarCategoria(Integer idCategoria,
                                     String usuarioNombre){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCATEGORIADEL", OperacionPsql.class);
        storedProcedure.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", idCategoria, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuarioNombre, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(storedProcedure);

        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
