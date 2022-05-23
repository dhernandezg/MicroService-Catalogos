package com.baz.catalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.Catalogo;
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
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Registra el catalogo especificado
     * @param datosCatalogo Catalogo a registrar
     * @return boolean True si el registro fue exitoso
     */
    public boolean agregarCatalogo( Catalogo datosCatalogo) {
        StoredProcedure fnInsertaCatalogo = new StoredProcedure("FNCATALOGOINS", OperacionPsql.class);
        fnInsertaCatalogo.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", datosCatalogo.getIdCategoria(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(2, "v_TIPOCATID", datosCatalogo.getIdTipoCatalogo(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(3, "v_DESCCATALOGO", datosCatalogo.getDescripcionCatalogo(), String.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(4, "v_CATALOBASEID", datosCatalogo.getIdCatalogoBase(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(5, "v_USUARIO", datosCatalogo.getUsuarioPropietario(), String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnInsertaCatalogo);
        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
