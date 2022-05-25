package com.baz.elementosbase.controller;

import com.baz.dtos.CatalogoResponseDto;
import com.baz.elementosbase.models.ElementosBaseModel;
import com.baz.elementosbase.services.ElementosBaseService;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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
}
