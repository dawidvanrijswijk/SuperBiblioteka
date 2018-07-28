package repositories;

import javakrk9.exceptions.BorrowerNotFoundException;
import javakrk9.models.Borrower;

import java.io.IOException;
import java.util.List;

public interface IBorrowerRepository {

    void create(Borrower borrower) throws IOException;

    void delete(Long borrowerID) throws IOException;

    List<Borrower> getAll() throws IOException;

    Borrower get(Long borrowerID) throws IOException, BorrowerNotFoundException;

    void update(Borrower borrower, Long borrowerID) throws IOException, BorrowerNotFoundException;

}
