package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.models.Borrower;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BorrowerRepository implements IBorrowerRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String BORROWERS_DB_PATH = "./persistence/src/main/resources/database/borrowers/borrowers.json";

    public void save(Borrower borrower) throws IOException {
        List<Borrower> borrowers =
                OBJECT_MAPPER.readValue(new File(BORROWERS_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Borrower
                        .class));
        Long nextId = (long) (borrowers.size() + 1);
        borrower.setId(nextId);
        borrowers.add(borrower);
        OBJECT_MAPPER.writeValue(new File(BORROWERS_DB_PATH), borrowers);
    }
}