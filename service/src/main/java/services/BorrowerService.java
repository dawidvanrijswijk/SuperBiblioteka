package services;

import javakrk9.models.Borrower;
import repositories.BorrowerRepository;
import repositories.IBorrowerRepository;

import java.io.IOException;

public class BorrowerService implements IBorrowerService {

    private IBorrowerRepository borrowerRepository = new BorrowerRepository();

    @Override
    public void save(Borrower borrower) throws IOException {
        borrowerRepository.save(borrower);
    }
}