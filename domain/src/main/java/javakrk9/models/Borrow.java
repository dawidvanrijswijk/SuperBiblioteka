package javakrk9.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Borrow {
    long id;
    long bookId;
    long borrowerId;
    Integer borrowDate;

}
