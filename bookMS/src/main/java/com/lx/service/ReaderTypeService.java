package com.lx.service;

import com.lx.dao.IReaderTypeDao;
import com.lx.domain.ReaderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderTypeService {

    @Autowired
    private IReaderTypeDao readerTypeDao;

    public void add(ReaderType readerType){
        readerTypeDao.add(readerType);
    }

    public void remove(Integer id){
        readerTypeDao.remove(id);
    }

    public void update(ReaderType readerType){
        readerTypeDao.update(readerType);
    }

    public List<ReaderType> getAll(){
        return readerTypeDao.getAll();
    }
}
