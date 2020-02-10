package com.lx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageContoller {

    @RequestMapping("page/{route}")
    public ModelAndView route(@PathVariable String route){
        ModelAndView mv = new ModelAndView();
        if(route.equals("admin")){
        }else if(route.equals("all_book")){
        }
        mv.setViewName(route);
        return mv;
    }
}
