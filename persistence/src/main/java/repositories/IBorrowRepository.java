package repositories;

import javakrk9.models.Borrow;

import java.io.IOException;

public interface IBorrowRepository {

    void save(Borrow borrow) throws IOException;

}
