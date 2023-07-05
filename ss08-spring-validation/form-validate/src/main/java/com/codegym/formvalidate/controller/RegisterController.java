package com.codegym.formvalidate.controller;

import com.codegym.formvalidate.dto.RegisterDto;
import com.codegym.formvalidate.model.Register;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @GetMapping("")
    public String showPage(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "index";
    }

    @PostMapping("/register")
    public String doRegister(
            @Valid
            @ModelAttribute RegisterDto registerDto,
            BindingResult bindingResult
    ) {
        new RegisterDto().validate(registerDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "index";
        }
        Register register = new Register();
        BeanUtils.copyProperties(registerDto, register);
        return "result";
    }
}
