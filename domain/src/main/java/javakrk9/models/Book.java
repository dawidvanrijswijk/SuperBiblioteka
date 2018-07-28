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
    private long release;
    private long isbn;
    private String authorName;
    private BooksType type;
    private Integer pages;
    private boolean borrow;
    private boolean removed;
    private String borrowerName;
    private String summary;
    private long authorId;

    public Book(String title, long release, long isbn, String authorName, BooksType type, Integer pages) {
        this.title = title;
        this.release = release;
        this.isbn = isbn;
        this.authorName = authorName;
        this.type = type;
        this.pages = pages;
    }

    public Book(long id, String title, long release, long isbn, String authorName, BooksType type, Integer pages) {
        this.id = id;
        this.title = title;
        this.release = release;
        this.isbn = isbn;
        this.authorName = authorName;
        this.type = type;
        this.pages = pages;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: '" + title + '\'' +
                ", Release date: " + release +
                ", ISBN: " + isbn +
                ", Author name: '" + authorName + '\'' +
                ", Type: " + type +
                ", Pages: " + pages +
                ", Borrow: " + borrow +
                ", Removed: " + removed +
                ", Borrower name: '" + borrowerName + '\'' +
                ", Summary: '" + summary + '\'' +
                ", Author ID:" + authorId +
                '}';
    }
}
