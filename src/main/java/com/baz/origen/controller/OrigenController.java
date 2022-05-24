package com.baz.origen.controller;

import com.baz.dtos.CatalogoResponseDto;
import com.baz.origen.models.ActualizarOrigenModel;
import com.baz.origen.models.OrigenModel;
import com.baz.origen.services.OrigenService;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/origen")
public class OrigenController {

    /**
     * Inyecta dependencia del servicio origen
     */
    @Inject
    OrigenService origenService;


    /**
     * <b>consultarOrigen</b>
     * @descripcion: Método GET para consulta de orígenes disponibles
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen
     * @param claveOrigen Clave del origen
     * @ultimaModificacion: 23/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta el listado de orígenes disponibles.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    public CatalogoResponseDto<Iterable<OrigenModel>> consultarOrigen(
            @Parameter(example = "1", description = "Identificador del origen.")
            @QueryParam("idOrigen") Short idOrigen,

            @Parameter(example = "IDI", description = "Clave del campo.")
            @QueryParam("claveOrigen") String claveOrigen){

        Iterable<OrigenModel> origenModels = origenService.consultarOrigen(
                idOrigen,
                claveOrigen);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                origenModels);
    }

    /**
     * <b>crearOrigen</b>
     * @descripcion: Método POST para crear origen
     * @autor: Diego Vázquez Pérez
     * @param descripcionOrigen Descripción del origen
     * @param claveOrigen CLva del origen
     * @param usuarioNombre Nombre del usuario que registra
     * @ultimaModificacion: 23/05/2022
     */

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Registra un nuevo origen.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    public CatalogoResponseDto<Boolean> crearOrigen(
            @Schema(example = "Inteligencia de Datos e Innovación", description = "Nombre del área de origen")
            @QueryParam("descripcionOrigen") String descripcionOrigen,

            @Schema(example = "IDI", description = "Clave del área de origen")
            @QueryParam("claveOrigen") String claveOrigen,

            @Schema(example = "Nombre Apellido1 Apellido2", description = "Nombre del usuario que registra")
            @QueryParam("usuarioNombre") String usuarioNombre){

        boolean response = origenService.crearOrigen(descripcionOrigen,
                claveOrigen,
                usuarioNombre);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);
    }

    /**
     * <b>actualizarOrigen</b>
     * @descripcion: Método PUT para actualizar origen
     * @autor: Diego Vázquez Pérez
     * @param actualizarOrigenModel Datos requeridos para actualizar origen
     * @ultimaModificacion: 23/05/2022
     */

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Actualiza el registro de un origen existente.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    public CatalogoResponseDto<Boolean> actualizarOrigen(
            @Parameter(description = "Datos requeridos para actualizar origen.")
            ActualizarOrigenModel actualizarOrigenModel
    ){

        boolean response = origenService.actualizarOrigen(
                actualizarOrigenModel.getIdOrigen(),
                actualizarOrigenModel.getDescripcionOrigen(),
                actualizarOrigenModel.getClaveOrigen(),
                actualizarOrigenModel.getIdEstatus(),
                actualizarOrigenModel.getUsuarioNombre());

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);

    }

    /**
     * <b>eliminarOrigen</b>
     * @descripcion: Método DELETE para eliminar origen
     * @autor: Diego Vázquez Pérez
     * @param idOrigen Identificador del origen a eliminar
     * @param usuarioNombre Nombre del usuario que elimina
     * @ultimaModificacion: 16/05/2022
     */

    @DELETE
    @Path("/{idOrigen}/usuario/{usuarioNombre}")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Elimina origen mediante su identificador.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    public CatalogoResponseDto<Boolean> eliminarOrigen(
            @Parameter(example = "1", description = "Identificador del origen a eliinar.")
            @QueryParam("idOrigen") Short idOrigen,

            @Parameter(example = "Diego Vázquez", description = "Nombre del usuario que elimina.")
            @QueryParam("usuarioNombre") String usuarioNombre
    ){

        boolean response = origenService.eliminarOrigen(idOrigen, usuarioNombre);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);
    }
}
