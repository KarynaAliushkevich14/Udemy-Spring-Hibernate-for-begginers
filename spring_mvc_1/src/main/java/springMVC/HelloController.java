package springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hellomvc")
    public String sayHello(){
        return "helloView";
    }
}
