package com.baz.filter;

import java.util.regex.Pattern;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.baz.dtos.ErrorResponseDto;
import com.baz.utils.Constantes;
import com.baz.utils.NoFilter;

/**
 * <b>CatalogoFilter<T></b>
 * @descripcion: Filtro para MicroServicio de catálogos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Provider
public class CatalogoFilter implements ContainerRequestFilter {
    /**
     * Mensajes UID
     */
    static final String MENSAJE_SIN_FOLIO = "El folio para esta operación es requerido";
    static final String MENSAJE_SIN_UID = "x-request-id es requerido para completar con la operación";
    static final String MENSAJE_UID_INVALIDO = "El folio de operación no cumple con el formato UID000000000000";

    /**
     * Mensajes token
     */
    static final String MENSAJE_SIN_ACCESO = "Se denegó el acceso al servicio";
    static final String MENSAJE_SIN_TOKEN = "Es necesario proporcionar un token para esta operación";
    static final String MENSAJE_SIN_AUTORIZACION = "No se cuenta con la autorización al sistema";

    static final String URL_AYUDA = "https://baz-developer.bancoazteca.com.mx/info#";
    static final String FOLIO_REGEX = "^UID[0-9]{12}$";

    @Context
    private ResourceInfo resourceInfo;

    /**
     * Filtro de solicitudes HTTP
     * @param requestContext Petición HTTP
     */
    @Override
    public void filter(ContainerRequestContext requestContext) {
        if (requiereFiltro()) {
            this.validarFolio(requestContext);
            this.validarToken(requestContext);
        }
    }

    /**
     * Indica si se debe aplicar el filtro al método especificado
     */
    private boolean requiereFiltro() {
        return resourceInfo.getResourceMethod()
                .getAnnotation(NoFilter.class) == null;
    }

    /**
     * Realiza la validación de token
     * @param requestContext
     */
    private void validarToken(ContainerRequestContext requestContext) {
        String token = obtenerEncabezado(requestContext, Constantes.TOKEN_HEADER);
        boolean tokenValido = esTokenValido(token);
        if (!tokenValido) {
            boolean sinToken = token == null || token.length() == 0;
            ErrorResponseDto errorUid = new ErrorResponseDto();
            errorUid.setMensaje(MENSAJE_SIN_TOKEN);
            errorUid.setInfo(URL_AYUDA);
            errorUid.setCodigo(sinToken ? Constantes.HTTP_401 : Constantes.HTTP_403);
            errorUid.agregarDetalles(sinToken ? MENSAJE_SIN_AUTORIZACION : MENSAJE_SIN_ACCESO);
            asignarError(requestContext, sinToken ? Status.UNAUTHORIZED : Status.FORBIDDEN, errorUid);
        }
    }

    /**
     * Realiza la validación del folio o UID
     * @param requestContext Petición HTTP
     */
    public void validarFolio(ContainerRequestContext requestContext) {
        String folio = obtenerEncabezado(requestContext, Constantes.UID_HEADER);
        boolean folioValido = esFolioValido(folio);
        if (!folioValido) {
            ErrorResponseDto errorUid = new ErrorResponseDto();
            errorUid.setCodigo(Constantes.HTTP_400);
            errorUid.setMensaje(MENSAJE_SIN_FOLIO);
            errorUid.setInfo(URL_AYUDA);
            errorUid.agregarDetalles(folio != null ? MENSAJE_UID_INVALIDO : MENSAJE_SIN_UID);
            asignarError(requestContext, Status.BAD_REQUEST, errorUid);
        }
    }

    /**
     * Asigna el error Http especificado a una petición HTTP
     * @param requestContext Petición
     * @param codigoHttp     Código de error HTTP
     * @param contenidoError Detalle del error
     */
    public <T> void asignarError(ContainerRequestContext requestContext, Response.Status codigoHttp, T contenidoError) {
        Response response = Response.status(codigoHttp)
                .entity(contenidoError)
                .build();
        requestContext.abortWith(response);
    }

    /**
     * Obtiene el encabezado especificado en la petición
     * @param requestContext Petición
     * @param header         Header a validar
     * @return encabezado solicitado.
     */
    public String obtenerEncabezado(ContainerRequestContext requestContext, String header) {
        return requestContext.getHeaderString(header);
    }

    /**
     * Valida el contenido del folio
     * @param folio Dato a validar
     */
    public boolean esFolioValido(String folio) {
        Pattern pattern = Pattern.compile(FOLIO_REGEX);
        return folio != null && pattern.matcher(folio).matches();
    }

    /**
     * Valida el contenido y vigencia del token
     * @param folio Dato a validar
     */
    public boolean esTokenValido(String token) {
        //TODO: Implementar servicio valida TOKEN
        return token != null && token.length() > 0;
    }
}
