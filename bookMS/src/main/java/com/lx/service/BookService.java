package com.lx.service;

import com.lx.dao.IBookDao;
import com.lx.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private IBookDao bookDao;

    public void add(Book book) {
        bookDao.add(book);
    }

    public void remove(Integer id) {
        bookDao.remove(id);
    }

    public void update(Book book) {
        bookDao.update(book);
    }

    public List<Book> getAll() {
        return bookDao.getAll();
    }

    public List<Book> getBookByName(String name) {
        return bookDao.getBookByName(name);
    }

    public List<Book> getBookByAuthor(String author) {
        return bookDao.getBookByAuthor(author);
    }

    public List<Book> getBookByISBN(String isbn) {
        List<Book> list = new ArrayList();
        list.add(bookDao.getBookByIsbn(isbn));
        return list;
    }

}
