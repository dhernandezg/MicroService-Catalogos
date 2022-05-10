package com.baz.campos.services;

import com.baz.categorias.dtos.GenericResponse;
import com.baz.utils.Constantes;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;


/**
 * <b>CamposService</b>
 * @descripcion: Servicio Campos, en el cual se encuentra la administración
 * de campos.
 * @autor: Diego Vázquez Pérez
 * @ultimaModificacion: 10/05/2022
 */

@Singleton
public class CamposService {

    /**
     * <b>listaOperacionesCampos</b>
     * @descripcion: Método para mostrar lista de operaciones
     * que el usuario puede ejecutar.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 10/05/2022
     */

    public ArrayList listaOperacionesCampos(){

        ArrayList<String> lista = new ArrayList<>();

        lista.add(Constantes.CREATE + Constantes.CAMPOS);
        lista.add(Constantes.READ + Constantes.CAMPOS);
        lista.add(Constantes.UPDATE + Constantes.CAMPOS);
        lista.add(Constantes.DELETE + Constantes.CAMPOS);

        return lista;
    }
}
