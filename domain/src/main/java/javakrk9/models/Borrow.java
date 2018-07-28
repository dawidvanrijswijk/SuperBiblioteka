package javakrk9.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@ToString

public class Borrow {
    private Long borrowId;
    private Long id;
    private LocalDate borrowDate;
    private Long bookId;
    private Long borrowerId;
    private boolean returned;

    public Borrow()
    {
        this.returned = true;
    }

}
