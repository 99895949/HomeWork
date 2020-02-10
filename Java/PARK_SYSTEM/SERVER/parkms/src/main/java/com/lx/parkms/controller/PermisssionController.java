package com.lx.parkms.controller;

import com.lx.parkms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class PermisssionController {

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/permissionname")
    public List<String> getAllPermissionNames(){
        return  permissionService.findAll().stream().distinct().collect(Collectors.toList());
    }
}
