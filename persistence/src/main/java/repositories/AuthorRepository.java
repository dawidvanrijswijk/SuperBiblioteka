package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.models.Author;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AuthorRepository implements IAuthorRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String AUTHOR_DB_PATH = "./persistence/src/main/resources/database/authors/authors.json";

    public void save(Author author) throws IOException {
        List<Author> authors =
                OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Author.class
                ));
        Long nextId = (long) (authors.size() + 1);
        author.setId(nextId);
        authors.add(author);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), authors);
    }

    @Override
    public void create(Author author) {

    }

    @Override
    public void delete(Long authorID) {

    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public Author get(Long authorID) {
        return null;
    }

    @Override
    public void update(Author author, Long authorID) {

    }
}