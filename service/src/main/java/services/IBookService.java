package services;

import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.Book;

import java.io.IOException;
import java.util.List;

public interface IBookService {

    void create(Book book) throws IOException;
    List<Book> getAll() throws IOException;
    void delete(Long authorID) throws IOException;
    void update(Book author, long id) throws IOException, ItemNotFoundException;
    Book get(Long id) throws IOException;
    void addBorrow(Long bookId) throws IOException, ItemNotFoundException;
}
