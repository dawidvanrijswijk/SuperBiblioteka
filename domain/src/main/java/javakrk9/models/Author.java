package javakrk9.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class Author {
    private Long id;
    private String firstName;
    private String lastName;
    private String placeOfBirth;
    private boolean deleted;

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
