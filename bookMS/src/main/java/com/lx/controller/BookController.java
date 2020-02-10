package com.lx.controller;

import com.lx.domain.Book;
import com.lx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("book")
@CrossOrigin
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ResponseEntity getAll(){
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("data",bookService.getAll());
        return new ResponseEntity(map, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity add(@RequestBody Book form){
        HashMap<String,Object> map = new HashMap<String, Object>();
        bookService.add(form);
        map.put("msg","添加成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity remove(@PathVariable int id){
        HashMap<String,Object> map = new HashMap<String, Object>();
        bookService.remove(id);
        map.put("msg","删除成功");
        return new ResponseEntity(map,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Book form) {
        //
        System.out.println(form.getBuyTime());
        String msg = "修改成功";
        Map<String, Object> data = new HashMap<String, Object>();
        bookService.update(form);
        data.put("msg", msg);
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping()
    public List<Book> getBookByName(@RequestParam String name){
        return bookService.getBookByName(name);
    }

    @GetMapping()
    public List<Book> getBookByAuthor(@RequestParam String author){
        return bookService.getBookByAuthor(author);
    }

    @GetMapping()
    public List<Book> getBookByISBN(@RequestParam String isbn){
        return bookService.getBookByISBN(isbn);
    }
}
