package repositories;

import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.Book;

import java.io.IOException;
import java.util.List;

public interface IBookRepository {
    void create(Book book) throws IOException;

    void delete(Long bookId) throws IOException, ItemNotFoundException;

    List<Book> getAll() throws IOException;

    Book get(Long bookId) throws IOException;

    void update(Book book, Long bookId) throws IOException, ItemNotFoundException;

    void addBorrow(Long bookId) throws IOException, ItemNotFoundException;

    void create(List<Book> books);
}
