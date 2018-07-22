package javakrk9.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Author {
    private long id;
    private String firstName;
    private String lastName;
    private String placeOfBirth;
}
