package javakrk9.controllers;

import javakrk9.models.Book;
import javakrk9.models.BooksType;
import services.*;

import java.io.IOException;
import java.util.List;

public class BookController {

    private static final IBookService BOOK_SERVICE = new BookService();

    public void create(String title, long release, long isbn, String authorName, BooksType type, Integer pages) throws IOException {
        Book book = new Book(title, release, isbn, authorName, type, pages);
        BOOK_SERVICE.create(book);
    }
    public List<Book> getAll() throws IOException {
        return BOOK_SERVICE.getAll();
    }
    public void delete(Long authorID) throws IOException {
        BOOK_SERVICE.delete(authorID);
    }
}