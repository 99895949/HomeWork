package com.lx.controller;

import com.lx.domain.Reader;
import com.lx.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("reader")
@CrossOrigin
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping("")
    public ResponseEntity getAll(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("data",readerService.getAll());
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody  Reader reader){
        HashMap<String,Object> map = new HashMap<String, Object>();
        readerService.add(reader);
        map.put("msg","添加成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable int id){
        HashMap<String,Object> map = new HashMap<String, Object>();
        readerService.remove(id);
        map.put("msg","删除成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Reader form) {
        String msg = "修改成功";
        Map<String, Object> data = new HashMap<String, Object>();
        readerService.update(form);
        data.put("msg", msg);
        return new ResponseEntity(data, HttpStatus.OK);
    }

}
