package javakrk9.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Borrower {
    private long id;
    private String name;
    private String surname;
    private String adres;
    private int phoneNumber;
    private String email;
}
