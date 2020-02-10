package com.lx.dao;

import com.lx.domain.Reader;
import com.lx.domain.ReaderType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IReaderDaoTest extends IDaoTest {
    private  IReaderDao readerDao;

    @Before
    public void before(){
        readerDao = session.getMapper( IReaderDao.class);
    }

    @Test
    public void add() {
        Reader reader = new Reader();
        reader.setEmail("zhangsan@126.com");
        reader.setAddress("河北唐山");
        reader.setGender("男");
        reader.setIdCard("123456");
        reader.setNickname("zhangsan");
        reader.setPassword("123");
        reader.setRealname("张三");
        reader.setType(1);
        readerDao.add(reader);
    }

    @Test
    public void remove() {
        readerDao.remove(readerDao.getReader("zhangsan").getId());
    }

    @Test
    public void update() {
        Reader reader = readerDao.getReader("zhangsan");
        reader.setRealname("李四");
        readerDao.update(reader);
    }

    @Test
    public void getReader() {
        System.out.println(readerDao.getReader("zhangsan"));
    }

    @Test
    public void getAll() {
        List<Reader> readers = readerDao.getAll();
        for (Reader reader :
                readers) {
            System.out.println(reader);
        }
    }

    @Test
    public void getReadersByType() {
        List<Reader> readers = readerDao.getReadersByType(1);
        for (Reader r :
                readers) {
            System.out.println(r);
        }
    }
}