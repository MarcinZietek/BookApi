package pl.coderslab.web.converters;

import org.springframework.stereotype.Component;
import pl.coderslab.persistence.entities.Book;
import pl.coderslab.persistence.entities.Publisher;
import pl.coderslab.web.dtos.BookDto;
import pl.coderslab.web.dtos.PublisherDto;

@Component
public class PublisherDtoConverter {
    public Publisher convertToModel(PublisherDto dto) {
        Publisher publisher = new Publisher();
        publisher.setName(dto.getName());
        publisher.setId(dto.getId());
        return publisher;
    }

    public PublisherDto convertToPresentation(Publisher publisher) {
        if (publisher == null) {
            return null;
        }
        return new PublisherDto(publisher.getId(), publisher.getName());
    }

}
