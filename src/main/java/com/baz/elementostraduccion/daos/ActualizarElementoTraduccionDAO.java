package com.baz.elementostraduccion.daos;


import com.baz.elementostraduccion.models.ActualizarElementoTraduccionModel;
import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
     * <b>ActualizarElementoTraduccionDAO</b>
     * @descripcion: Clase principal para actualizar elementos traduccion de acceso a DB
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 30/05/2022
     */

@ApplicationScoped
public class ActualizarElementoTraduccionDAO {

    /**
     * Inyección de dependencia para acceso a DB
     */
    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
         * <b>actualizarElementoTrad</b>
         * @descripcion: Método para actualizar elementos traduccion
         * @autor: Diego Vázquez Pérez
         * @param actualiza Modelo de datos requeridos para actualizar un elemento traduccion
         * @ultimaModificacion: 30/05/2022
     */

    public boolean actualizarElementoTrad(
            ActualizarElementoTraduccionModel actualiza){

        StoredProcedure actualizaSp = new StoredProcedure("SC_CATREM.FNCATELETRADUPD", OperacionPsql.class);
        actualizaSp.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", actualiza.getIdCategoria(), Integer.class));
        actualizaSp.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", actualiza.getIdCatalogo(), Integer.class));
        actualizaSp.addParameters(new ProceduredParameter(3, "PA_FIELEMTRADID", actualiza.getIdElementoTrad(), Integer.class));
        actualizaSp.addParameters(new ProceduredParameter(4, "PA_USUARIO", actualiza.getUsuario(), String.class));
        actualizaSp.addParameters(new ProceduredParameter(5, "PA_FCVALOR", actualiza.getValor(), String.class));
        actualizaSp.addParameters(new ProceduredParameter(6, "PA_FICAMPOID", actualiza.getIdCampo(), Short.class));
        actualizaSp.addParameters(new ProceduredParameter(7, "PA_FIORDEN", actualiza.getOrden(), Short.class));
        actualizaSp.addParameters(new ProceduredParameter(8, "PA_FCVALORBASE", actualiza.getValorBase(), String.class));
        actualizaSp.addParameters(new ProceduredParameter(9, "PA_FIESTATUSID", actualiza.getIdEstatus(), Short.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(actualizaSp);

        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
