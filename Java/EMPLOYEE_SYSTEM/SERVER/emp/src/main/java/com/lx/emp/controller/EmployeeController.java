package com.lx.emp.controller;

import com.github.pagehelper.PageInfo;
import com.lx.emp.pojo.Employee;
import com.lx.emp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public PageInfo list(@RequestParam int page,
                               @RequestParam int size,
                               @RequestParam(required = false) String name,
                               @RequestParam(required = false) String no,
                               @RequestParam(required = false) String deptId){
        if(name == null){
            name = "";
        }
        if(no == null){
            no = "";
        }
        if(deptId == null){
            deptId = "";
        }
        return employeeService.findAll(page,size,name,no,deptId);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/remove/{id}")
    public boolean remove(@PathVariable Integer id){
        return employeeService.remove(id);
    }

    @PutMapping("/update")
    public boolean update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @GetMapping("/get/{empNo}")
    public Employee getOne(@PathVariable String empNo){
        return employeeService.findByNO(empNo);
    }

}
