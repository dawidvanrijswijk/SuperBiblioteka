package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.Book;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
    public Book get(Long bookId) throws IOException, ItemNotFoundException {
        return null;
    }

    @Override
    public void update(Book book, Long bookId) throws IOException, ItemNotFoundException {
        List<Book> books = getAll();

        Optional<Book> bookOptional = books.stream().filter(x -> Objects.equals(x.getId(), bookId)).findFirst();

        if (!bookOptional.isPresent())
            throw new ItemNotFoundException("Nie znaleziono książki o id = " + bookId);
        else {
            Book bookFromDB = books.stream().filter(x -> Objects.equals(x.getId(), bookId)).findFirst().get();
            bookFromDB.setTitle(book.getTitle());
            bookFromDB.setRelease(book.getRelease());
            bookFromDB.setIsbn(book.getIsbn());
            bookFromDB.setAuthorName(book.getAuthorName());
            bookFromDB.setType(book.getType());
            bookFromDB.setPages(book.getPages());
            bookFromDB.setBorrowerName(book.getBorrowerName());
            bookFromDB.setSummary(book.getSummary());
            bookFromDB.setAuthorId(book.getAuthorId());
            OBJECT_MAPPER.writeValue(new File(BOOKS_DB_PATH), books);
        }
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