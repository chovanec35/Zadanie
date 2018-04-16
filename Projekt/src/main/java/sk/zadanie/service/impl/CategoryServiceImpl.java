/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.zadanie.dao.CategoryDao;
import sk.zadanie.entity.Category;
import sk.zadanie.service.CategoryService;

/**
 *
 * @author Lenovo
 */
@Service
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryDao categoryDao;

    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
    
    
}
