package pl.coderslab.web.controllers;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.web.dtos.Student;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/new")
    public String getForm(Model model) {
        model.addAttribute("student", new Student());
        return "/form/student.jsp";
    }

    @PostMapping("")
    public String doNothing(Student student) {
        System.out.println(student.toString());
        return "/form/student.jsp";
    }

    @ModelAttribute("availableGenders")
    public List<String> genders() {
        return Arrays.asList("mezczyzna", "kobieta", "niebinarny");
    }

    @ModelAttribute("availableCountries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("availableHobbies")
    public List<String> hobbies() {
        return Arrays.asList(
            "numizmatyka",
            "zbieranie starych kocy wojskowych",
            "strzelectwo",
            "fotografia"
        );
    }

    @ModelAttribute("availableProgrammingSkills")
    public List<String> programmingSkills() {
        return Arrays.asList(
            "dżawa",
            "eqkuel",
            "pajton",
            "dżawa w wersji skrypt"
        );
    }

}
