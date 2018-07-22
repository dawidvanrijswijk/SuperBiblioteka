package javakrk9.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

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

    public Book(String title, long relase, long isbn, String authorName, BooksType type, Integer pages, String borrowerName) {
        this.title = title;
        this.relase = relase;
        this.isbn = isbn;
        this.authorName = authorName;
        this.type = type;
        this.pages = pages;
        this.borrowerName = borrowerName;

    }
}
