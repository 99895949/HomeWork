package com.lx.controller;

import com.lx.domain.Category;
import com.lx.domain.ReaderType;
import com.lx.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity getAll(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("data",categoryService.getAll());
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Category form){
        HashMap<String,Object> map = new HashMap<String, Object>();
        categoryService.add(form);
        map.put("msg","添加成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable int id){
        HashMap<String,Object> map = new HashMap<String, Object>();
        categoryService.remove(id);
        map.put("msg","删除成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Category form) {
        String msg = "修改成功";
        Map<String, Object> data = new HashMap<String, Object>();
        categoryService.update(form);
        data.put("msg", msg);
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
