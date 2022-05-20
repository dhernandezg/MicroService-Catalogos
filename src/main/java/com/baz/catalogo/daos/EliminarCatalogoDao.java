package com.baz.catalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>EliminarCatalogo</b>
 * @descripcion: Clase que contiene los  métodos de eliminación para catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class EliminarCatalogoDao {
     /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Elimina el catalogo especificado
     * @param idCategoria Identificador de categoría
     * @param idCatalogo Identificador de catalogo
     * @param usuario Usuario que elimina
     * @return boolean True si se elimino correctamente
     */
    public boolean eliminarCatalogo(Integer idCategoria, Integer idCatalogo, String usuario) {
        StoredProcedure fnEliminaCatalogo = new StoredProcedure("SC_CATREM.FNCATALOGODEL", OperacionPsql.class);
        fnEliminaCatalogo.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", idCategoria, Integer.class));
        fnEliminaCatalogo.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", idCatalogo, Integer.class));
        fnEliminaCatalogo.addParameters(new ProceduredParameter(3, "PA_USUARIO", usuario, String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnEliminaCatalogo);
        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
