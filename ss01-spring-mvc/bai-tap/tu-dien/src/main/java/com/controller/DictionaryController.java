package com.controller;

import com.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping
    public String showPage() {
        return "index";
    }

    @GetMapping("/dictionary")
    public String showDictionary() {
        return "dictionary";
    }


    @PostMapping("/dictionary")
    public String dictionary(@RequestParam String english, Model model) {
        String result = dictionaryService.result(english);
        model.addAttribute("result", result);
        model.addAttribute("english", english);
        return "index";
    }
}
