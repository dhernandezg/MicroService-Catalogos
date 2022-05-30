package com.baz.elementostraduccion.daos;

import javax.enterprise.context.ApplicationScoped;

import com.baz.elementostraduccion.models.ElementosTraduccionModel;
import com.baz.utils.*;

import java.util.List;

/**
 * <b>ConsultarElementoTraduccionDAO</b>
 * @descripcion: Clase principal para consultar elemento traducción para acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 27/05/2022
 */

@ApplicationScoped
public class ConsultarElementoTraduccionDAO {

    /**
     * Inyección de dependencia para acceso a DB
     */
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>consultarElementosTraduccion</b>
     * @descripcion: Método para consultar elementos traduccion
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoría del catálogo a consultar
     * @param idCatalogo Identificador del catálogo a consultar
     * @param idElementoTrad Identificador del elemento traducción a consultar
     * @ultimaModificacion: 30/05/2022
     */

    public List<ElementosTraduccionModel> consultarElementosTraduccion(
            Integer idCategoria,
            Integer idCatalogo,
            Integer idElementoTrad){

        StoredProcedure consultaTraduccion = new StoredProcedure("SC_CATREM.FNELEMTRADSEL", ElementosTraduccionModel.class);
        consultaTraduccion.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", idCategoria , Integer.class));
        consultaTraduccion.addParameters(new ProceduredParameter(1, "PA_FICATALOGOID", idCatalogo, Integer.class));
        consultaTraduccion.addParameters(new ProceduredParameter(1, "PA_FIELEMTRADID", idElementoTrad, Integer.class));

        return baseDeDatosService.obtenerElementos(consultaTraduccion);
    }
}
