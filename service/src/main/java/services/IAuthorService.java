package services;

import javakrk9.models.Author;

import java.io.IOException;

public interface IAuthorService {

    void save(Author author) throws IOException;
}
