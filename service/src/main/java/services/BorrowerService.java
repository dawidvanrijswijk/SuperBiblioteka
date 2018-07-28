package services;

import javakrk9.exceptions.BorrowerNotFoundException;
import javakrk9.models.Borrower;
import repositories.BorrowerRepository;
import repositories.IBorrowerRepository;

import java.io.IOException;
import java.util.List;

public class BorrowerService implements IBorrowerService {

    private final static IBorrowerRepository BORROWER_REPOSITORY = new BorrowerRepository();

    public void create(Borrower borrower) throws IOException
    {
        BORROWER_REPOSITORY.create(borrower);
    }

    public void delete(Long borrowerID) throws IOException {
        BORROWER_REPOSITORY.delete(borrowerID);
    }

    public List<Borrower> getAll() throws IOException
    {
        return BORROWER_REPOSITORY.getAll();
    }

    public Borrower get(Long borrowerID) throws IOException, BorrowerNotFoundException {
        return BORROWER_REPOSITORY.get(borrowerID);
    }

    public void update(Borrower borrower, Long borrowerID) throws IOException, BorrowerNotFoundException {
        BORROWER_REPOSITORY.update(borrower, borrowerID);
    }
}
