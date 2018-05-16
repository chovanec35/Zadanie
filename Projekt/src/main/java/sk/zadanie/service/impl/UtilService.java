/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.springframework.stereotype.Service;
import sk.zadanie.dto.ContactDto;
import sk.zadanie.entity.Category;
import sk.zadanie.entity.User;

@Service
public class UtilService {

    public static Date convertStringToDate(String dateString) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        return date;
    }

    public static Query createQuery(User user, ContactDto contactDto) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Map<String, Object> mapObj = new HashMap<>();
        Map<String, String> mapStr = new HashMap<>();

        String hql = "SELECT c FROM Contact c "
                + "WHERE c.userId.userId = :userId AND c.flagDel = false";
        mapObj.put("userId", user.getUserId());

        if (contactDto.getFirstName() != "") {
            hql += " AND c.firstName LIKE :firstName";
            mapStr.put("firstName", "%" + contactDto.getFirstName() + "%");
        }
        if (contactDto.getLastName() != "") {
            hql += " AND c.lastName LIKE :lastName";
            mapStr.put("lastName", "%" + contactDto.getLastName() + "%");
        }
        if (contactDto.getBirthdate() != "") {
            hql += " AND c.birthdate = :birthdate";
            Date date = UtilService.convertStringToDate(contactDto.getBirthdate());
            mapObj.put("birthdate", date);
        }
        if (contactDto.getCategory() != "") {
            hql += " AND c.categoryId = :categoryId";
            Category category = new Category();
            category.setCategoryId(Integer.parseInt(contactDto.getCategory()));
            mapObj.put("categoryId", category);
        }

        Query query = em.createQuery(hql);

        for (Map.Entry me : mapStr.entrySet()) {
            query.setParameter((String) me.getKey(), me.getValue());
        };
        for (Map.Entry me : mapObj.entrySet()) {
            query.setParameter((String) me.getKey(), me.getValue());
        };
        return query;
    }

    public int countPages(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Contact.countByUserId");
        query.setParameter("userId", user.getUserId());

        int count = ((Number) query.getSingleResult()).intValue();
        em.close();
        emf.close();
        
        if (count % 5 == 0){
            count /= 5;
        }
        else{
            count = (count / 5) + 1;
        }
        return count;
    }
    
    public int countContacts(User user) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createNamedQuery("Contact.countByUserId");
        query.setParameter("userId", user.getUserId());

        int count = ((Number) query.getSingleResult()).intValue();
        em.close();
        emf.close();
        
        return count;
    }

}
