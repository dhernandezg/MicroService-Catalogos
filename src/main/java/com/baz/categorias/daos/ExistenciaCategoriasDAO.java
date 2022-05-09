package com.baz.categorias.daos;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.math.BigDecimal;

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
    public int consumeExistenciaFuncion(BigDecimal idCategoria, String descripcionCategoria){

        int existenciaBinaria = 0;

        try{
            StoredProcedureQuery storedProcedureQuery = entityManager
                    .createStoredProcedureQuery("FNCATEGOEXIST")
                    .registerStoredProcedureParameter("PA_FICATEGORIAID", BigDecimal.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("FCDESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("PA_FICATEGORIAID", idCategoria)
                    .setParameter("FCDESCCATEG", descripcionCategoria);

            storedProcedureQuery.execute();
            System.out.println("#########\n####################\n############"+existenciaBinaria);

            existenciaBinaria = (int) storedProcedureQuery.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }

        return existenciaBinaria;
    }
}
