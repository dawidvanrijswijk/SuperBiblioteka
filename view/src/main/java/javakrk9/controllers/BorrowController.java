package javakrk9.controllers;

import javakrk9.exceptions.BorrowNotFoundException;
import javakrk9.models.Borrow;
import services.BorrowService;
import services.IBorrowService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class BorrowController {
    private static final IBorrowService BORROW_SERVICE = new BorrowService();

    public void create(Long bookID, Long borrowerID, LocalDate borrowDate)
    {
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(borrowDate);
        borrow.setBookId(bookID);
        borrow.setBorrowerId(borrowerID);
        try {
            BORROW_SERVICE.create(borrow);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void delete(Long borrowID) throws IOException, BorrowNotFoundException {
        BORROW_SERVICE.delete(borrowID);
    }

    public List<Borrow> getAll() throws IOException {
        return BORROW_SERVICE.getAll();
    }

    public Borrow get(Long borrowID) throws IOException, BorrowNotFoundException {
        return BORROW_SERVICE.get(borrowID);
    }

    public void update(Long borrowID, Long bookID, Long borrowerID, LocalDate borrowDate) throws IOException, BorrowNotFoundException {
        Borrow borrow = new Borrow();
        borrow.setBorrowDate(borrowDate);
        borrow.setBookId(bookID);
        borrow.setBorrowerId(borrowerID);
        BORROW_SERVICE.update(borrow, borrowID);
    }

}
