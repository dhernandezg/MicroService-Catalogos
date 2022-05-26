package com.baz.controller;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.baz.dtos.ResponseDto;
import com.baz.utils.NoFilter;

import org.eclipse.microprofile.openapi.annotations.Operation;

/**
 * <b>StatusController</b>
 * @descripcion: Controlador de Status para Apigee
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Path("/status")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StatusController {
    /**
     * Contiene las constantes para el controlador
     */
    private final String OK_MENSAJE = "OK";
    private final String AZAR_REGEX = "UID%1$12s";
    private final Integer AZAR_INICIO = 1;

    /**
     * Obtiene el estatus del servicio para Apigee
     * @return CatalogoResponse<Iterable<Catalogo>> Respuesta con la lista de catálogos
     * @throws NoSuchAlgorithmException Algoritmo de generación aleatoria no especificado
     */
    @GET
    @Operation(summary = "Obtiene el estatus del servicio para Apigee")
    @NoFilter
    public ResponseDto estatus() throws NoSuchAlgorithmException {
        ResponseDto datosStatus = new ResponseDto();
        datosStatus.setFolio(generarFolioAleatorio());
        datosStatus.setMensaje(OK_MENSAJE);
        return datosStatus;
    }

    /**
     * Genera el folio aleatorio para el método status de Apigee
     * @return Folio aleatorio
     */
    public String generarFolioAleatorio() throws NoSuchAlgorithmException {
        Random random = SecureRandom.getInstanceStrong();
        return String.format(AZAR_REGEX, random.nextInt(Integer.MAX_VALUE - AZAR_INICIO))
                .replace(' ', '0');
    }
}
