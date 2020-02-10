package com.lx.controller;

import com.lx.domain.ReaderType;
import com.lx.service.ReaderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("readertype")
@RestController
@CrossOrigin
public class ReaderTypeController {

    @Autowired
    private ReaderTypeService readerTypeService;

    @GetMapping("")
    public ResponseEntity getAll(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("data",readerTypeService.getAll());
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody ReaderType reader){
        HashMap<String,Object> map = new HashMap<String, Object>();
        readerTypeService.add(reader);
        map.put("msg","添加成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable int id){
        HashMap<String,Object> map = new HashMap<String, Object>();
        readerTypeService.remove(id);
        map.put("msg","删除成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody ReaderType form) {
        String msg = "修改成功";
        Map<String, Object> data = new HashMap<String, Object>();
        readerTypeService.update(form);
        data.put("msg", msg);
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
