package com.baz.tipocatalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.tipocatalogo.models.DatosAlta;
import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>RegistrarTipoCatalogoDao</b>
 * @descripcion: Clase que contiene los métodos de inserción para el tipo de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class RegistrarTipoCatalogoDao {
    /**
     * Objeto de acceso a base de datos
     */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Registra el tipo de catalogo especificado
     * @param datosAlta Catalogo a registrar
     * @return boolean True si el registro fue exitoso
     */
    public boolean agregarTipoCatalogo(DatosAlta datosAlta) {
        StoredProcedure fnInsertaTipoCatalogo = new StoredProcedure("SC_CATREM.FNTIPOCATALINS", OperacionPsql.class);
        fnInsertaTipoCatalogo.addParameters(new ProceduredParameter(3, "PA_FCDESCTIPOCAT", datosAlta.getTipoCatalogo(), String.class));
        fnInsertaTipoCatalogo.addParameters(new ProceduredParameter(5, "PA_USUARIO", datosAlta.getUsuario(), String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnInsertaTipoCatalogo);
        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
