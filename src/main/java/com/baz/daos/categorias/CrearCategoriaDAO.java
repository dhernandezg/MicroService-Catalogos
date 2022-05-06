package com.baz.daos.categorias;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

@ApplicationScoped
public class CrearCategoriaDAO {

    @Inject
    EntityManager entityManager;


    @Transactional
    public Object consumoCrearFuncion(String descripcionCategoria,
                                      String usuario){
        Object response = 0;

        try{
            StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("FNCATEGORIAINS")
                    .registerStoredProcedureParameter("v_DESCCATEG", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("v_USUARIO", String.class, ParameterMode.IN)
                    .setParameter("v_DESCCATEG", descripcionCategoria)
                    .setParameter("v_USUARIO", usuario);

            storedProcedureQuery.execute();

            response = storedProcedureQuery.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }



        return response;
    }
}
