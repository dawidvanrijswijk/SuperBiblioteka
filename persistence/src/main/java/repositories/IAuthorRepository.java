package repositories;

import javakrk9.models.Author;

import java.io.IOException;

public interface IAuthorRepository {

    void save(Author author) throws IOException;

}
