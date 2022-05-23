package com.baz.categorias.daos;

import com.baz.categorias.models.CategoriasModel;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * <b>ConsultarCategoriaDao</b>
 * @descripcion: Clase ConsultarCategoriaDao para acceso a DB.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 09/05/2022
 */

@ApplicationScoped
public class ConsultarCategoriaDao {

    @Inject
    BaseDeDatosService baseDeDatosService;

    public List<CategoriasModel> consultarCategoria(
            Integer idCategoria,
            String descripcionCategoria){

        StoredProcedure storedProcedure = new StoredProcedure("SC_CATREM.FNCATEGOSEL", CategoriasModel.class);
        storedProcedure.addParameters(new ProceduredParameter(1,"PA_FICATEGORIAID", idCategoria, Integer.class));
        storedProcedure.addParameters(new ProceduredParameter(2,"PA_FCDESCCATEG", descripcionCategoria, String.class));

        return baseDeDatosService.obtenerElementos(storedProcedure);
    }
}
