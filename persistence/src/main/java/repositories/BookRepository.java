package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.models.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Book> books = OBJECT_MAPPER.readValue(new File(BOOKS_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Book
                .class));

        return books.stream().filter(b -> !b.isRemoved()).collect(Collectors.toList());
    }

    @Override
    public void delete(Long bookId) throws IOException {
        List<Book> books =
                OBJECT_MAPPER.readValue(new File(BOOKS_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Book
                        .class));
        for (Book b: books) {
            if (bookId.equals(b.getId()));
            b.setRemoved(true);
            break;
        }
        OBJECT_MAPPER.writeValue(new File(BOOKS_DB_PATH), books);
    }
}