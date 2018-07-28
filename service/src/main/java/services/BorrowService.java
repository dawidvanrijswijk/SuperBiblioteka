package services;

import javakrk9.exceptions.BorrowNotFoundException;
import javakrk9.models.Borrow;
import repositories.BorrowRepository;
import repositories.IBorrowRepository;


import java.io.IOException;
import java.util.List;


public class BorrowService implements IBorrowService {

    private final static IBorrowRepository BORROW_REPOSITORY = new BorrowRepository();

    public void create(Borrow borrow) throws IOException
    {
        BORROW_REPOSITORY.create(borrow);
    }

    public void delete(Long borrowID) throws IOException
    {
        BORROW_REPOSITORY.returnBook(borrowID);
    }

    public List<Borrow> getAll() throws IOException
    {
        return BORROW_REPOSITORY.getAll();
    }

    public Borrow get(Long borrowID) throws IOException, BorrowNotFoundException
    {
        return BORROW_REPOSITORY.get(borrowID);
    }

    public void update(Borrow borrow, Long borrowID) throws IOException, BorrowNotFoundException
    {
        BORROW_REPOSITORY.update(borrow, borrowID);
    }
}