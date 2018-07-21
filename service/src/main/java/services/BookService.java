package services;

import javakrk9.models.Book;
import repositories.BookRepository;
import repositories.IBookRepository;

import java.io.IOException;

public class BookService implements IBookService {

    private IBookRepository bookRepository = new BookRepository();

    @Override
    public void save(Book book) throws IOException {
        bookRepository.save(book);
    }

//    @Override
//    public void deleteBook(Long bookId) throws IOException, IllegalAccessException, ItemNotFoundException {
//        Book book = Optional.ofNullable(bookRepository.findBook(bookId)).orElseThrow(() -> {
//            Logger.er
//        })
    }
