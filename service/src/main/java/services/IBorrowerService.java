package services;

import javakrk9.models.Borrower;

import java.io.IOException;

public interface IBorrowerService {
    void save(Borrower borrower) throws IOException;
}
