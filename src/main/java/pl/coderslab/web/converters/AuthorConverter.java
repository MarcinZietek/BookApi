package pl.coderslab.web.converters;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.persistence.dao.AuthorDao;
import pl.coderslab.persistence.entities.Author;

public class AuthorConverter implements Converter<String[], List<Author>> {

    private final AuthorDao authorDao;

    public AuthorConverter(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @Override
    public List<Author> convert(String[] source) {
        return Arrays.asList(source).stream().map(this::convertOne).collect(Collectors.toList());
    }


    public Author convertOne(String source) {
        return authorDao.find(Long.parseLong(source));
    }
}
