/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.dao.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import sk.zadanie.dao.CategoryDao;
import sk.zadanie.entity.Categorie;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllCategories() {
        String sql = "select name from Categories";
        List<Map<String, Object>> categories = jdbcTemplate.queryForList(sql);

        System.out.println("categories " + categories);
        return categories;
    }
}
