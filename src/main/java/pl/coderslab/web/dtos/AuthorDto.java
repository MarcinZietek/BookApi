package pl.coderslab.web.dtos;

import pl.coderslab.persistence.entities.Author;

public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;

    public static AuthorDto from(Author author) {
        return new AuthorDto(author.getId(), author.getFirstName(), author.getLastName());
    }

    public AuthorDto() {
    }

    public AuthorDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
