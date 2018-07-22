package services;

import javakrk9.models.Book;
import repositories.BookRepository;
import repositories.IBookRepository;

import java.io.IOException;

public class BookService implements IBookService {

    private IBookRepository bookRepository = new BookRepository();

    @Override
    public void create (Book book) throws IOException {
        bookRepository.create(book);
    }
}