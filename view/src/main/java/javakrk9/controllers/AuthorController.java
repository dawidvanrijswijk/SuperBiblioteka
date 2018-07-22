package javakrk9.controllers;

import javakrk9.exceptions.AuthorNotFoundException;
import javakrk9.models.Author;
import services.AuthorService;
import services.IAuthorService;

import java.io.IOException;
import java.util.List;

public class AuthorController {

    private static final IAuthorService AUTHOR_SERVICE = new AuthorService();

    public void create(String firstName, String lastName, String placeOfBirth) throws IOException {
        Author author = new Author(firstName, lastName, placeOfBirth);
        AUTHOR_SERVICE.create(author);
    }

    public void delete(Long authorID) throws IOException {
        AUTHOR_SERVICE.delete(authorID);
    }

    public List<Author> getAll() throws IOException {
        return AUTHOR_SERVICE.getAll();
    }

    public Author get(Long authorID) throws IOException, AuthorNotFoundException {
        return AUTHOR_SERVICE.get(authorID);
    }

    public void update(String name, String surname, String birthPlace) throws IOException, AuthorNotFoundException {
        Author author = new Author(name, surname, birthPlace);
        AUTHOR_SERVICE.update(author);
    }
}