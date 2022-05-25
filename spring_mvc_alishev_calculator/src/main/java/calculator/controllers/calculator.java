package calculator.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class calculator {

    @GetMapping("/calculator")
    public String sum(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("action") String action, Model model ){

        double result;

        switch (action){
            case "sum":
                result = a+b;
                break;
            case "subtraction":
                result = a-b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("result",  ""+result);
        return "/sum";
    }
}
