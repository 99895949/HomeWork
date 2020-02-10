package com.lx.service;

import com.lx.dao.ICategoryDao;
import com.lx.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private ICategoryDao categoryDao;

    public void add(Category category){
        categoryDao.add(category);
    }

    public void remove(Integer id){
        categoryDao.remove(id);
    }

    public void update(Category category){
        categoryDao.update(category);
    }

    public List<Category> getAll(){
        return categoryDao.getAll();
    }
}
