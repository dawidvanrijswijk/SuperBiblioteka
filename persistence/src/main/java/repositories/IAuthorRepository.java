package repositories;

import javakrk9.models.Author;

import java.io.IOException;
import java.util.List;

public interface IAuthorRepository {

    void save(Author author) throws IOException;

    void create(Author author);

    void delete(Long authorID);

    List<Author> getAll();

    Author get(Long authorID);

    void update(Author author, Long authorID);
}
