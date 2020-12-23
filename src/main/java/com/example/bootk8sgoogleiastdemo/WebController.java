package com.example.bootk8sgoogleiastdemo;

import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "")
public class WebController {

    @GetMapping("")
    public ModelAndView index() {
        val modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @GetMapping("testpage")
    public ModelAndView testpage(@RequestParam(required = false) String inputtext) {
        val modelAndView = new ModelAndView("testpage");
        modelAndView.addObject("inputtext", inputtext);
        return modelAndView;
    }
}
