package javakrk9.controllers;

import javakrk9.models.Book;
import javakrk9.models.BooksType;
import services.*;

import java.io.IOException;

public class BookController {

    private IBookService bookService = new BookService();

    public void save(String title, long relase, long isbn, String authorName, BooksType type, Integer pages, boolean borrow, String borrowerName, String summary, long authorId) throws IOException {
        Book book = new Book();
        book.setTitle(title);
        book.setRelase(relase);
        book.setIsbn(isbn);
        book.setAuthorName(authorName);
        book.setType(type);
        book.setPages(pages);
        book.setBorrow(borrow);
        book.setBorrowerName(borrowerName);
        book.setSummary(summary);
        book.setAuthorId(pages);
        bookService.save(book);

    }
}