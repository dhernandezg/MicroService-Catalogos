package com.baz.elementostraduccion.daos;

import com.baz.elementostraduccion.models.ElementosTraduccionModel;
import com.baz.elementostraduccion.models.EliminarElementoTraduccionModel;
import com.baz.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
     * <b>EliminarElementoTraduccionDAO</b>
     * @descripcion: Clase principal para eliminar elemento traduccion de acceso a DB
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 30/05/2022
     */

@ApplicationScoped
public class EliminarElementoTraduccionDAO {

    /**
     * Inyección de dependencia para acceso a DB
     */
    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
         * <b>eliminarElementoTrad</b>
         * @descripcion: Método para eliminar elemento traduccion
         * @autor: Diego Vázquez Pérez
         * @param elimina Modelo de datos requeridos para eliminar un elemento traduccion
         * @ultimaModificacion: 30/05/2022
         */

    public boolean eliminarElementoTrad(
            EliminarElementoTraduccionModel elimina){

        StoredProcedure eliminarElemento = new StoredProcedure("SC_CATREM.FNCATELETRADDEL", OperacionPsql.class);
        eliminarElemento.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", elimina.getIdCategoria(), Integer.class));
        eliminarElemento.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", elimina.getIdCatalogo(), Integer.class));
        eliminarElemento.addParameters(new ProceduredParameter(3, "PA_FIELEMTRADID", elimina.getIdElementoTrad(), Integer.class));
        eliminarElemento.addParameters(new ProceduredParameter(4, "PA_USUARIO", elimina.getUsuario(), String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(eliminarElemento);

        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
