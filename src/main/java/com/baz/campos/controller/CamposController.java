package com.baz.campos.controller;

import com.baz.campos.models.CamposModel;
import com.baz.campos.services.CamposService;
import com.baz.categorias.dtos.GenericResponse;
import com.baz.utils.Constantes;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/CamposService")
public class CamposController {

    @Inject
    CamposService camposService;

    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método para mostrar lista de operaciones que
     * el usuario puede ejecutar en Campos.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: Diego Vázquez Pérez
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<ArrayList> listaOperaciones(){

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                camposService.listaOperacionesCampos());
    }

    /**
     * <b>consultarCampo</b>
     * @descripcion: Servicio GET para consultar campo
     * @autor: Diego Vázquez Pérez
     * @param idCampo Identificador del campo
     * @param descripcionCampo Descripción del campo
     * @ultimaModificacion: ${date}
     */

    @GET
    @Path("/ConsultaCampo")
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<Iterable<CamposModel>> consultarCampo(
            @Schema(example = "1", description = "Identificador del campo.")
            @QueryParam("idCampo") Integer idCampo,
            @Schema(example = "CLAVE", description = "Descripción del campo.")
            @QueryParam("descripcionCategoria") String descripcionCampo){

        Iterable<CamposModel> camposModels = camposService.consultarCampo(idCampo,
                descripcionCampo);

        return new GenericResponse<>(Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                camposModels);
    }
}
