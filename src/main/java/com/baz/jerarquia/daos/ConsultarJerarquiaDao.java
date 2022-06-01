package com.baz.jerarquia.daos;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.jerarquia.models.DatosConsulta;
import com.baz.jerarquia.models.Jerarquia;
import com.baz.utils.BaseDeDatosService;
import com.baz.utils.ProceduredParameter;
import com.baz.utils.StoredProcedure;

/**
 * <b>ConsultarJerarquiaDao</b>
 * @descripcion: Clase que contiene los métodos de consulta para las jerarquias
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class ConsultarJerarquiaDao {
    /**
     * Objeto de acceso a base de datos
     */
    @Inject
    BaseDeDatosService accesoDatos;

    /**
     * Obtiene una lista de jerarquias a partir de los parámetros proporcionados
     * 
     * @param datosJerarquia Datos de consulta
     * @return List<Jerarquia> Lista de <b>Jerarquias<b>
     */
    public List<Jerarquia> obtenerJerarquia(DatosConsulta datosJerarquia) {
        StoredProcedure fnConsultaJerarquia = new StoredProcedure("SC_CATREM.FNJERARQSEL", Jerarquia.class);
        fnConsultaJerarquia.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", datosJerarquia.getIdCategoria(), Integer.class));
        fnConsultaJerarquia.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", datosJerarquia.getIdCatalogo(), Integer.class));
        fnConsultaJerarquia.addParameters(new ProceduredParameter(3, "PA_FICATJERARQID", datosJerarquia.getIdJerarquia(), Integer.class));
        return accesoDatos.<Jerarquia>obtenerElementos(fnConsultaJerarquia);
    }
}
