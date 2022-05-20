package com.baz.catalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.DatosAlta;
import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>RegistrarCatalogo</b>
 * @descripcion: Clase que contiene los métodos de inserción para catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class RegistrarCatalogoDao {
    /**
     * Objeto de acceso a base de datos
     */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Registra el catalogo especificado
     * @param datosAlta Catalogo a registrar
     * @return boolean True si el registro fue exitoso
     */
    public boolean agregarCatalogo(DatosAlta datosAlta) {
        StoredProcedure fnInsertaCatalogo = new StoredProcedure("SC_CATREM.FNCATALOGOINS", OperacionPsql.class);
        fnInsertaCatalogo.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", datosAlta.getIdCategoria(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(2, "PA_FITIPOCATID", datosAlta.getIdTipoCatalogo(), Short.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(3, "PA_FCDESCTIPOCAT", datosAlta.getNombreCatalogo(), String.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(4, "PA_FICATALOBASEID", datosAlta.getIdCatalogoBase(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(5, "PA_USUARIO", datosAlta.getUsuario(), String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnInsertaCatalogo);
        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
