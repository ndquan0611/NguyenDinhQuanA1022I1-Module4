package com.controller;

import com.model.Music;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MusicController {
    @ModelAttribute("type")
    public String[] getType() {
        return new String[]{"Tru tinh", "Soi dong", "Nhe nhang"};
    }

    @GetMapping("/upload")
    public String showUpload(Model model) {
        model.addAttribute("music", new Music());
        return "upload";
    }

    @PostMapping("/upload")
    public ModelAndView doUpload(@ModelAttribute Music music) {
        ModelAndView modelAndView = new ModelAndView("index", "music", music);

        return modelAndView;
    }
}
