package com.lx.dao;

import com.lx.domain.Admin;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IAdminDaoTest extends IDaoTest {

    private IAdminDao adminDao;

    @Before
    public void before(){
        adminDao = session.getMapper(IAdminDao.class);
    }

    @Test
    public void getAdmin() {
        Admin admin = adminDao.getAdmin("root","root");
        System.out.println(admin);
    }

    @Test
    public void getAll() {
        List<Admin> admins = adminDao.getAll();
        for (Admin admin :
                admins) {
            System.out.println(admin);
        }
    }

    @Test
    public void update() {
        Admin admin = adminDao.getAdmin("root","root");
        admin.setPassword("admin");
        admin.setNickname("admin");
        admin.setTelephone("123");
        adminDao.update(admin);

    }
    @Test
    public void add() {
        Admin admin = new Admin();
        admin.setPassword("root1");
        admin.setNickname("root1");
        admin.setTelephone("1234");
        adminDao.add(admin);

    }
    @Test
    public void remove() {
        adminDao.remove(2);

    }
}