package javakrk9.controllers;

import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.Book;
import javakrk9.models.BooksType;
import services.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("EqualsBetweenInconvertibleTypes")
public class BookController {

    private static final IBookService BOOK_SERVICE = new BookService();

    public void create(String title, LocalDate release, String isbn, String authorName, BooksType type, Integer pages) throws IOException {
        Book book = new Book(title, release, isbn, authorName, type, pages);
        BOOK_SERVICE.create(book);
    }

    public List<Book> getAll() throws IOException {
        return BOOK_SERVICE.getAll();
    }

    public void delete(Long bookId) throws IOException {
        BOOK_SERVICE.delete(bookId);
    }

    public void update(Long id, String title, Integer release, Integer isbn, String authorName, BooksType type, Integer pages) throws IOException, ItemNotFoundException, NullPointerException {
        Book book = BOOK_SERVICE.get(id);
        book.setTitle(title.equals("") ? book.getTitle() : title);
        book.setRelease(release.equals("") ? book.getRelease() : LocalDate.ofEpochDay(release));
        book.setIsbn(isbn.equals("") ? book.getIsbn() : String.valueOf(isbn));
        book.setAuthorName(authorName.equals("") ? book.getAuthorName() : authorName);
        book.setType(type.equals("") ? book.getType() : type);
        book.setPages(pages.equals("") ? book.getPages() : pages);
        BOOK_SERVICE.update(book, book.getId());
    }

    public void addBorrow(Long bookId) throws IOException, ItemNotFoundException {
        BOOK_SERVICE.addBorrow(bookId);
    }
}