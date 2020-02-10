package com.lx.dao;

import com.lx.domain.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

public class ICategoryDaoTest extends IDaoTest {

    private ICategoryDao categoryDao;

    @Before
    public void before(){
        categoryDao = session.getMapper(ICategoryDao.class);
    }

    @Test
    public void getAll() {
        List<Category> categories = categoryDao.getAll();
        for (Category c :
                categories) {
            System.out.println(c);
        }
    }

    @Test
    public void getByName() {
        System.out.println(categoryDao.getByName("编程语言").getBooks());
    }
    @Test
    public void add() {
        Category category = new Category();
        category.setName("新类别");
        categoryDao.add(category);
    }
    @Test
    public void remove() {
        Category category = categoryDao.getByName("新类别");
        categoryDao.remove(category.getId());
    }

    @Test
    public void getByID(){
        System.out.println(categoryDao.getByID(1));
    }
}