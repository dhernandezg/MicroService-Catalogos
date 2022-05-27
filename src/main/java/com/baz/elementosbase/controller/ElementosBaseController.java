package com.baz.elementosbase.controller;

import com.baz.dtos.CatalogoResponseDto;
import com.baz.elementosbase.models.CrearElementoBaseModel;
import com.baz.elementosbase.models.ElementosBaseModel;
import com.baz.elementosbase.services.ElementosBaseService;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/elementosbase")
public class ElementosBaseController {

    /**
     * Inyección de dependencia del servicio de elementos base
     */
    @Inject
    ElementosBaseService elementosBaseService;

    /**
     * <b>consultarElementosBase</b>
     * @descripcion: Método para consultar elemento base mediante categoria,
     * catálogo e identificador de elemento base o todos los lementos mediante
     * parametros vacios.
     * @autor: Diego Vázquez Pérez
     * @param idCategoria Identificador de la categoría a la que pertenece el catálogo.
     * @param idCatalogo Identificador del catálogo al que pertenece el elemento base.
     * @param idElementoBase Identificador del elemento base a consultar.
     * @ultimaModificacion: ${date}
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consulta una categoría particular por identificador o descripción o todas las categorías con parámetros vacíos.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    public CatalogoResponseDto<Iterable<ElementosBaseModel>> consultarElementosBase(
            @Parameter(example = "1", description = "Identificador de la categoría a la que pertenece el catálogo.")
            @QueryParam("idCategoria") Integer idCategoria,

            @Parameter(example = "1", description = "Identificador del catálogo al que pertenece el elemento base.")
            @QueryParam("idCatalogo") Integer idCatalogo,

            @Parameter(example = "4", description = "Identificador del elemento base a consultar.")
            @QueryParam("idElementoBase") Integer idElementoBase){

        Iterable<ElementosBaseModel> elementosBaseModels = elementosBaseService.consultarElementosBase(
                idCategoria,
                idCatalogo,
                idElementoBase);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                elementosBaseModels);
    }

    /**
     * <b>crearElementoBase</b>
     * @descripcion: Método POST para crear registro de elemento base
     * @autor: Diego Vázquez Pérez
     * @param crearElementoBaseModel Datos requeridos del elemento base a registrar.
     * @ultimaModificacion: 27/05/2022
     */

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001", schema = @Schema)
    public CatalogoResponseDto<Boolean> crearElementoBase(
            @Parameter(description = "Datos requeridos del elemento base a registrar.")
                    CrearElementoBaseModel crearElementoBaseModel){

        boolean response = elementosBaseService.crearElementoBase(crearElementoBaseModel);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                response);

    }
}
