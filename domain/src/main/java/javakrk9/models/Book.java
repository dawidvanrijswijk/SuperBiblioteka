package javakrk9.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Book {
    private long id;
    private String title;
    private long relase;
    private long isbn;
    private String authorName;
    private BooksType type;
    private Integer pages;
    private boolean borrow;
    private String borrowerName;
    private String summary;
    private long authorId;
}
