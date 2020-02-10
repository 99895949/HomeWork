package com.lx.parkms.service;

import com.lx.parkms.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> findOperatorAll();
    List<Admin> findAdminAll();
    List<Admin> findAll();

    Admin login(String admin_name,String admin_password);

    Admin save(Admin admin);

    void remove(Integer id);

    Admin getOne(Integer id);


}
