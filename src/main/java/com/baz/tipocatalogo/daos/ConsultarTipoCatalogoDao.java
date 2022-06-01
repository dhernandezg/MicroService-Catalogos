package com.baz.tipocatalogo.daos;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.tipocatalogo.models.TipoCatalogo;
import com.baz.tipocatalogo.models.DatosConsulta;
import com.baz.utils.*;

/**
 * <b>ConsultarTipoCatalogoDao</b>
 * @descripcion: Clase que contiene los métodos de consulta para los tipos de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class ConsultarTipoCatalogoDao {
    /**
     * Objeto de acceso a base de datos
     * */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Obtiene una lista de los tipos de catálogos a partir de los parámetros proporcionados
     * @param datosCatalogo Datos de consulta
     * @return List<Catalogo> Lista de <b>Tipos de catálogos<b>
     */
    public List<TipoCatalogo> obtenerTiposCatalogos(DatosConsulta datosCatalogo) {
        StoredProcedure fnConsultaTipoCatalogo = new StoredProcedure("SC_CATREM.FNTIPOCATSEL", TipoCatalogo.class);
        fnConsultaTipoCatalogo.addParameters(new ProceduredParameter(1, "PA_FITIPOCATID", datosCatalogo.getIdTipoCatalogo(), Short.class));
        fnConsultaTipoCatalogo.addParameters(new ProceduredParameter(3, "PA_FCDESCTIPOCAT", datosCatalogo.getTipoCatalogo(), String.class));
        return accesoDatos.<TipoCatalogo>obtenerElementos(fnConsultaTipoCatalogo);
    }
}
