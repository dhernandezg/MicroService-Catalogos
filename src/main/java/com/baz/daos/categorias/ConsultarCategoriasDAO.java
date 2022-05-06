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
public class ConsultarCategoriasDAO {

    @Inject
    EntityManager entityManager;

    /**
     * <b>${consultarCategoriasFuncion}</b>
     * @descripcion: Método DAO para consumo de función Consultar Categorias en DB.
     * @autor: Diego Vázquez Pérez
     * @ultimaModificacion: 05/05/2022
     */

    @Transactional
    public List<CategoriasModel> consultarCategoriasFuncion(Integer idCategoria, String descripcionCategoria){

        List<CategoriasModel> categoriasModellist = new ArrayList<>();

        try{
            StoredProcedureQuery storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("FNCATEGORIASEL")
                    .registerStoredProcedureParameter("v_CATEGORIAID", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("v_DESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("v_CATEGORIAID", idCategoria)
                    .setParameter("v_DESCCATEG", descripcionCategoria);

            storedProcedureQuery.execute();

            System.out.println("########\n####################\n###########"+storedProcedureQuery.getResultList());

            categoriasModellist.addAll(storedProcedureQuery.getResultList());

        }catch (Exception e){
            e.printStackTrace();
        }

        return categoriasModellist;
    }
}
