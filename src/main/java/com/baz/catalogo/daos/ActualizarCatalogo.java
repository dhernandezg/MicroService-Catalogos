package com.baz.catalogo.daos;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.Catalogo;
import com.baz.catalogo.models.OperacionPsql;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;


@Model
public class ActualizarCatalogo {
    @Inject
    BaseDeDatosService accesoDatos;
    
    public boolean actualizarCatalogo(Catalogo datosCatalogo) {
        StoredProcedure fnActualizaCatalogo = new StoredProcedure("FNCATALOGOUPD", OperacionPsql.class);
        fnActualizaCatalogo.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", datosCatalogo.getIdCategoria(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(2, "v_CATALOGOID", datosCatalogo.getIdCatalogo(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(3, "v_TIPOCATID", datosCatalogo.getIdTipoCatalogo(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(4, "v_DESCCATALOGO", datosCatalogo.getDescripcionCatalogo(), String.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(5, "v_CATALOBASEID", datosCatalogo.getIdCatalogoBase(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(6, "v_STATUSID", datosCatalogo.getIdEstatus(), Integer.class));
        fnActualizaCatalogo.addParameters(new ProceduredParameter(7, "v_USUARIO", datosCatalogo.getUsuarioPropietario(), String.class));
        var data = accesoDatos.<OperacionPsql>obtenerElementos(fnActualizaCatalogo);
        return data.size() > 0 && data.get(0).estatus == 1;
    }
}
