package repositories;

import com.fasterxml.jackson.databind.ObjectMapper;
import javakrk9.models.Borrow;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BorrowRepository implements IBorrowRepository {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String BORROWS_DB_PATH = "./persistence/src/main/resources/database/borrows/borrows.json";

    public void save(Borrow borrow) throws IOException {
        List<Borrow> borrows =
                OBJECT_MAPPER.readValue(new File(BORROWS_DB_PATH), OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, Borrow
                        .class));
        Long nextId = (long) (borrows.size() + 1);
        borrow.setId(nextId);
        borrows.add(borrow);
        OBJECT_MAPPER.writeValue(new File(BORROWS_DB_PATH), borrows);

    }
}
