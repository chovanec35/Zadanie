/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.zadanie.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public interface CategoryDao {
        List<Map<String, Object>> getAllCategories();
}
