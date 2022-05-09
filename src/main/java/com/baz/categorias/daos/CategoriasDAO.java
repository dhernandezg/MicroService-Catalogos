package com.baz.categorias.daos;

import com.baz.categorias.models.CategoriasModel;


/**
 * <b>CategoriasDAO</b>
 * @descripcion: Interfaz que permite ejecutar las operaciones básicas
 * CRUD en Categorías.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 09/05/2022
 */

public interface CategoriasDAO {

    public void crearCategoria(CategoriasModel categoriasModel);
    public CategoriasModel consultarCategoria(CategoriasModel categoriasModel);
    public void actualizarCategoria(CategoriasModel categoriasModel);
    public void eliminarCategoria(CategoriasModel categoriasModel);

}
