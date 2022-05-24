package com.baz.elementosbase.daos;

import com.baz.elementosbase.models.ActualizarElementoBaseModel;
import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * <b>ActualizarElementosBaseDao</b>
 * @descripcion: CLase para actualizar elementos base de acceso a DB
 * @autor: Diego Vázauez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@ApplicationScoped
public class ActualizarElementosBaseDao {

    /**
     * Inyección de dependencia para acceso a DB
     */
    @Inject
    BaseDeDatosService baseDeDatosService;

    public boolean actualizarElementoBase(
            ActualizarElementoBaseModel actualizarElementoBaseModel
            ){

        StoredProcedure actualizarElemento = new StoredProcedure("SC_CATREM.FNCATELEBASEUPD", OperacionPsql.class);
        actualizarElemento.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", actualizarElementoBaseModel.getIdCategoria(), Integer.class));
        actualizarElemento.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", actualizarElementoBaseModel.getIdCatalogo(), Integer.class));
        actualizarElemento.addParameters(new ProceduredParameter(3, "PA_FIELEMBASEID", actualizarElementoBaseModel.getIdElementoBase(), Integer.class));
        actualizarElemento.addParameters(new ProceduredParameter(4, "PA_USUARIO", actualizarElementoBaseModel.getNombreUsuario(), String.class));
        actualizarElemento.addParameters(new ProceduredParameter(5, "PA_FCVALOR", actualizarElementoBaseModel.getValor(), String.class));
        actualizarElemento.addParameters(new ProceduredParameter(6, "PA_FICAMPOID", actualizarElementoBaseModel.getIdCampo(), Short.class));
        actualizarElemento.addParameters(new ProceduredParameter(7, "PA_FIORDEN", actualizarElementoBaseModel.getOrden(), Short.class));
        actualizarElemento.addParameters(new ProceduredParameter(8, "PA_FISTATUSID", actualizarElementoBaseModel.getIdEstatus(), Short.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(actualizarElemento);

        return !data.isEmpty() && data.get(0).estatus == 1;

    }
}
