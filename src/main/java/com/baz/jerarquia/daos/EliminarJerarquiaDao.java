package com.baz.jerarquia.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>EliminarJerarquiaDao</b>
 * @descripcion: Clase que contiene los  métodos de eliminación para las jerarquia
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class EliminarJerarquiaDao {
    /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Elimina la jerarquia especificado
     * @param idCategoria Identificador de categoría
     * @param idCatalogo Identificador de catalogo
     * @param idCatalogoHijo Identificador del catalogo hijo
     * @param usuario Usuario que elimina
     * @return boolean True si se elimino correctamente
     */
    public boolean eliminarJerarquia(Integer idCategoria, Integer idCatalogo,Integer idCatalogoHijo, String usuario) {
        StoredProcedure fnEliminaJerarquia = new StoredProcedure("SC_CATREM.FNJERARQUIADEL", OperacionPsql.class);
        fnEliminaJerarquia.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", idCategoria, Integer.class));
        fnEliminaJerarquia.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", idCatalogo, Integer.class));
        fnEliminaJerarquia.addParameters(new ProceduredParameter(3, "PA_FICATJERARQID", idCatalogoHijo, Integer.class));
        fnEliminaJerarquia.addParameters(new ProceduredParameter(4, "PA_USUARIO", usuario, String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnEliminaJerarquia);
        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
