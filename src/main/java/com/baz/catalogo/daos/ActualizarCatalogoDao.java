package com.baz.catalogo.daos;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.*;
import com.baz.models.OperacionPsql;
import com.baz.utils.*;

/**
 * <b>ActualizarCatalogo</b>
 * @descripcion: Clase que contiene los métodos de actualización de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class ActualizarCatalogoDao {
    /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Actualiza los datos de un catalogo
     * @param datosCatalogo - Datos a actualizar del catalogo
     * @return boolean True si la actualización fue exitosa
     */
    public boolean actualizarCatalogo(DatosActualizacion datosCatalogo) {
        StoredProcedure fnActualizaCatalogo = new StoredProcedure("SC_CATREM.FNCATALOGOUPD", OperacionPsql.class);
        fnActualizaCatalogo.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", datosCatalogo.getIdCategoria(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", datosCatalogo.getIdCatalogo(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(3, "PA_USUARIO", datosCatalogo.getUsuario(), String.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(4, "PA_FITIPOCATID", datosCatalogo.getIdTipoCatalogo(), Short.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(5, "PA_FCDESCCATALOGO", datosCatalogo.getNombreCatalogo(), String.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(6, "PA_FICATALOBASEID", datosCatalogo.getIdCatalogoBase(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(7, "PA_FISTATUSID", datosCatalogo.getIdEstatus(), Short.class));
        
        List<OperacionPsql> resultado = accesoDatos.<OperacionPsql>obtenerElementos(fnActualizaCatalogo);
        return !resultado.isEmpty() && resultado.get(0).estatus == 1;
    }
}
