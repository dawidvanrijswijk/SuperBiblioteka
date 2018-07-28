package repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.exceptions.AuthorNotFoundException;
import javakrk9.models.Author;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class AuthorRepository implements IAuthorRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String AUTHOR_DB_PATH = "/Users/dawidvanrijswijk/IdeaProjects/Super_Biblioteka/persistence/src/main/resources/database/authors/authors.json";

    public void create(Author author) throws IOException {
        List<Author> authors = getAll(true);
        if (authors.size() > 0) {
            author.setId(findMaxAuthorID(authors) + 1);
        } else {
            authors = new ArrayList<>();
            author.setId(1L);
        }
        authors.add(author);
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), authors);
    }

    private Long findMaxAuthorID(List<Author> authors) {
        return authors.stream().sorted(Comparator.comparing(Author::getId).reversed()).findFirst().get().getId();
    }

    public void delete(Long id) throws IOException, AuthorNotFoundException {
        List<Author> authors = getAll(true).stream().filter(x -> Objects.equals(x.getId(), id)).collect(Collectors.toList());
        if (authors.size() < 1) throw new AuthorNotFoundException("Nie znaleziono autora o id = " + id);
        authors.stream().forEach(x -> x.setDeleted(true));
        OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), authors);
    }

    public List<Author> getAll() throws IOException {
        return getAll(false);
    }

    public Author get(Long id) throws IOException, AuthorNotFoundException {
        List<Author> authors = getAll(false);
        Optional<Author> authorOpt = authors.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst();

        if (!authorOpt.isPresent())
            throw new AuthorNotFoundException("Nie znaleziono autora o id = " + id);
        else
            return authorOpt.get();
    }

    public void update(Author author, Long id) throws IOException, AuthorNotFoundException {
        List<Author> authors = getAll(false);

        Optional<Author> authorOpt = authors.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst();

        if (!authorOpt.isPresent())
            throw new AuthorNotFoundException("Nie znaleziono autora o id = " + id);
        else {
            Author authorFromDB = authors.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst().get();
            authorFromDB.setFirstName(author.getFirstName());
            authorFromDB.setLastName(author.getLastName());
            authorFromDB.setPlaceOfBirth(author.getPlaceOfBirth());
            authorFromDB.setDeleted(author.isDeleted());
            OBJECT_MAPPER.writeValue(new File(AUTHOR_DB_PATH), authors);
        }
    }

    private List<Author> getAll(boolean getAllWithDeleted) throws IOException {
        List<Author> authors = OBJECT_MAPPER.readValue(new File(AUTHOR_DB_PATH), new TypeReference<List<Author>>() {
        });
        if (getAllWithDeleted)
            return authors;
        else
            return authors.stream().filter(x -> !x.isDeleted()).collect(Collectors.toList());
    }
}