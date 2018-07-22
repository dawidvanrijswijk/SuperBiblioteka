package repositories;

import javakrk9.models.Book;

import java.io.IOException;
import java.util.List;

public interface IBookRepository {
    void create (Book book) throws IOException;

    List<Book> getAll() throws IOException;

    void delete(Long authorID) throws IOException;
}
