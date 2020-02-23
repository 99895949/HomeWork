package com.lx.emp.controller;

import com.lx.emp.pojo.Admin;
import com.lx.emp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Admin login(@RequestBody Admin form){
        Admin admin = adminService.getByName(form.getAdminName());
        if(admin != null){
            if(form.getAdminPassword().equals(admin.getAdminPassword())){
                return admin;
            }
            return null;
        }
        return null;
    }

    @PostMapping("/changePass")
    public Boolean changePassword( @RequestBody Admin admin){
        return adminService.changePassword(admin.getAdminName(),admin.getAdminPassword());
    }
}
