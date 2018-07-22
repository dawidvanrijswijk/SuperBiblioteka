package repositories;

import javakrk9.models.Author;

import java.io.IOException;
import java.util.List;

public interface IAuthorRepository {

    void save(Author author) throws IOException;

    void create(Author author) throws IOException;

    void delete(Long authorID);

    List<Author> getAll() throws IOException;

    Author get(Long authorID);

    void update(Author author) throws IOException;
}
