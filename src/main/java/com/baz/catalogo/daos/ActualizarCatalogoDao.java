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
    public boolean actualizarCatalogo(Catalogo datosCatalogo) {
        StoredProcedure fnActualizaCatalogo = new StoredProcedure("FNCATALOGOUPD", OperacionPsql.class);
        fnActualizaCatalogo.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", datosCatalogo.getIdCategoria(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(2, "v_CATALOGOID", datosCatalogo.getIdCatalogo(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(3, "v_TIPOCATID", datosCatalogo.getIdTipoCatalogo(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(4, "v_DESCCATALOGO", datosCatalogo.getNombreCatalogo(), String.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(5, "v_CATALOBASEID", datosCatalogo.getIdCatalogoBase(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(6, "v_STATUSID", datosCatalogo.getIdEstatus(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(7, "v_USUARIO", datosCatalogo.getUsuarioModificacion(), String.class));
        List<OperacionPsql> resultado = accesoDatos.<OperacionPsql>obtenerElementos(fnActualizaCatalogo);
        return !resultado.isEmpty() && resultado.get(0).estatus == 1;
    }
}
