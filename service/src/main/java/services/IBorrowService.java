package services;

import javakrk9.models.Borrow;

import java.io.IOException;

public interface IBorrowService {

    void save(Borrow borrow) throws IOException;

}
