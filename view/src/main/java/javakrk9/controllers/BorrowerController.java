package javakrk9.controllers;

import javakrk9.exceptions.BorrowerNotFoundException;
import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.Borrower;
import services.BorrowerService;
import services.IBorrowerService;

import java.io.IOException;
import java.util.List;

public class BorrowerController {
    private static final IBorrowerService BORROWER_SERVICE = new BorrowerService();

    public void create(String name, String surname, String address, String phoneNumber, String email) {
        Borrower borrow = new Borrower();
        borrow.setName(name);
        borrow.setSurname(surname);
        borrow.setAddress(address);
        borrow.setPhoneNumber(phoneNumber);
        borrow.setEmail(email);
        try {
            BORROWER_SERVICE.create(borrow);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long borrowID) throws IOException, ItemNotFoundException {
        BORROWER_SERVICE.delete(borrowID);
    }

    public List<Borrower> getAll() throws IOException {
        return BORROWER_SERVICE.getAll();
    }

    public Borrower get(Long borrowID) throws IOException, BorrowerNotFoundException {
        return BORROWER_SERVICE.get(borrowID);
    }

    public void update(Long borrowID, String name, String surname, String address, String phoneNumber, String email) throws IOException, BorrowerNotFoundException {
        Borrower borrow = new Borrower();
        borrow.setName(name);
        borrow.setSurname(surname);
        borrow.setAddress(address);
        borrow.setPhoneNumber(phoneNumber);
        borrow.setEmail(email);
        BORROWER_SERVICE.update(borrow, borrowID);
    }
}