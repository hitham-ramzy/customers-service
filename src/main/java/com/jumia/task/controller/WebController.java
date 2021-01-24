package com.jumia.task.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Web controller.
 */
@Controller
public class WebController {

    /**
     * Home string.
     * redirects to the index page
     *
     * @return the string
     */
    @RequestMapping(value = "/")
    public String home() {
        return "redirect:/index";
    }

    /**
     * Index string.
     *
     * @return the string
     */
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }
}
