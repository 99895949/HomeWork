package com.lx.parkms.service;

import java.util.List;

public interface PermissionService {

    List<String> findByPermissionType(Integer type);

    List<String> findAll();
}
