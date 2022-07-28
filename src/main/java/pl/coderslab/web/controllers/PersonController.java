package pl.coderslab.web.controllers;


import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.persistence.dao.PersonDao;
import pl.coderslab.persistence.entities.Person;
import pl.coderslab.web.dtos.PersonDto;

@Controller
@RequestMapping("/persons")
public class PersonController {

    public static final Logger log = LoggerFactory.logger(PersonController.class);

    private PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personDao.delete(personDao.find(id));
    }

    @PostMapping("")
    public void persist(@RequestBody Person person) {
        personDao.persist(person);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Person person) {
        if (!person.getId().equals(id)) {
            throw new IllegalArgumentException();
        }
        personDao.update(person);
    }

    @GetMapping("/{id}")
    public PersonDto getById(@PathVariable Long id) {
        return PersonDto.from(personDao.find(id));
    }

    @GetMapping("/form")
    public String formShow(Model model){
        model.addAttribute("person", new Person());
        return "/form/person.jsp";
    }

    @PostMapping("/form")
    public String formResetPerform(Person person){
        personDao.persist(person);
        return "/form/person.jsp";
    }

//Dodaj widok formularza zawierający pola login oraz password, email.

}
