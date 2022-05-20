package com.baz.catalogo.services;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.daos.*;
import com.baz.catalogo.models.Catalogo;
import com.baz.catalogo.models.DatosActualizacion;
import com.baz.catalogo.models.DatosAlta;
import com.baz.catalogo.models.DatosConsulta;

/**
 * <b>CatalogoFactory</b>
 * @descripcion: Entidad que representa la estructura de una respuesta genérica de base de datos
 * @autor: Daniel Hernandez Garcia
 * @ultimaModificacion: 11/05/2022
 */
@Model
public class CatalogoFactory {
        //Objeto con acceso a datos para actualizar catálogos
        @Inject
        ActualizarCatalogoDao actualizaCatalogo;

        //Objeto con acceso a datos para registrar catálogos
        @Inject
        RegistrarCatalogoDao altaCatalogo;
        @Inject

        //Objeto con acceso a datos para consultar catálogos
        ConsultarCatalogoDao consultaCatalogo;
        @Inject

        //Objeto con acceso a datos para eliminar catálogos
        EliminarCatalogoDao eliminaCatalogo;

        /**
         * Realiza la actualización de un catalogo dato un objeto tipo catalogo
         * @param datosCatalogo Datos del catalogo a actualizar
         * @return boolean True su la actualización fue correcta
         */
        public boolean actualizarCatalogo(DatosActualizacion datosCatalogo) {
                return actualizaCatalogo.actualizarCatalogo(datosCatalogo);
        }

        /**
         * Realiza el registro o alta de un catalogo
         * @param datosCatalogo Datos del catalogo a registrar
         * @return boolean True si el registro fue exitoso
         */
        public boolean agregarCatalogo(DatosAlta datosCatalogo) {
                return altaCatalogo.agregarCatalogo(datosCatalogo);
        }

        /**
         * Realiza la eliminación de un catalogo
         * @param idCategoria Identificador de la categoría
         * @param idCatalogo Identificador del catalogo
         * @param usuario Usuario que elimina
         * @return boolean True si la eliminación fue exitosa
         */
        public boolean eliminarCatalogo(Integer idCategoria, Integer idCatalogo, String usuario) {
                return eliminaCatalogo.eliminarCatalogo(idCategoria, idCatalogo, usuario);
        }

        /**
         * Realiza la consulta de catálogos dado los parámetros especificados
         * @param datosCatalogo Datos de consulta los datos nulos son parámetros opcionales de consulta
         * @return List<Catalogo> Lista de catálogos
         */
        public List<Catalogo> obtenerCatalogos(DatosConsulta datosCatalogo) {
                return consultaCatalogo.obtenerCatalogos(datosCatalogo);
        }
}
