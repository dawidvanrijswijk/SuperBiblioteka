package javakrk9.controllers;

import javakrk9.models.Borrower;
import services.BorrowerService;
import services.IBorrowerService;

import java.io.IOException;

public class BorrowerController {

    private IBorrowerService borrowerService = new BorrowerService();

    public void save(String name, String surname, String adres, int phoneNumber, String email) throws IOException {
        Borrower borrower = new Borrower();
        borrower.setName(name);
        borrower.setSurname(surname);
        borrower.setAdres(adres);
        borrower.setPhoneNumber(phoneNumber);
        borrower.setEmail(email);
        borrowerService.save(borrower);
    }
}
