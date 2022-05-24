package com.baz.estatus.controller;

import com.baz.dtos.CatalogoResponseDto;
import com.baz.estatus.models.EstatusModel;
import com.baz.estatus.services.EstatusService;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * <b>EstatusController</b>
 * @descripcion: Clase principal del controlador de Estatus, donde
 * se definen los métodos HTTP para consumo de servicios.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 24/05/2022
 */

@Path("/estatus")
public class EstatusController {

    /**
     * Inyección de dependencia para el consumo del servicio estatus.
     */
    @Inject
    EstatusService estatusService;

    /**
     * <b>${nombreClase}</b>
     * @descripcion: breve descripción del contenido
     * @autor: ${user}, Desarrollador
     * @param idEstatus Identificador del estatus a consultar
     * @param descripcionEstatus Descripción del estatus a consultar
     * @ultimaModificacion: ${date}
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta un estatus particular por identificador o descripción o todos los estatus con parámetros vacíos.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    public CatalogoResponseDto<Iterable<EstatusModel>> consultarEstatus(
            @Parameter(example = "1", description = "Identificador del estatus")
            @QueryParam("idEstatus") Short idEstatus,
            @Parameter(example = "ACTIVO", description = "Nombre de la categoria")
            @QueryParam("descripcionEstatus") String descripcionEstatus
    ){

        Iterable<EstatusModel> estatusModels = estatusService.consultarEstatus(
                idEstatus,
                descripcionEstatus);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                estatusModels);
    }

}
