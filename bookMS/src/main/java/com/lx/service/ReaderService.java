package com.lx.service;

import com.lx.dao.IReaderDao;
import com.lx.domain.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderService {

    @Autowired
    private IReaderDao readerDao;

    public List<Reader> getAll(){
        return readerDao.getAll();
    }

    public void add(Reader reader){
        readerDao.add(reader);
    }

    public void update(Reader reader){
        readerDao.update(reader);
    }
    public void remove(Integer id){
        readerDao.remove(id);
    }

}
