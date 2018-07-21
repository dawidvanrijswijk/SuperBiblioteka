package services;

import javakrk9.models.Borrow;
import repositories.BorrowRepository;
import repositories.IBorrowRepository;

import java.io.IOException;

public class BorrowService implements IBorrowService {

    private IBorrowRepository borrowRepository = new BorrowRepository();

    @Override
    public void save(Borrow borrow) throws IOException {
        borrowRepository.save(borrow);
    }
}
