package repositories;

import javakrk9.models.Book;

import java.io.IOException;

public interface IBookRepository {
    void save(Book book) throws IOException;
}
