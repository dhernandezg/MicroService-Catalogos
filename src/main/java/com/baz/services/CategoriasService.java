package com.baz.services;

import com.baz.daos.categorias.ConsultarCategoriasDAO;
import com.baz.daos.categorias.ExistenciaCategoriasDAO;
import com.baz.daos.categorias.SecuenciaCategoriasDAO;
import com.baz.models.CategoriasModel;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <b>CategoriasService</b>
 * @descripcion: Clase principal del servicio de categorias, dentro
 * se encuentran los métodos de administración de categorías.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 01/05/2022
 */

@Singleton
public class CategoriasService {

    public List<String> listaOperacionesCaterogias(){

        ArrayList<String> lista = new ArrayList<>();

        lista.add(Constantes.CREATE);
        lista.add(Constantes.READ);
        lista.add(Constantes.UPDATE);
        lista.add(Constantes.DELETE);
        lista.add(Constantes.SEQUENCE);
        lista.add(Constantes.EXISTENCE);

        return lista;
    }

    /**
     * <b>crearCategoria</b>
     * @descripcion: Método para crear una o varias categorías
     * en la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    public String crearCategoria(CategoriasModel categoriasModel){
        String simpleDateFormat = new SimpleDateFormat("YYYY-mm-dd HH:mm:ss.SSS").format(new Date());
        categoriasModel.setIdStatus(BigDecimal.valueOf(1));
        categoriasModel.setIdCategoria(BigDecimal.valueOf(1));
        categoriasModel.setDescripcionCategoria("GEO");
        //categoriasModel.setFechaModificacion(simpleDateFormat);

        return "categoriasModel.getFechaModificacion()";
    }

    /**
     * <b>consultarCategoria</b>
     * @descripcion: Método para consular una o varias categorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @Inject
    ConsultarCategoriasDAO consultarCategoriasDAO;
    public CategoriasModel consultarCategoria(CategoriasModel categoriasModel){

        return consultarCategoriasDAO.consultarCategoriasFuncion(
                categoriasModel.getIdCategoria(),
                categoriasModel.getDescripcionCategoria()
        );
    }

    /**
     * <b>actualizarCategoria</b>
     * @descripcion: Método para actualizar una o varias catergorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    public String actualizarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria(BigDecimal.valueOf(5));
        categoriasModel.setDescripcionCategoria("GEOGRAFIA");

        return categoriasModel.getDescripcionCategoria();
    }

    /**
     * <b>eliminarCategoria</b>
     * @descripcion: Método para borrado lógico de una o varias
     * categorías de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    public String eliminarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria(BigDecimal.valueOf(6));
        categoriasModel.setDescripcionCategoria("PAISES");

        return categoriasModel.getDescripcionCategoria();
    }

    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método para consultar los tipo de operaciones
     * para el CategoriasService (Se utiliza el nombre como PathParam).
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @Inject
    ExistenciaCategoriasDAO existenciaCategoriasDAO;
    public List<CategoriasModel> consultarExistenciaCategoria(CategoriasModel categoriasModel) {

        return existenciaCategoriasDAO.consumeExistenciaFuncion(categoriasModel);
    }


    /**
     * <b>consultarSecuenciaCategoria</b>
     * @descripcion: Método para consultar la secuencia de la categoría
     * para obtener el siguiente identificador.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 02/05/2022
     */

    @Inject
    SecuenciaCategoriasDAO secuenciaCategoriasDAO;
    public int consultarSecuenciaCategoria(){

        return secuenciaCategoriasDAO.consumeSecuenciaFuncion();
    }

}