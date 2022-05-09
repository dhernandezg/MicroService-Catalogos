package com.baz.catalogo.daos;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.Catalogo;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

@Model
public class ConsultarCatalogo {
    @Inject
    BaseDeDatosService accesoDatos;
    
    public List<Catalogo> obtenerCatalogos(Catalogo datosCatalogo) {
        StoredProcedure fnConsultaCatalogo = new StoredProcedure("FNCATALOGOSEL", Catalogo.class);
        fnConsultaCatalogo.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", datosCatalogo.getIdCategoria(), Integer.class));
        fnConsultaCatalogo.addParameters(new ProceduredParameter(2, "v_CATALOGOID", datosCatalogo.getIdCatalogo(), Integer.class));
        fnConsultaCatalogo.addParameters(new ProceduredParameter(3, "v_TIPOCATID", datosCatalogo.getIdTipoCatalogo(), Integer.class));
        fnConsultaCatalogo.addParameters(new ProceduredParameter(4, "v_DESCCATALOGO", datosCatalogo.getDescripcionCatalogo(), String.class));
        return accesoDatos.<Catalogo>obtenerElementos(fnConsultaCatalogo);
    }
}
