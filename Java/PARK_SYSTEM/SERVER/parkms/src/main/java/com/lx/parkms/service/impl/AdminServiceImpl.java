package com.lx.parkms.service.impl;

import com.lx.parkms.entity.Admin;
import com.lx.parkms.entity.enums.AdminTypeEnum;
import com.lx.parkms.repository.AdminRepository;
import com.lx.parkms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Admin> findOperatorAll() {
        return adminRepository.findByAdminType(AdminTypeEnum.OPERATOR.getCode());
    }

    @Override
    public List<Admin> findAdminAll() {
        return adminRepository.findByAdminType(AdminTypeEnum.ADMIN.getCode());
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin login(String admin_name, String admin_password) {
        return adminRepository.findByAdminNameAndAdminPassword(admin_name,admin_password);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public void remove(Integer id) {
        adminRepository.deleteById(id);
    }

    @Override
    public Admin getOne(Integer id) {
        return adminRepository.getOne(id);
    }
}
