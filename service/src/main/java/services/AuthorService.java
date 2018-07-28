package services;

import javakrk9.exceptions.AuthorNotFoundException;
import javakrk9.models.Author;
import repositories.AuthorRepository;
import repositories.IAuthorRepository;

import java.io.IOException;
import java.util.List;

public class AuthorService implements IAuthorService {

    private final static IAuthorRepository AUTHOR_REPOSITORY = new AuthorRepository();

    public void create(Author author) throws IOException
    {
        AUTHOR_REPOSITORY.create(author);
    }

    public void delete(Long id) throws IOException, AuthorNotFoundException {
        AUTHOR_REPOSITORY.delete(id);
    }

    public List<Author> getAll() throws IOException
    {
        return AUTHOR_REPOSITORY.getAll();
    }

    public Author get(Long authorID) throws IOException, AuthorNotFoundException {
        return AUTHOR_REPOSITORY.get(authorID);
    }

    public void update(Author author, long id) throws IOException, AuthorNotFoundException {
        AUTHOR_REPOSITORY.update(author, id);
    }

}