package springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request, Model model){

        //Parameter ma klucz "name"
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        //System.out.println("Good morning, "+ name+ " "+ surname);
        model.addAttribute("message", "Good morning, "+ name+ " "+ surname);
        return "first/hello";
    }

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
        return "first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
}
