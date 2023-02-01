package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String showForm() {
        return "home";
    }

    @PostMapping("result")
    public String resultCalculator(@RequestParam("number1") double number1, @RequestParam("number2") double number2, @RequestParam("calculation") String calculation, Model model) {

        double result = 0;
        String message = " Can't divide";
        switch (calculation) {
            case "add(+)":
                result = number1 + number2;
                break;
            case "sub(-)":
                result = number1 - number2;
                break;
            case "multi(*)":
                result = number1 * number2;
                break;
            case "div(/)":
                if (number2 == 0) {
                    model.addAttribute("message", message);
                    return "home";
                }
                result = number1 / number2;
                break;
        }
        model.addAttribute("resultName", result);
        return "home";

    }
}
