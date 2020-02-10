package com.lx.dao;

import com.lx.domain.Book;
import com.lx.domain.Category;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class IBookDaoTest extends IDaoTest {
    private IBookDao bookDao;
    private ICategoryDao categoryDao;

    @Before
    public void before(){
        bookDao = session.getMapper(IBookDao.class);
        categoryDao = session.getMapper(ICategoryDao.class);
    }

    @Test
    public void add() {
        Book book = new Book();
        book.setName("Java从入门到精通");
        book.setPrice(22.3);
        book.setAuthor("张志祥");
        book.setBuyTime(new Date());
        book.setDescription("这是一本Java入门书籍");
        book.setImagePath("D:/1.png");
        book.setIsbn("222");
        Category category = categoryDao.getByID(1);
        book.setCategoryID(category.getId());
        bookDao.add(book);
    }

    @Test
    public void remove() {
        int id = bookDao.getBookByIsbn("222").getId();
        bookDao.remove(id);
    }

    @Test
    public void update() {
        Book book = bookDao.getBookById(2);
        book.setIsbn("2222222222");
        book.setPrice(55.6);
        book.setBuyTime(new Date());
        book.setAuthor("张飞");
        bookDao.update(book);
    }

    @Test
    public void getBookById() {
        System.out.println(bookDao.getBookById(1));
    }

    @Test
    public void getAll() {
        List<Book> books = bookDao.getAll();
        for (Book book :
                books) {
            System.out.println(book);
        }
    }

    @Test
    public void getBookByIsbn() {
        System.out.println(bookDao.getBookByIsbn("1"));
    }

    @Test
    public void getBookByCategoryID(){
        List<Book> books = bookDao.getBookByCategoryID(1);
        for (Book book :
                books) {
            System.out.println(book);
        }
    }
}