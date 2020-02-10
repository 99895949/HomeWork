package com.lx.service;

import com.lx.dao.IAdminDao;
import com.lx.domain.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private IAdminDao adminDao;

    public Admin login(String nickname,String password){
        Admin admin = null;
        try{
            admin = adminDao.getAdmin(nickname,password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return admin;
    }

    public void update(Admin admin){
        adminDao.update(admin);
    }

    public List<Admin> getAll(){
        return adminDao.getAll();
    }
    public void add(Admin admin){
        adminDao.add(admin);
    }
    public void remove(Integer id){
        adminDao.remove(id);
    }
}
