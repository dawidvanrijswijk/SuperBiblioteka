package javakrk9.controllers;

import javakrk9.models.Author;
import services.AuthorService;
import services.IAuthorService;

import java.io.IOException;

public class AuthorController {

    private IAuthorService authorService = new AuthorService();

    public void save(String firstName, String lastName, String placeOfBirth) throws IOException {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.setPlaceOfBirth(placeOfBirth);
        authorService.save(author);
    }
}