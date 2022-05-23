package com.baz.catalogo.daos;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.models.Catalogo;
import com.baz.utils.*;

/**
 * <b>ConsultarCatalogo</b>
 * @descripcion: Clase que contiene los métodos de consulta para los catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class ConsultarCatalogoDao {
    /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Obtiene una lista de catálogos a partir de los parámetros proporcionados
     * @param datosCatalogo Datos de consulta
     * @return List<Catalogo> Lista de <b>Catálogos<b>
     */
    public List<Catalogo> obtenerCatalogos(Catalogo datosCatalogo) {
        StoredProcedure fnConsultaCatalogo = new StoredProcedure("FNCATALOGOSEL", Catalogo.class);
        fnConsultaCatalogo.addParameters(new ProceduredParameter(1, "v_CATEGORIAID", datosCatalogo.getIdCategoria(), Integer.class));
        fnConsultaCatalogo.addParameters(new ProceduredParameter(2, "v_CATALOGOID", datosCatalogo.getIdCatalogo(), Integer.class));
        fnConsultaCatalogo.addParameters(new ProceduredParameter(3, "v_TIPOCATID", datosCatalogo.getIdTipoCatalogo(), Integer.class));
        fnConsultaCatalogo.addParameters(new ProceduredParameter(4, "v_DESCCATALOGO", datosCatalogo.getDescripcionCatalogo(), String.class));
        return accesoDatos.<Catalogo>obtenerElementos(fnConsultaCatalogo);
    }
}
