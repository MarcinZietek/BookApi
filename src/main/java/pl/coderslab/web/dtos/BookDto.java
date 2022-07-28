package pl.coderslab.web.dtos;

import java.util.List;

public class BookDto {

    private Long id;
    private String title;
    private Integer rating;
    private String description;
    private PublisherDto publisher;
    private List<String> authors;

    public BookDto() {
    }

    public BookDto(Long id, String title, Integer rating, String description, PublisherDto publisher,
                   List<String> authors) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.description = description;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PublisherDto getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherDto publisher) {
        this.publisher = publisher;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
