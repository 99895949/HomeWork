package com.lx.parkms.repository;

import com.lx.parkms.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

    List<Admin> findByAdminType(Integer type);

    Admin findByAdminNameAndAdminPassword(String admin_name,String admin_password);
}
