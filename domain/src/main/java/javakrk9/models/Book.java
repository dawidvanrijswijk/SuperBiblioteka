package javakrk9.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", relase=" + relase +
                ", isbn=" + isbn +
                ", authorName='" + authorName + '\'' +
                ", type=" + type +
                ", pages=" + pages +
                ", borrow=" + borrow +
                ", borrowerName='" + borrowerName + '\'' +
                ", summary='" + summary + '\'' +
                ", authorId=" + authorId +
                '}';
    }

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
