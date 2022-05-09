package com.baz.categorias.daos;

import com.baz.categorias.models.CategoriasModel;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CategoriasDAOImpl implements CategoriasDAO{

    @Inject
    EntityManager manejaEntidad;

    @Transactional
    @Override
    public Object crearCategoria(CategoriasModel categoriasModel) {

        Object response = 0;

        try{
            StoredProcedureQuery storedProcedureQuery = manejaEntidad.createStoredProcedureQuery("FNCATEGORIAINS")
                    .registerStoredProcedureParameter("v_DESCCATEG", String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("v_USUARIO", String.class, ParameterMode.IN)
                    .setParameter("v_DESCCATEG", categoriasModel.getDescripcionCategoria())
                    .setParameter("v_USUARIO", categoriasModel.getNombreUsuario());

            storedProcedureQuery.execute();

            response = storedProcedureQuery.getSingleResult();

        }catch (Exception e){
            e.printStackTrace();
        }

        return response;
    }

    @Transactional
    @Override
    public List<CategoriasModel> consultarCategoria(CategoriasModel categoriasModel) {

        List<CategoriasModel> categoriasModellist = new ArrayList<>();

        try{
            StoredProcedureQuery storedProcedureQuery = manejaEntidad
                    .createStoredProcedureQuery("FNCATEGORIASEL", CategoriasModel.class)
                    .registerStoredProcedureParameter("v_CATEGORIAID", Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("v_DESCCATEG", String.class, ParameterMode.IN)
                    .setParameter("v_CATEGORIAID", categoriasModel.getIdCategoria())
                    .setParameter("v_DESCCATEG", categoriasModel.getDescripcionCategoria());

            storedProcedureQuery.execute();

            System.out.println("########\n####################\n###########"+storedProcedureQuery.getResultList());

            categoriasModellist.addAll(storedProcedureQuery.getResultList());

        }catch (Exception e){
            e.printStackTrace();
        }

        return categoriasModellist;
    }

    @Override
    public void actualizarCategoria(CategoriasModel categoriasModel) {

    }

    @Override
    public void eliminarCategoria(CategoriasModel categoriasModel) {

    }
}
