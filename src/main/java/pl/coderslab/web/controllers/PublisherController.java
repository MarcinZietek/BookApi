package pl.coderslab.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.persistence.dao.PublisherDao;
import pl.coderslab.persistence.entities.Publisher;
import pl.coderslab.web.converters.PublisherDtoConverter;
import pl.coderslab.web.dtos.PublisherDto;

@RestController
@RequestMapping("/publishers")
public class PublisherController {


    private final PublisherDao publisherDao;
    private final PublisherDtoConverter publisherDtoConverter;

    public PublisherController(PublisherDao publisherDao,
                               PublisherDtoConverter publisherDtoConverter) {
        this.publisherDao = publisherDao;
        this.publisherDtoConverter = publisherDtoConverter;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherDao.delete(publisherDao.find(id));
    }

    @PostMapping("")
    public void persist(@RequestBody Publisher publisher) {
        publisherDao.persist(publisher);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Publisher publisher) {
        if (!publisher.getId().equals(id)) {
            throw new IllegalArgumentException();
        }
        publisherDao.update(publisher);
    }

    @GetMapping("/{id}")
    public PublisherDto getById(@PathVariable Long id) {
        return publisherDtoConverter.convertToPresentation(publisherDao.find(id));
    }

}
