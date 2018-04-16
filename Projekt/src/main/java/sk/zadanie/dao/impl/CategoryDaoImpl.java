/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.dao.impl;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sk.zadanie.dao.CategoryDao;
import sk.zadanie.entity.Category;
import sk.zadanie.entity.Contact;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getAllCategories() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Category.findAll");
        List<Category> categories = (List<Category>) query.getResultList();

        em.close();
        emf.close();

        return categories;
    }
}
