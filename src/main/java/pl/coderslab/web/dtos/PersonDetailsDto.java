package pl.coderslab.web.dtos;

import pl.coderslab.persistence.entities.PersonDetails;

public class PersonDetailsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String streetNumber;
    private String street;
    private String city;

    public static PersonDetailsDto from(PersonDetails personDetails) {
        return new PersonDetailsDto(personDetails.getId(), personDetails.getFirstName(), personDetails.getLastName(),
            personDetails.getStreetNumber(), personDetails.getStreet(), personDetails.getCity());
    }

    public PersonDetailsDto() {
    }

    public PersonDetailsDto(Long id, String firstName, String lastName, String streetNumber, String street,
                            String city) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetNumber = streetNumber;
        this.street = street;
        this.city = city;
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

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
