package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.models.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BookRepository implements IBookRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String BOOKS_DB_PATH = "./persistence/src/main/resources/database/books/books.json";

    public void create(Book book) throws IOException {
        List<Book> books =
                OBJECT_MAPPER.readValue(new File(BOOKS_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Book
                        .class));
        Long nextId = (long) (books.size() + 1);
        book.setId(nextId);
        books.add(book);
        OBJECT_MAPPER.writeValue(new File(BOOKS_DB_PATH), books);
    }

    @Override
    public List<Book> getAll() throws IOException {
        return OBJECT_MAPPER.readValue(new File(BOOKS_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Book
                .class));
    }

    @Override
    public void delete(Long authorID) throws IOException {
        List<Book> books =
                OBJECT_MAPPER.readValue(new File(BOOKS_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Book
                        .class));
        authorID.toString();
    }
}