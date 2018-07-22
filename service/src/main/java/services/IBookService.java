package services;

import javakrk9.models.Book;

import java.io.IOException;
import java.util.List;

public interface IBookService {

    void create(Book book) throws IOException;
    List<Book> getAll() throws IOException;

}
