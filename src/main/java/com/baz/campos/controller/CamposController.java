package com.baz.campos.controller;

import com.baz.campos.models.ActualizarCampoModel;
import com.baz.campos.models.CamposModel;
import com.baz.campos.models.CrearCampoModel;
import com.baz.campos.services.CamposService;
import com.baz.dtos.CatalogoResponseDto;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.jboss.resteasy.reactive.ResponseStatus;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/campos")
public class CamposController {

    /**
     * Inyecta dependencia del servicio de campos
     */
    @Inject
    CamposService camposService;

    /**
     * <b>consultarCampo</b>
     * @descripcion: Servicio GET para consultar campo
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param descripcionCampo Descripción del campo
     * @ultimaModificacion: 23/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta los campos disponibles en el servicio de campos.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Iterable<CamposModel>> consultarCampo(
            @Parameter(example = "1", description = "Identificador del campo.")
            @QueryParam("id") Short idCampo,
            @Parameter(example = "CLAVE", description = "Descripción del campo.")
            @QueryParam("descripcion") String descripcionCampo){

        Iterable<CamposModel> camposModels = camposService.consultarCampo(idCampo,
                descripcionCampo);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                camposModels);
    }

    /**
     * <b>crearCampo</b>
     * @descripcion: Método POST para crear campo
     * @autor: Diego Vázquez Pérez
     * @param crearCampoModel Datos requeridos para registrar campo
     * @ultimaModificacion: 23/05/2022
     */

    @POST
    @ResponseStatus(201)
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Registra un nuevo campo.")
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Boolean> crearCampo(
            CrearCampoModel crearCampoModel
    ){

        boolean response = camposService.crearCampo(
                crearCampoModel.getNombre(),
                crearCampoModel.getDescripcion(),
                crearCampoModel.getUsuario());

        return new CatalogoResponseDto<>(Constantes.HTTP_201,
                Constantes.MENSAJE_EXITO,
                response);

    }

    /**
     * <b>actualizarCampo</b>
     * @descripcion: Método PUT para actualizar campo
     * @autor: Diego Vázquez Pérez
     * @param actualizarCampoModel Datos requeridos para actualizar campo mediante su identificador
     * @ultimaModificacion: 23/05/2022
     */

    @PUT
    @Operation(summary = "Actualiza el registro de un campo existente.")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Boolean> actualizarCampo(
            ActualizarCampoModel actualizarCampoModel
    ){

        boolean response = camposService.actualizarCampo(
                actualizarCampoModel.getId(),
                actualizarCampoModel.getUsuario(),
                actualizarCampoModel.getCampo(),
                actualizarCampoModel.getDescripcion(),
                actualizarCampoModel.getEstatus());

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);

    }

    /**
     * <b>eliminarCampo</b>
     * @descripcion: Método DELETE para eliminar campos.
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param usuarioNombre Nombre del usuario
     * @ultimaModificacion: 23/05/2022
     */

    @DELETE
    @Path("/{idCampo}/usuario/{usuarioNombre}")
    @Operation(summary = "Elimina un campo mediante su identificador.")
    @Produces(MediaType.APPLICATION_JSON)
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN", schema = @Schema)
    public CatalogoResponseDto<Boolean> eliminarCampo(
            @Parameter(example = "1", description = "Identificador del campo.")
            @QueryParam("id") Short idCampo,
            @Parameter(example = "Daniel Hernandez", description = "Nombre del usuario.")
            @QueryParam("usuario") String usuarioNombre){

        boolean response = camposService.eliminarCampo(
                idCampo,
                usuarioNombre);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);
    }
}
