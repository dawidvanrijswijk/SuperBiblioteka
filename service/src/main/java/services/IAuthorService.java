package services;

import javakrk9.exceptions.AuthorNotFoundException;
import javakrk9.models.Author;

import java.io.IOException;
import java.util.List;

public interface IAuthorService {

    void create(Author author) throws IOException;
    void delete(Long authorID) throws IOException;
    List<Author> getAll() throws IOException;
    Author get(Long authorID) throws IOException, AuthorNotFoundException;
    void update(Author author, Long authorID) throws IOException, AuthorNotFoundException;

    void save(Author author) throws IOException;
}