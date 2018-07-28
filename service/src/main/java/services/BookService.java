package services;

import javakrk9.exceptions.ItemNotFoundException;
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
    public void delete(Long bookId) throws IOException {
        try {
            BOOK_REPOSITORY.delete(bookId);
        } catch (ItemNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void update(Book book, long id) throws IOException, ItemNotFoundException {
        BOOK_REPOSITORY.update(book, id);
    }
}