package com.baz.elementosbase.daos;

import com.baz.elementosbase.models.ElementosBaseModel;
import com.baz.utils.*;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * <b>ConsultarElementosBaseDao</b>
 * @descripcion: Clase consultar elementos base de acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@ApplicationScoped
public class ConsultarElementosBaseDao {

    /**
     * Inyección de dependencia para acceso a DB
     */
    @Inject
    BaseDeDatosService baseDeDatosService;

    public List<ElementosBaseModel> consultarElementosBase(
            Integer idCategoria,
            Integer idCatalogo,
            Integer idElementoBase
    ){

        StoredProcedure consultarElementos = new StoredProcedure("SC_CATREM.FNELEMBASESEL", ElementosBaseModel.class);
        consultarElementos.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", idCategoria, Integer.class));
        consultarElementos.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", idCatalogo, Integer.class));
        consultarElementos.addParameters(new ProceduredParameter(3, "PA_FIELEMBASEID", idElementoBase, Integer.class));

        return baseDeDatosService.obtenerElementos(consultarElementos);
    }

}
