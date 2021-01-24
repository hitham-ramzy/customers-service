package com.jumia.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
