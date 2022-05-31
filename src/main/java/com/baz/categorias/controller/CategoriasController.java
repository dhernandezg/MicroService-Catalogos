package com.baz.categorias.controller;

import com.baz.categorias.models.ActualizarCategoriaModel;
import com.baz.categorias.models.CategoriasModel;
import com.baz.categorias.models.CrearCategoriaModel;
import com.baz.categorias.services.CategoriasService;
import com.baz.dtos.CatalogoResponseDto;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import java.lang.Iterable;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * <b>CategoriasController</b>
 * @descripcion: Clase princiàl que define los métodos HTTP para
 * consumo de servicios.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 05/05/2022
 */

@Path("/categorias")
public class CategoriasController {

    /**
     * Objecto de acceso al servicio de categorías
     */
    @Inject
    CategoriasService categoriasService;


    /**
     * <b>consultarCategoria</b>
     * @descripcion: Método GET para consulta por categoría.
     * @autor: DIego Vázquez Pérez
     * @param idCategoria Descripción de la categoria.
     * @param descripcionCategoria Nombre de la categoria.
     * @ultimaModificacion: 09/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta una categoría particular por identificador o descripción o todas las categorías con parámetros vacíos.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Iterable<CategoriasModel>> consultarCategoria(
            @Parameter(example = "1", description = "Identificador de la categoria")
            @QueryParam("idCategoria") Integer idCategoria,
            @Parameter(example = "GEOGRAFIA", description = "Nombre de la categoria")
            @QueryParam("descripcionCategoria") String descripcionCategoria
    ){

        Iterable<CategoriasModel> categoriasModel = categoriasService.consultarCategoria(idCategoria, descripcionCategoria);

        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, categoriasModel) ;
    }

    /**
     * <b>crearCategoria</b>
     * @descripcion: Método POST para crear categoría.
     * @autor: Diego Vázquez Pérez
     * @param crearCategoriaModel Datos necesarios para registrar categoria
     * @ultimaModificacion: 23/05/2022
     */

    @POST
    @Operation(summary = "Registra una nueva categoría.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Boolean> crearCategoria(
            @Parameter(description = "Datos de la categoria a registrar", required = true)
            CrearCategoriaModel crearCategoriaModel){

        boolean response = categoriasService.crearCategoria(crearCategoriaModel.getDescripcionCategoria(),
                crearCategoriaModel.getNombreUsuario());

        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, response);
    }


    /**
     * <b>actualizarCategoria</b>
     * @descripcion: Método para invocar actualización de catergoría.
     * @autor: Diego Vázquez Pérez
     * @param actualizarCategoriaModel Datos de la categoria a actualizar
     * @ultimaModificacion: 10/05/2022
     */

    @PUT
    @Operation(summary = "Actualiza los datos especificados de una categoría.")
    @Produces(MediaType.APPLICATION_JSON)
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Boolean> actualizarCategoria(
            @Parameter(description = "Datos de la categoria a actualizar")
            ActualizarCategoriaModel actualizarCategoriaModel
    ){

        boolean response = categoriasService.actualizarCategoria(
                actualizarCategoriaModel.getIdCategoria(),
                actualizarCategoriaModel.getDescripcionCategoria(),
                actualizarCategoriaModel.getIdEstatus(),
                actualizarCategoriaModel.getUsuarioNombre());
        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, response);
    }


    /**
     * <b>eliminarCategoria</b>
     * @descripcion: Servicio para invocación de eliminar categoría.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoria
     * @param  usuarioNombre Nombre del usuario
     * @ultimaModificacion: 10/05/2022
     */


    @DELETE
    @Path("/{idCategoria}/usuario/{usuario}")
    @Operation(summary = "Elimina una categoría mediante su identificador.")
    @Produces(MediaType.APPLICATION_JSON)
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Boolean> eliminarCategoria(
            @Parameter(example = "1", description = "Identificador de la categoria", required = true)
            @QueryParam("idCategoria") Integer idCategoria,

            @Parameter(example = "Diego Vazquez Perez", description = "Nombre del usuario", required = true)
            @QueryParam("usuarioNombre") String usuarioNombre
    ){

        boolean response = categoriasService.eliminarCategoria(
                idCategoria,
                usuarioNombre);

        return new CatalogoResponseDto<>(Constantes.HTTP_200, Constantes.MENSAJE_EXITO, response);
    }

}
