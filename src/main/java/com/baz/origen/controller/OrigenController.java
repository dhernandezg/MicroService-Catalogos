package com.baz.origen.controller;

import com.baz.categorias.dtos.GenericResponse;
import com.baz.origen.services.OrigenService;
import com.baz.utils.Constantes;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/OrigenService")
public class OrigenController {

    @Inject
    OrigenService origenService;

    /**
     * <b>listaOperaciones</b>
     * @descripcion: Método GET para consultar operaciones
     * que se pueden ejecutar en OrigenService.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 12/05/2022
     */

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GenericResponse<ArrayList> listaOperaciones(){

        return new GenericResponse<>(
                Constantes.HTTP_200,
                Constantes.MENSAJE_EXITO,
                origenService.listaOperacionesOrigen());
    }
}
