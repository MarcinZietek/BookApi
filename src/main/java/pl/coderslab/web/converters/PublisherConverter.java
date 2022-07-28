package pl.coderslab.web.converters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import pl.coderslab.persistence.dao.PublisherDao;
import pl.coderslab.persistence.entities.Publisher;


public class PublisherConverter implements Converter<String, Publisher> {

    private final PublisherDao publisherDao;

    public PublisherConverter(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @Override
    public Publisher convert(String source) {
        return publisherDao.find(Long.parseLong(source));
    }
}
