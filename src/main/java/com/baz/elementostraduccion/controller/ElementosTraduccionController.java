package com.baz.elementostraduccion.controller;

import com.baz.dtos.CatalogoResponseDto;
import com.baz.elementostraduccion.models.ElementosTraduccionModel;
import com.baz.elementostraduccion.services.ElementosTraduccionService;
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

@Path("/elementostraduccion")
public class ElementosTraduccionController {

    /**
     * Inyección de dependencias para consumo de servicios
     */

    @Inject
    ElementosTraduccionService traduccionService;

    /**
         * <b>consultarElementosTraduccion</b>
         * @descripcion: Método GET para consultar un elemento traducción por categoria,
         * catalogo e identificador o todos los elementos traducción mediante categoria y catalogo
         * @autor: Diego Vázquez Pérez
         * @param idCategoria Identificador de la categoría
         * @param idCatalogo Identificador del catálogo
         * @param idElementoTrad Identificador del elemento traducción
         * @ultimaModificacion: 30/05/2022
         */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Consultar elementos traducción.")
    @Parameter(in = ParameterIn.HEADER, description = "Folio único de operación - UID", name = "x-request-id", required = true, example = "UID202220050001")
    @Parameter(in = ParameterIn.HEADER, description = "Token - Código de acceso", name = "token", required = true, example = "MITOKEN")
    public CatalogoResponseDto<Iterable<ElementosTraduccionModel>> consultarElementosTraduccion(
            @Parameter(example = "1", description = "Identificador de la categoría a la que pertenece el catálogo.")
            @QueryParam("idCategoria") Integer idCategoria,

            @Parameter(example = "1", description = "Identificador del catálogo al que pertenece el elemento base.")
            @QueryParam("idCatalogo") Integer idCatalogo,

            @Parameter(example = "4", description = "Identificador del elemento traducción a consultar.")
            @QueryParam("idElementoBase") Integer idElementoTrad
    ){

        Iterable<ElementosTraduccionModel> traduccionModels = traduccionService.consultarElementosTrad(
                idCategoria,
                idCatalogo,
                idElementoTrad);

        return new CatalogoResponseDto<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                traduccionModels);
    }
}
