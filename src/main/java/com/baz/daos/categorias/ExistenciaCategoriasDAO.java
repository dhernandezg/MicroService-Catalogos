package com.baz.daos.categorias;

import com.baz.models.CategoriasModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ExistenciaCategoriasDAO {

    @Inject
    EntityManager entityManager;

    /**
     * <b>${consumeExistenciaFuncion}</b>
     * @descripcion: Método DAO para consumo de función Existencia de Categorias en DB.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @Transactional
    public List<CategoriasModel> consumeExistenciaFuncion(CategoriasModel categoriasModel){

        List<CategoriasModel> categoriasModelList = new ArrayList<>();

        try{
            StoredProcedureQuery storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("FNCATEGORIASEL")
                    .registerStoredProcedureParameter("v_CATEGORIAID", BigDecimal.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("v_DESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("v_CATEGORIAID", categoriasModel.getIdCategoria())
                    .setParameter("v_DESCCATEG", categoriasModel.getDescripcionCategoria());

            storedProcedureQuery.execute();

            categoriasModelList = storedProcedureQuery.getResultList();

        }catch (Exception e){
            e.printStackTrace();
        }

        return categoriasModelList;
    }
}
