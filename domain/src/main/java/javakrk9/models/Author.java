package javakrk9.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor


public class Author {
    private long id;
    private String firstName;
    private String lastName;
    private String placeOfBirth;

    public Author(String firstName, String lastName, String placeOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.placeOfBirth = placeOfBirth;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
