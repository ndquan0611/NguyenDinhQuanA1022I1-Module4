package com.controller;

import com.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MedicalDeclarationController {
    @RequestMapping()
    public ModelAndView showPage() {
        ModelAndView modelAndView = new ModelAndView("form", "medicalDeclaration", new MedicalDeclaration());
        modelAndView.addObject("yearOfBirth", new int[]{1996, 1997, 1998, 1999, 2001, 2002, 2003, 2004, 2005});
        modelAndView.addObject("nationality", new String[]{"Việt Nam", "Anh Quốc", "Hoa Kỳ", "Nhật Bản", "Hàn Q uốc"});
        modelAndView.addObject("transportVehicle", new String[]{"Tàu bay", "Tàu thuyền", "Ô tô", "Khác (Ghi rõ)"});
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView showDetail(@ModelAttribute MedicalDeclaration medicalDeclaration) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("medicalDeclaration", medicalDeclaration);
        return modelAndView;
    }
}