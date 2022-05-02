package com.baz.services;

import com.baz.daos.categorias.ExistenciaCategoriasDAO;
import com.baz.daos.categorias.SecuenciaCategoriasDAO;
import com.baz.models.CategoriasModel;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>CategoriasService</b>
 * @descripcion: Clase principal del servicio de categorias, dentro
 * se encuentran los métodos de administración de categorías.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 01/05/2022
 */

@Path("/CategoriasService")
public class CategoriasService {

    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método para consultar los tipo de operaciones
     * para el CategoriasService (Se utiliza el nombre como PathParam).
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> listaOperaciones(){
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
     * <b>orquestadorOperacionesCategoria</b>
     * @descripcion: Método para redireccionamiento de funciones
     * según el tipo de operación.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 02/05/2022
     */

    @POST
    @Path("/{tipoOperacion}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<String> orquestadorOperacionesCategoria(
            @PathParam("tipoOperacion") String tipoOperacion,
            CategoriasModel categoriasModel
    ) {

        ArrayList<String> listaCategorias = new ArrayList<>();

        switch (tipoOperacion){

            case "CREAR":

                listaCategorias.add(crearCategoria(categoriasModel));
                break;

            case "CONSULTAR":

                listaCategorias.add(consultarCategoria(categoriasModel));
                break;

            case "ACTUALIZAR":

                listaCategorias.add(actualizarCategoria(categoriasModel));
                break;

            case "ELIMINAR":

                listaCategorias.add(eliminarCategoria(categoriasModel));
                break;

            case "EXISTENCIA":
                String existenciaCategoria;
                if (consultarExistenciaCategoria(categoriasModel) == 1){
                    existenciaCategoria = "La categoria " + categoriasModel.getDescripcionCategoria() + " existe";
                }
                else {
                    existenciaCategoria = "La categoria " + categoriasModel.getDescripcionCategoria() + " no existe";
                }

                listaCategorias.add(existenciaCategoria);
                break;

            case "SECUENCIA":

                listaCategorias.add(String.valueOf(consultarSecuenciaCategoria()));
                break;
        }

        return listaCategorias;
    }

    /**
     * <b>crearCategoria</b>
     * @descripcion: Método para crear una o varias categorías
     * en la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    private String crearCategoria(CategoriasModel categoriasModel){
        categoriasModel.setIdCategoria("3");
        categoriasModel.setDescripcionCategoria("PAISES");

        return categoriasModel.getDescripcionCategoria();
    }

    /**
     * <b>consultarCategoria</b>
     * @descripcion: Método para consular una o varias categorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    private String consultarCategoria(CategoriasModel categoriasModel){
        categoriasModel.setIdCategoria("4");
        categoriasModel.setDescripcionCategoria("ESTADOS");

        return categoriasModel.getDescripcionCategoria();
    }

    /**
     * <b>actualizarCategoria</b>
     * @descripcion: Método para actualizar una o varias catergorías
     * de la entidad.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 01/05/2022
     */

    private String actualizarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria("5");
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

    private String eliminarCategoria(CategoriasModel categoriasModel){

        categoriasModel.setIdCategoria("6");
        categoriasModel.setDescripcionCategoria("PAISES");

        return categoriasModel.getDescripcionCategoria();
    }

    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método para consultar los tipo de operaciones
     * para el CategoriasService (Se utiliza el nombre como PathParam).
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 02/05/2022
     */

    @Inject
    private ExistenciaCategoriasDAO existenciaCategoriasDAO;
    private int consultarExistenciaCategoria(CategoriasModel categoriasModel) {

        return existenciaCategoriasDAO.consumeExistenciaFuncion(categoriasModel.getDescripcionCategoria());
    }


    /**
     * <b>consultarSecuenciaCategoria</b>
     * @descripcion: Método para consultar la secuencia de la categoría
     * para obtener el siguiente identificador.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 02/05/2022
     */

    @Inject
    private SecuenciaCategoriasDAO secuenciaCategoriasDAO;
    private int consultarSecuenciaCategoria(){

        return secuenciaCategoriasDAO.consumeSecuenciaFuncion();
    }

}