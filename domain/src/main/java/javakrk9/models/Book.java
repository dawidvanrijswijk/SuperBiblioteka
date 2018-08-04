package javakrk9.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

public class Book {
    private Long id;
    private String title;
    private LocalDate release;
    private String isbn;
    private String authorName;
    private BooksType type;
    private Integer pages;
    private boolean borrow;
    private boolean removed;
    private String borrowerName;
    private String summary;
    private Long authorId;

    public Book(String title, LocalDate release, String isbn, String authorName, BooksType type, Integer pages) {
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
                ", Pages: " + pages;
    }
}
