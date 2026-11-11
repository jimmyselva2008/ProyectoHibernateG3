package com.tuempresa.practicahibernate.dao;
import com.tuempresa.practicahibernate.database.JPAUtil;
import com.tuempresa.practicahibernate.model.Categoria;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CategoriaDAO {

    public List<Categoria> listar() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery("select c from Categoria c", Categoria.class).getResultList();
        }  finally {
            em.close();
        }

    }
}
