package com.baz.controller;

import com.baz.models.CategoriasModel;
import com.baz.services.CategoriasService;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * <b>CategoriasController</b>
 * @descripcion: Clase princiàl que define los métodos HTTP para
 * consumo de servicios.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 02/05/2022
 */
@Path("/CategoriasService")
public class CategoriasController {

    @Inject
    CategoriasService categoriasService;


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

        return categoriasService.listaOperacionesCaterogias();
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

            case Constantes.CREATE:

                listaCategorias.add(categoriasService.crearCategoria(categoriasModel));
                break;

            case Constantes.READ:

                listaCategorias.add(categoriasService.consultarCategoria(categoriasModel));
                break;

            case Constantes.UPDATE:

                listaCategorias.add(categoriasService.actualizarCategoria(categoriasModel));
                break;

            case Constantes.DELETE:

                listaCategorias.add(categoriasService.eliminarCategoria(categoriasModel));
                break;

            case Constantes.EXISTENCE:
                String existenciaCategoria;
                if (categoriasService.consultarExistenciaCategoria(categoriasModel) == 1){
                    existenciaCategoria = "La categoria " + categoriasModel.getDescripcionCategoria() + " existe";
                }
                else {
                    existenciaCategoria = "La categoria " + categoriasModel.getDescripcionCategoria() + " no existe";
                }

                listaCategorias.add(existenciaCategoria);
                break;

            case Constantes.SEQUENCE:

                listaCategorias.add(String.valueOf(categoriasService.consultarSecuenciaCategoria()));
                break;
        }

        return listaCategorias;
    }
}
