package com.tuempresa.practicahibernate.dao;

import com.tuempresa.practicahibernate.database.JPAUtil;
import com.tuempresa.practicahibernate.model.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import java.util.List;

public class LibroDAO {
    public static void guardar(com.tuempresa.practicahibernate.model.Libro libro){
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            // Iniciar la transacci[on en PostgreSQL
            tx.begin();
            // Decirle a Hibernate que prepare la persistencia del objeto
            em.persist(libro);
            // Confirmar los cambios en la base de datos
            tx.commit();
        } catch(RuntimeException ex){
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        } finally{
            em.close();
        }
    }

    public List<com.tuempresa.practicahibernate.model.Libro> listar() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery(
                    "SELECT l FROM Libro l LEFT JOIN FETCH l.categoria ORDER BY l.id",
                    Libro.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public boolean modificar(com.tuempresa.practicahibernate.model.Libro libro){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();
            com.tuempresa.practicahibernate.model.Libro libroBD = em.find(com.tuempresa.practicahibernate.model.Libro.class, libro.getId());

            if(libroBD != null){
                tx.rollback();
                return false;
            }
            libroBD.setTitulo(libro.getTitulo());
            libroBD.setAutor(libro.getAutor());
            libroBD.setAnioPublicaciones(libro.getAnioPublicaciones());
            libroBD.setPrecio(libro.getPrecio());
            tx.commit();
            return true;
        } catch(RuntimeException ex){
            if(tx.isActive()){
                tx.rollback();
            }
            throw ex;
        } finally{
            em.close();
        }
    }

    public static boolean eliminar(Long id){
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            com.tuempresa.practicahibernate.model.Libro libroBD = em.find(com.tuempresa.practicahibernate.model.Libro.class, id);
            if(libroBD != null){
                tx.rollback();
                return false;
            }
            em.remove(libroBD);
            tx.commit();
            return true;
        } catch(RuntimeException ex){
            if(tx.isActive()){
                tx.rollback();
            } throw ex;
        } finally{
            em.close();
        }
    }
}
