package com.controller;

import com.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MailController {
    @ModelAttribute("languages")
    public String[] getLanguages() {
        return new String[]{"English", "Vietnamese", "Japanese", "Chinese"};
    }

    @ModelAttribute("size")
    public int[] getSize() {
        return new int[]{5, 10, 15, 20, 25};
    }

    @GetMapping("/update")
    public String showCreate(Model model) {
        model.addAttribute("email", new Email());
        return "update";
    }

    @PostMapping("/update")
    public String doCreate(@ModelAttribute("email") Email email, Model model) {
        model.addAttribute("email", email);
        return "index";
    }
}
