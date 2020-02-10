package com.lx.parkms.controller;

import com.lx.parkms.entity.Admin;
import com.lx.parkms.service.AdminService;
import com.lx.parkms.service.PermissionService;
import com.lx.parkms.vo.AdminVO;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping("/operator")
    public List<Admin> getOperators(){
        return adminService.findOperatorAll();
    }

    @GetMapping("/admin")
    public List<Admin> getAdmins(){
        return adminService.findAdminAll();
    }

    @PostMapping("/admin")
    public Admin add(@RequestBody Admin admin){
        return adminService.save(admin);
    }

    @PutMapping("/admin")
    public Admin update(@RequestBody Admin admin){
        return adminService.save(admin);
    }

    @GetMapping("/admin/{id}")
    public Admin getOne(@PathVariable int id){
        return adminService.getOne(id);
    }

    @DeleteMapping("/admin/{id}")
    public Admin remove(@PathVariable Integer id){
        Admin admin = adminService.getOne(id);
        adminService.remove(id);
        return admin;
    }

    @PostMapping("/login")
    public AdminVO login(@RequestBody Admin form){
        AdminVO adminVO = new AdminVO();
        Admin admin = adminService.login(form.getAdminName(),form.getAdminPassword());
        if(admin == null){
            return null;
        }else{
            BeanUtils.copyProperties(admin,adminVO);
            adminVO.setPermissionNames(permissionService.findByPermissionType(admin.getAdminType()));
            return adminVO;
        }

    }
}
