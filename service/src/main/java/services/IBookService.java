package services;

import javakrk9.models.Book;

import java.io.IOException;

public interface IBookService {

    void create(Book book) throws IOException;
}
