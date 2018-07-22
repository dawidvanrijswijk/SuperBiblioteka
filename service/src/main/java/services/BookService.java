package services;

import javakrk9.models.Book;
import repositories.BookRepository;
import repositories.IBookRepository;

import java.io.IOException;
import java.util.List;

public class BookService implements IBookService {

    private IBookRepository BOOK_REPOSITORY = new BookRepository();

    @Override
    public void create(Book book) throws IOException {
        BOOK_REPOSITORY.create(book);
    }

    public List<Book> getAll() throws IOException {
        return BOOK_REPOSITORY.getAll();
    }
}