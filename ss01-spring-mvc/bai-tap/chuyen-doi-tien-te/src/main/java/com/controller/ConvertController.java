package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping()
    public String showPage() {
        return "index";
    }

    @GetMapping("/convert")
    public String showConvert() {
        return "convert";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam String usd, Model model) {
        double result = Integer.parseInt(usd) * 23000;
        model.addAttribute("result", result);
        model.addAttribute("usd", usd);
        return "index";
    }
}
