package pl.coderslab.web.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.persistence.dao.AuthorDao;
import pl.coderslab.persistence.dao.BookDao;
import pl.coderslab.persistence.dao.PublisherDao;
import pl.coderslab.persistence.entities.Author;
import pl.coderslab.persistence.entities.Book;
import pl.coderslab.persistence.entities.Person;
import pl.coderslab.persistence.entities.Publisher;
import pl.coderslab.web.converters.BookDtoConverter;
import pl.coderslab.web.dtos.BookDto;

@Controller
@RequestMapping("/books1")
public class BookFormController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookDtoConverter bookDtoConverter;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao,
                              BookDtoConverter bookDtoConverter) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookDtoConverter = bookDtoConverter;
    }

    @GetMapping("/form")
    public String formShow(Model model){
        model.addAttribute("book", bookDtoConverter.convertToPresentation(new Book()));
        return "/form/book.jsp";
    }

    @PostMapping("/form")
    public String formResetPerform(BookDto bookDto, Model model){
        Book book = bookDtoConverter.convertToModel(bookDto);
        bookDao.persist(book);
        model.addAttribute("books", bookDao.findAll());
        return "/form/books.jsp";
    }

    @GetMapping("/form/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        Book book = bookDao.find(id);
        model.addAttribute("book", bookDtoConverter.convertToPresentation(book));
        return "/form/bookedit.jsp";
    }

    @PostMapping("/form/edit")
    public String editBook(BookDto bookDto, Model model) {
         Book persisted = bookDao.find(bookDto.getId());
         Book requested = bookDtoConverter.convertToModel(bookDto);
         persisted.setAuthors(requested.getAuthors());
         persisted.setPublisher(requested.getPublisher());
         persisted.setRating(requested.getRating());
         persisted.setTitle(requested.getTitle());
         persisted.setDescription(requested.getDescription());
         bookDao.update(persisted);
         return showBooks(model);
    }

    @GetMapping("/form/delete/{id}")
    public String getDeleteForm(@PathVariable Long id, Model model) {
        Book book = bookDao.find(id);
        model.addAttribute("book", bookDtoConverter.convertToPresentation(book));
        return "/form/bookdelete.jsp";
    }

    @PostMapping("/form/delete")
    public String deleteBook(BookDto bookDto, Model model) {
        Book book = bookDao.find(bookDto.getId());
        bookDao.delete(book);
        return showBooks(model);
    }

    @GetMapping("")
    public String showBooks(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "/form/books.jsp";
    }

    @ModelAttribute("availablePublishers")
    List<Publisher> availablePublishers() {
        return publisherDao.findAll();
    }

    @ModelAttribute("availableAuthors")
    List<Author> availableAuthors() {
        return authorDao.findAll();
    }

}
