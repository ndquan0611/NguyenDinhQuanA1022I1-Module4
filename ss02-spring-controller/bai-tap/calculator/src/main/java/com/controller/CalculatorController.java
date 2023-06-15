package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @RequestMapping()
    public String showPage() {
        return "index";
    }

    @PostMapping("/calculator")
    public String calculator(@RequestParam(value = "inputE1") double input1, @RequestParam(value = "inputE2") double input2, @RequestParam String calculator, Model model) {
        Double result = null;
        switch (calculator) {
            case "Addition(+)":
                result = input1 + input2;
                break;
            case "Subtraction(-)":
                result = input1 - input2;
                break;
            case "Multiplication(X)":
                result = input1 * input2;
                break;
            case "Division(/)":
                result = input1 / input2;
                break;
        }

        model.addAttribute("input1", input1);
        model.addAttribute("input2", input2);
        model.addAttribute("result", result);
        return "index";
    }
}
