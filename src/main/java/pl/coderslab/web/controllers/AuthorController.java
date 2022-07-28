package pl.coderslab.web.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.persistence.dao.AuthorDao;
import pl.coderslab.persistence.entities.Author;
import pl.coderslab.web.dtos.AuthorDto;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        authorDao.delete(authorDao.find(id));
    }

    @PostMapping("")
    public void persist(@RequestBody Author author) {
        authorDao.persist(author);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Author author) {
        if (!author.getId().equals(id)) {
            throw new IllegalArgumentException();
        }
        authorDao.update(author);
    }

    @GetMapping("/{id}")
    public AuthorDto getById(@PathVariable Long id) {
        return AuthorDto.from(authorDao.find(id));
    }
}
