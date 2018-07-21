package javakrk9.controllers;

import javakrk9.models.Borrow;
import services.BorrowService;
import services.IBorrowService;

import java.io.IOException;

public class BorrowController {

    private IBorrowService borrowService = new BorrowService();

    public void save(long bookId, long borrowerId, Integer borrowDate) throws IOException {
        Borrow borrow = new Borrow();
        borrow.setBookId(bookId);
        borrow.setBorrowerId(borrowerId);
        borrow.setBorrowDate(borrowDate);
        borrowService.save(borrow);
    }
}