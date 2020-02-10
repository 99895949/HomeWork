package com.lx.parkms.repository;

import com.lx.parkms.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRespository extends JpaRepository<Permission,Integer> {

    List<Permission> findAllByPermissionType(Integer type);

}
