package com.practice.springjdbc.dao;

import com.practice.springjdbc.model.Category;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface CategoryDao {
    List<Category> findAll();

    Category findById(int id);

    Category create(Category category);

    Category update (Category category);

    void deleteById(int id);
}
