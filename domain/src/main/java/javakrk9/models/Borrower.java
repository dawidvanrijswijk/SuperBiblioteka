package javakrk9.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Borrower {
    private Long id;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String email;
    private boolean deleted;

    public Borrower() {
        this.deleted = false;
    }
}
