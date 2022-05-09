package com.baz.catalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.Catalogo;
import com.baz.catalogo.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

@Model
public class RegistrarCatalogo {
    @Inject
    BaseDeDatosService accesoDatos;

    
    public boolean agregarCatalogo( Catalogo datosCatalogo) {
        StoredProcedure fnInsertaCatalogo = new StoredProcedure("FNCATALOGOINS", OperacionPsql.class);
        fnInsertaCatalogo.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", datosCatalogo.getIdCategoria(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(2, "v_TIPOCATID", datosCatalogo.getIdTipoCatalogo(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(3, "v_DESCCATALOGO", datosCatalogo.getDescripcionCatalogo(), String.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(4, "v_CATALOBASEID", datosCatalogo.getIdCatalogoBase(), Integer.class));
        fnInsertaCatalogo.addParameters(new ProceduredParameter(5, "v_USUARIO", datosCatalogo.getUsuarioPropietario(), String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnInsertaCatalogo);
        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
