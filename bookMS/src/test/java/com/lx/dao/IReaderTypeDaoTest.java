package com.lx.dao;

import com.lx.domain.ReaderType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class IReaderTypeDaoTest extends IDaoTest {

    private IReaderTypeDao readerTypeDao;

    @Before
    public void before(){
        readerTypeDao = session.getMapper(IReaderTypeDao.class);
    }

    @Test
    public void add() {
        ReaderType readerType = new ReaderType();
        readerType.setName("至尊VIP");
        readerType.setBorrowTime(20);
        readerTypeDao.add(readerType);
    }

    @Test
    public void remove() {
        readerTypeDao.remove(4);
    }

    @Test
    public void update() {
        ReaderType readerType = readerTypeDao.getReaderTypeByID(4);
        readerType.setName("super读者");
        readerTypeDao.update(readerType);
    }

    @Test
    public void getReaderTypeByID() {
        System.out.println(readerTypeDao.getReaderTypeByID(2));
    }

    @Test
    public void getAll() {
        List<ReaderType> readerTypes = readerTypeDao.getAll();
        for (ReaderType readerType :
                readerTypes) {
            System.out.println(readerType.getReaders());
        }
    }
}