package fi.heusala.handlinglists2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import fi.heusala.handlinglists2.domain.Student;

@Controller
public class StudentController {

    @GetMapping("hello")
    public String showMessage(@RequestParam String firstName, @RequestParam String lastName, Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "hello";
    }

    @RequestMapping("/studentlist")
    public String hello(Model model) {
        System.out.println("Students:");

        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe"));
        students.add(new Student("Jane", "Doe"));
        students.add(new Student("John", "Smith"));

        model.addAttribute("Student", students);

        return "studentlist";
    }
}
