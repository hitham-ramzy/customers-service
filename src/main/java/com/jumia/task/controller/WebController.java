package com.jumia.task.controller;

import com.jumia.task.resource.CustomerResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    private final CustomerResource customerResource;

    public WebController(CustomerResource customerResource) {
        this.customerResource = customerResource;
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        return "index";
    }
}
