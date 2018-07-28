package services;

import javakrk9.exceptions.BorrowNotFoundException;
import javakrk9.models.Borrow;

import java.io.IOException;
import java.util.List;

public interface IBorrowService {


    void create(Borrow borrow) throws IOException;
    void delete(Long borrowID) throws IOException, BorrowNotFoundException;
    List<Borrow> getAll() throws IOException;
    Borrow get(Long borrowID) throws IOException, BorrowNotFoundException;
    void update(Borrow borrow, Long borrowID) throws IOException, BorrowNotFoundException;

}
