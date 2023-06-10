package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @RequestMapping()
    public String showPage() {
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam String[] condiment, Model model) {
        if (condiment.length == 0) {
            model.addAttribute("msg", "Chưa chọn gia vị nào");
        } else {
            model.addAttribute("list", condiment);
        }
        return "show";
    }
}
