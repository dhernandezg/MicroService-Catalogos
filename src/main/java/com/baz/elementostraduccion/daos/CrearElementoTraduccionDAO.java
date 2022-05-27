package com.baz.elementostraduccion.daos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.baz.elementostraduccion.models.CrearElementoTraduccionModel;
import com.baz.models.OperacionPsql;
import com.baz.utils.*;
/**
 * <b>CrearElementoTraduccionDAO</b>
 * @descripcion: Clase principal del método para crear elemento traducción de acceso a DB
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 27/05/2022
 */

@ApplicationScoped
public class CrearElementoTraduccionDAO {

    /**
     * Inyección de dependencia para acceso a DB
     */

    @Inject
    BaseDeDatosService baseDeDatosService;

    /**
     * <b>crearElementoTraduccion</b>
     * @descripcion: Método para crear elemento traducción
     * @autor: Diego Vázquez Pérez
     * @param crearElementoTraduccionModel Modelo de datos requeridos para crear un elemento traducción
     * @ultimaModificacion: 27/05/2022
     */

    public boolean crearElementoTraduccion(
            CrearElementoTraduccionModel crearElementoTraduccionModel){

        StoredProcedure crearElementoTrad = new StoredProcedure("SC_CATREM.FNCATELETRADINS", OperacionPsql.class);
        crearElementoTrad.addParameters(new ProceduredParameter(1, "PA_FICATEGORIAID", crearElementoTraduccionModel.getIdCategoria(), Integer.class));
        crearElementoTrad.addParameters(new ProceduredParameter(2, "PA_FICATALOGOID", crearElementoTraduccionModel.getIdCatalogo(), Integer.class));
        crearElementoTrad.addParameters(new ProceduredParameter(3, "PA_FCVALOR", crearElementoTraduccionModel.getValor(), String.class));
        crearElementoTrad.addParameters(new ProceduredParameter(4, "PA_FICAMPOID", crearElementoTraduccionModel.getIdCampo(), Short.class));
        crearElementoTrad.addParameters(new ProceduredParameter(5, "PA_FIORDEN", crearElementoTraduccionModel.getOrden(), Short.class));
        crearElementoTrad.addParameters(new ProceduredParameter(6, "PA_FCVALORBASE", crearElementoTraduccionModel.getValorBase(), String.class));
        crearElementoTrad.addParameters(new ProceduredParameter(7, "PA_USUARIO", crearElementoTraduccionModel.getUsuarioNombre(), String.class));

        var data = baseDeDatosService.<OperacionPsql>obtenerElementos(crearElementoTrad);

        return !data.isEmpty() && data.get(0).estatus == 1;
    }
}
