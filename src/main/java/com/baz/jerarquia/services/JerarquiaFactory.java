package com.baz.jerarquia.services;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.jerarquia.models.*;
import com.baz.jerarquia.daos.*;

/**
 * <b>JerarquiaFactory</b>
 * @descripcion: Entidad que representa la estructura de una respuesta genérica de base de datos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class JerarquiaFactory {
    //Objeto con acceso a datos para actualizar catálogos
    @Inject
    ActualizarJerarquiaDao actualizaJerarquia;

    //Objeto con acceso a datos para registrar catálogos
    @Inject
    RegistrarJerarquiaDao altaJerarquia;

    //Objeto con acceso a datos para consultar catálogos
    @Inject
    ConsultarJerarquiaDao consultaJerarquia;

    //Objeto con acceso a datos para eliminar catálogos
    @Inject
    EliminarJerarquiaDao eliminaJerarquia;

    /**
     * Realiza la actualización de un Jerarquia dato un objeto tipo Jerarquia
     * @param datosJerarquia Datos del Jerarquia a actualizar
     * @return boolean True su la actualización fue correcta
     */
    public boolean actualizarJerarquia(DatosActualizacion datosJerarquia) {
            return actualizaJerarquia.actualizarJerarquia(datosJerarquia);
    }

    /**
     * Realiza el registro o alta de un Jerarquia
     * @param datosJerarquia Datos del Jerarquia a registrar
     * @return boolean True si el registro fue exitoso
     */
    public boolean agregarJerarquia(DatosAlta datosJerarquia) {
            return altaJerarquia.agregarJerarquia(datosJerarquia);
    }

    /**
     * Realiza la eliminación de un Jerarquia
     * @param idCategoria Identificador de la categoría
     * @param idJerarquia Identificador del Jerarquia
     * @param usuario Usuario que elimina
     * @return boolean True si la eliminación fue exitosa
     */
    public boolean eliminarJerarquia(Integer idCategoria, Integer idJerarquia,Integer idCatalogoHijo, String usuario) {
            return eliminaJerarquia.eliminarJerarquia(idCategoria, idJerarquia, idCatalogoHijo, usuario);
    }

    /**
     * Realiza la consulta de catálogos dado los parámetros especificados
     * @param datosJerarquia Datos de consulta los datos nulos son parámetros opcionales de consulta
     * @return List<Jerarquia> Lista de catálogos
     */
    public List<Jerarquia> obtenerJerarquia(DatosConsulta datosJerarquia) {
            return consultaJerarquia.obtenerJerarquia(datosJerarquia);
    }
}
