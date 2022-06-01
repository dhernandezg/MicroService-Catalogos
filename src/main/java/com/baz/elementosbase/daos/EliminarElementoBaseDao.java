package com.baz.elementosbase.daos;

import com.baz.elementosbase.models.EliminarElementoBaseModel;
import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>EliminarElementoBaseDao</b>
 * @descripcion: Clase para eliminar elemento ase de un catálogo
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@ApplicationScoped
public class EliminarElementoBaseDao {

    /**
     *
     */
    @Inject
    BaseDeDatosService baseDeDatosService;

    public boolean eliminarElementoBase(
            EliminarElementoBaseModel elemento){

        StoredProcedure eliminarElemento = new StoredProcedure("SC_CATREM.FNCATELEBASEDEL", OperacionPsql.class);
        eliminarElemento.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", elemento.getIdCategoria(), Integer.class));
        eliminarElemento.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", elemento.getIdCatalogo(), Integer.class));
        eliminarElemento.addParameters(new ProceduredParameter(3, "PA_FIELEMBASEID", elemento.getIdElementoBase(), Integer.class));
        eliminarElemento.addParameters(new ProceduredParameter(4, "PA_USUARIO", elemento.getUsuario(), String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(eliminarElemento);

        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
