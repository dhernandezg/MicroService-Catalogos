package com.baz.catalogo.services;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import com.baz.catalogo.daos.ActualizarCatalogo;
import com.baz.catalogo.daos.RegistrarCatalogo;
import com.baz.catalogo.daos.ConsultarCatalogo;
import com.baz.catalogo.daos.EliminarCatalogo;
import com.baz.catalogo.models.Catalogo;

@Model
public class CatalogoFactory {
        @Inject
        ActualizarCatalogo actualizaCatalogo;
        @Inject
        RegistrarCatalogo altaCatalogo;
        @Inject
        ConsultarCatalogo consultaCatalogo;
        @Inject
        EliminarCatalogo eliminaCatalogo;

        public boolean actualizarCatalogo(Catalogo datosCatalogo) {
                return actualizaCatalogo.actualizarCatalogo(datosCatalogo);
        }

        public boolean agregarCatalogo(Catalogo datosCatalogo) {
                return altaCatalogo.agregarCatalogo(datosCatalogo);
        }

        public boolean eliminarCatalogo(Integer idCategoria, Integer idCatalogo, String usuario) {
                return eliminaCatalogo.eliminarCatalogo(idCategoria, idCatalogo, usuario);
        }

        public List<Catalogo> obtenerCatalogos(Catalogo datosCatalogo) {
                return consultaCatalogo.obtenerCatalogos(datosCatalogo);
        }

}
