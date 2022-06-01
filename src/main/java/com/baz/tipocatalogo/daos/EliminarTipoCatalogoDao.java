package com.baz.tipocatalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>EliminarTipoCatalogoDao</b>
 * @descripcion: Clase que contiene los métodos de eliminación para el tipo de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class EliminarTipoCatalogoDao {
     /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Elimina el tipo del catalogo especificado
     * @param idTipoCatalogo Identificador del tipo del catalogo
     * @param usuario Usuario que elimina
     * @return boolean True si se elimino correctamente
     */
    public boolean eliminarTipoCatalogo(Integer idTipoCatalogo, String usuario) {
        StoredProcedure fnEliminaTipoCatalogo = new StoredProcedure("SC_CATREM.FNTIPOCATALDEL", OperacionPsql.class);
        fnEliminaTipoCatalogo.addParameters(new ProceduredParameter(1, "PA_FITIPOCATID", idTipoCatalogo, Integer.class));
        fnEliminaTipoCatalogo.addParameters(new ProceduredParameter(2, "PA_USUARIO", usuario, String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnEliminaTipoCatalogo);
        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
