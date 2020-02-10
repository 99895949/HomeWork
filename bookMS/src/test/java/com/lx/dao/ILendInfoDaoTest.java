package com.lx.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ILendInfoDaoTest extends IDaoTest {
    private IBookDao bookDao;
    private IReaderDao readerDao;
    private IReaderTypeDao readerTypeDao;

    @Before
    public void before(){
        bookDao = session.getMapper(IBookDao.class);
        readerDao = session.getMapper(IReaderDao.class);
        readerTypeDao = session.getMapper(IReaderTypeDao.class);
    }


    @Test
    public void remove() {
    }

    @Test
    public void update() {
    }

    @Test
    public void getAll() {
    }

    @Test
    public void getByReaderName() {
    }

    @Test
    public void getByBookName() {
    }
}