package com.lx.controller;

import com.lx.domain.Admin;
import com.lx.service.AdminService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public ResponseEntity login(HttpServletRequest request,Admin form) {
        String nickname = form.getNickname();
        String password = form.getPassword();
        Admin admin = adminService.login(nickname,password);
        String msg = "登录成功";
        if (admin != null) {
            request.getSession().setAttribute("admin", admin);
        } else {
            msg = "用户名或密码错误";
        }
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("flag", admin != null);
        data.put("msg", msg);
        data.put("admin",admin);
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Admin form) {
        String msg = "修改成功";
        Map<String, Object> data = new HashMap<String, Object>();
        adminService.update(form);
        data.put("msg", msg);
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity add(@RequestBody Admin admin) {
        Map<String, Object> data = new HashMap<String, Object>();
        adminService.add(admin);
        data.put("msg", "添加成功");
        return new ResponseEntity(data, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable Integer id) {
        String msg = "删除成功";
        Map<String, Object> data = new HashMap<String, Object>();
        adminService.remove(id);
        data.put("msg", msg);
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity getAll() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("data", adminService.getAll());
        return new ResponseEntity(data, HttpStatus.OK);
    }

}
