package com.baz.tipocatalogo.daos;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.tipocatalogo.models.*;
import com.baz.models.OperacionPsql;
import com.baz.utils.*;

/**
 * <b>ActualizarTipoCatalogoDao</b>
 * @descripcion: Clase que contiene los métodos de actualización de tipos de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class ActualizarTipoCatalogoDao {
    /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Actualiza los datos de un tipo de catalogo
     * @param datosCatalogo - Datos a actualizar del tipo de catalogo
     * @return boolean True si la actualización fue exitosa
     */
    public boolean actualizarTipoCatalogo(DatosActualizacion datosCatalogo) {
        StoredProcedure fnActualizaTipoCatalogo = new StoredProcedure("SC_CATREM.FNTIPOCATALUPD", OperacionPsql.class);
        fnActualizaTipoCatalogo.addParameters(new ProceduredParameter(1, "PA_FITIPOCATID", datosCatalogo.getIdTipoCatalogo(), Short.class));
        fnActualizaTipoCatalogo.addParameters(new ProceduredParameter(2, "PA_USUARIO", datosCatalogo.getUsuario(), String.class));
        fnActualizaTipoCatalogo.addParameters(new ProceduredParameter(4, "PA_FCDESCTIPOCAT", datosCatalogo.getTipoCatalogo(), String.class));
        fnActualizaTipoCatalogo.addParameters(new ProceduredParameter(5, "PA_FISTATUSID", datosCatalogo.getIdEstatus(), Short.class));
        List<OperacionPsql> resultado = accesoDatos.<OperacionPsql>obtenerElementos(fnActualizaTipoCatalogo);
        return !resultado.isEmpty() && resultado.get(0).estatus == 1;
    }
}
