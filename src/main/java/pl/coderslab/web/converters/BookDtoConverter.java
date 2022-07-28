package pl.coderslab.web.converters;

import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import pl.coderslab.persistence.dao.AuthorDao;
import pl.coderslab.persistence.entities.Author;
import pl.coderslab.persistence.entities.Book;
import pl.coderslab.web.dtos.BookDto;
import pl.coderslab.web.dtos.PublisherDto;

@Component
public class BookDtoConverter {

    private final PublisherDtoConverter publisherDtoConverter;
    private final AuthorDao authorDao;

    public BookDtoConverter(PublisherDtoConverter publisherDtoConverter, AuthorDao authorDao) {
        this.publisherDtoConverter = publisherDtoConverter;
        this.authorDao = authorDao;
    }

    public Book convertToModel(BookDto dto) {
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setRating(dto.getRating());
        book.setDescription(dto.getDescription());
        book.setPublisher(publisherDtoConverter.convertToModel(dto.getPublisher()));
        book.setAuthors(dto.getAuthors().stream().map(id -> authorDao.find(Long.valueOf(id))).collect(Collectors.toList()));
        return book;
    }

    public BookDto convertToPresentation(Book book) {
        return new BookDto(
            book.getId(),
            book.getTitle(),
            book.getRating(),
            book.getDescription(),
            publisherDtoConverter.convertToPresentation(
                book.getPublisher()),
            book.getAuthors()
                .stream()
                .map(Author::getId)
                .map(id -> id.toString())
                .collect(Collectors.toList())
        );
    }

}
