package services;

import javakrk9.models.Author;
import repositories.AuthorRepository;
import repositories.IAuthorRepository;

import java.io.IOException;

public class AuthorService implements IAuthorService {

    private IAuthorRepository authorRepository = new AuthorRepository();

    @Override
    public void save(Author author) throws IOException {
        authorRepository.save(author);
    }
}