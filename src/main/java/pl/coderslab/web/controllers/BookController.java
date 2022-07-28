package pl.coderslab.web.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.persistence.dao.AuthorDao;
import pl.coderslab.persistence.dao.BookDao;
import pl.coderslab.persistence.dao.PublisherDao;
import pl.coderslab.persistence.entities.Author;
import pl.coderslab.persistence.entities.Book;
import pl.coderslab.persistence.entities.Publisher;
import pl.coderslab.web.converters.BookDtoConverter;
import pl.coderslab.web.dtos.BookDto;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;
    private final BookDtoConverter bookDtoConverter;

    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao,
                          BookDtoConverter bookDtoConverter) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
        this.bookDtoConverter = bookDtoConverter;
    }

    @GetMapping("")
    public List<BookDto> findAll() {
        return bookDao.findAll().stream().map(bookDtoConverter::convertToPresentation).collect(Collectors.toList());
    }

    @GetMapping("/findByRating/{rating}")
    public List<BookDto> findByRating(@PathVariable int rating) {
        return bookDao.findAllByRating(rating).stream().map(bookDtoConverter::convertToPresentation).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        bookDao.delete(bookDao.find(id));
    }

    @PostMapping("")
    public void persist(@RequestBody Book book) {
        bookDao.persist(book);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Book book) {
        if (!book.getId().equals(id)) {
            throw new IllegalArgumentException();
        }
        bookDao.update(book);
    }

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable Long id) {
        return bookDtoConverter.convertToPresentation(bookDao.find(id));
    }

    @PostMapping("/books/test")
    public void persistTestData() {
        Publisher publisher = new Publisher();
        publisher.setName("abc");
        publisherDao.persist(publisher);

        List<Author> authorsToAdd = Arrays.asList(authorDao.find(-1L), authorDao.find(-2L));
        Book newBook = new Book();
        newBook.setTitle("Kwantechizm czyli klatka na ludzi");
        newBook.setDescription("Ksiażka popularnonaukowa o fizyce kwantowej");
        newBook.setRating(5);
        newBook.setPublisher(publisher);
        newBook.getAuthors().addAll(authorsToAdd);
        bookDao.persist(newBook);
    }

}
