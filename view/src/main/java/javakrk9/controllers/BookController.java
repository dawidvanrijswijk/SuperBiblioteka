package javakrk9.controllers;

import javakrk9.models.Book;
import javakrk9.models.BooksType;
import services.*;

import java.io.IOException;

public class BookController {

    private IBookService bookService = new BookService();

    private static final IBookService BOOK_SERVICE = new BookService();

    public void create(String title, long relase, long isbn, String authorName, BooksType type, Integer pages, String borrowerName) throws IOException {
        Book book = new Book(title, relase, isbn, authorName, type, pages, borrowerName);
        BOOK_SERVICE.create(book);
    }
}