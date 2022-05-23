package com.baz.utils;

/**
 * <b>Constantes</b>
 * @descripcion: Constantes de microservicio
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
public class Constantes {
    /**
     * Códigos HTTP
     * */
    public static final String HTTP_200 = "200";
    public static final String HTTP_201 = "201";
    public static final String HTTP_400 = "400";
    public static final String HTTP_401 = "401";
    public static final String HTTP_404 = "404";
    public static final String HTTP_500 = "500";

    /**
     * Mensajes HTTP
     * */
    public static final String MENSAJE_EXITO = "Operación exitosa.";
    public static final String MENSAJE_CODIGO400 = "Datos de entrada incorrectos, por favor valide su información.";
    public static final String MENSAJE_CODIGO401 = "No estas autorizado, favor de validar.";
    public static final String MENSAJE_CODIGO404 = "Recurso no encontrado";
    public static final String MENSAJE_CODIGO500 = "Ocurrió un inconveniente al procesar la solicitud.";
    public static final String MENSAJE_CODIGO500_LOG = "Problemas al procesar su solicitud favor de contactar a su administrador.";

    private Constantes(){
        throw new UnsupportedOperationException("Esta clase no debe ser inicializada");
    }
}
