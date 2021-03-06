package services;

import IE.BookParser;
import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.Book;
import repositories.BookRepository;
import repositories.IBookRepository;

import java.io.IOException;
import java.util.List;

public class BookService implements IBookService {

    private IBookRepository BOOK_REPOSITORY = new BookRepository();
    private BookParser BOOK_PARSER = new BookParser();

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

    public void update(Book book, long id) throws IOException, ItemNotFoundException, NullPointerException {
        BOOK_REPOSITORY.update(book, id);
    }

    @Override
    public Book get(Long id) throws NullPointerException, IOException {
        return BOOK_REPOSITORY.get(id);
    }

    public void addBorrow(Long bookId) throws IOException, ItemNotFoundException {
        BOOK_REPOSITORY.addBorrow(bookId);
    }

    public void importFromFile() {
        try {
            List<Book> books = BOOK_PARSER.parse("./import-export/src/main/resources/books_sample.xlsx");
            BOOK_REPOSITORY.create((Book) books);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}