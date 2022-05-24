package com.baz.elementosbase.daos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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
     * @param idCategoria Identificador de la categoría a la que pertenece el elemento
     * @param idCatalogo Identificador del catálogo al que pertenece el elemento
     * @param valor Descripción del elemento base
     * @param idCampo Identificador del campo que se está registrando
     * @param orden Orden en que se registra el elemento dentro del catálogo
     * @param nombreUsuario Nombre del usuario que realiza el registro
     * @ultimaModificacion: 24/05/2022
     */

    public boolean crearElementoBase(
            Integer idCategoria,
            Integer idCatalogo,
            String valor,
            Short idCampo,
            Short orden,
            String nombreUsuario){

        StoredProcedure crearElemento = new StoredProcedure("SC_CATREM.FNCATELEBASEINS", OperacionPsql.class);

        crearElemento.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", idCategoria, Integer.class));
        crearElemento.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", idCatalogo, Integer.class));
        crearElemento.addParameters(new ProceduredParameter(3, "PA_FCVALOR", valor, String.class));
        crearElemento.addParameters(new ProceduredParameter(4, "PA_FICAMPOID", idCampo, Short.class));
        crearElemento.addParameters(new ProceduredParameter(5, "PA_FIORDEN", orden, Short.class));
        crearElemento.addParameters(new ProceduredParameter(6, "PA_USUARIO", nombreUsuario, String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(crearElemento);

        return !data.isEmpty() && data.get(0).estatus == 1;
    }

}
