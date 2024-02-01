package fi.heusala.hellospring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @RequestMapping("/index")
    public String greeting(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {

        return "hello";
    }
}
