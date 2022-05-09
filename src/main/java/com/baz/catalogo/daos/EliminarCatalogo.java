package com.baz.catalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

@Model
public class EliminarCatalogo {
    @Inject
    BaseDeDatosService accesoDatos;
    
    
    public boolean eliminarCatalogo(Integer idCategoria, Integer idCatalogo, String usuario) {
        StoredProcedure fnEliminaCatalogo = new StoredProcedure("FNCATALOGODEL", OperacionPsql.class);
        fnEliminaCatalogo.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", idCategoria, Integer.class));
        fnEliminaCatalogo.addParameters(new ProceduredParameter(2, "v_CATALOGOID", idCatalogo, Integer.class));
        fnEliminaCatalogo.addParameters(new ProceduredParameter(3, "v_USUARIO", usuario, String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnEliminaCatalogo);
        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
