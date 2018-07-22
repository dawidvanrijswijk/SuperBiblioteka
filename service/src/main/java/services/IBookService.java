package services;

import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.Book;

import java.io.IOException;

public interface IBookService {

    void save(Book book) throws IOException;
}
