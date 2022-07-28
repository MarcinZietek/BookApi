package pl.coderslab.web.dtos;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import pl.coderslab.persistence.entities.Person;
import pl.coderslab.persistence.entities.PersonDetails;

public class PersonDto {

    private Long id;
    private String login;
    private String password;
    private String email;
    private PersonDetailsDto details;

    public static PersonDto from(Person person) {
        return new PersonDto(person.getId(), person.getLogin(), person.getPassword(), person.getEmail(), PersonDetailsDto.from(person.getDetails()));
    }

    public PersonDto() {
    }

    public PersonDto(Long id, String login, String password, String email, PersonDetailsDto details) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.details = details;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonDetailsDto getDetails() {
        return details;
    }

    public void setDetails(PersonDetailsDto details) {
        this.details = details;
    }
}
