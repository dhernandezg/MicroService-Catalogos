package com.baz.elementosbase.daos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.baz.elementosbase.models.CrearElementoBaseModel;
import com.baz.models.OperacionPsql;
import com.baz.utils.*;

/**
 * <b>CrearElementoBaseDao</b>
 * @descripcion: Clase crear elemento base de acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@ApplicationScoped
public class CrearElementoBaseDao {

    /**
     * Inyección de dependencia para acceso a DB
     */

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>crearElementoBase</b>
     * @descripcion: Método para crear elemento base
     * @autor: Diego Vázquez Pérez
     * @param elemento Datos requeridos para crear un elemento base
     * @ultimaModificacion: 24/05/2022
     */

    public boolean crearElementoBase(
            CrearElementoBaseModel elemento
            ){

        StoredProcedure crearElemento = new StoredProcedure("SC_CATREM.FNCATELEBASEINS", OperacionPsql.class);

        crearElemento.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", elemento.getIdCategoria(), Integer.class));
        crearElemento.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", elemento.getIdCatalogo(), Integer.class));
        crearElemento.addParameters(new ProceduredParameter(3, "PA_FCVALOR", elemento.getValor(), String.class));
        crearElemento.addParameters(new ProceduredParameter(4, "PA_FICAMPOID", elemento.getIdCampo(), Short.class));
        crearElemento.addParameters(new ProceduredParameter(5, "PA_FIORDEN", elemento.getOrden(), Short.class));
        crearElemento.addParameters(new ProceduredParameter(6, "PA_USUARIO", elemento.getUsuario(), String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(crearElemento);

        return !data.isEmpty() && data.get(0).estatus == 1;
    }

}
