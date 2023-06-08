package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

@Controller
public class ConvertController {
    @RequestMapping(value = "/convert")
    public String convert(Model model) {

        return "display";
    }
}
