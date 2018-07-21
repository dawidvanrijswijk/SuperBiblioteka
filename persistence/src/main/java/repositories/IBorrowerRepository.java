package repositories;

import javakrk9.models.Borrower;

import java.io.IOException;

public interface IBorrowerRepository {

    void save(Borrower borrower) throws IOException;
}
