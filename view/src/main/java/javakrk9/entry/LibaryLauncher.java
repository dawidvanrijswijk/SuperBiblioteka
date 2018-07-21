package javakrk9.entry;

import javakrk9.controllers.AuthorController;
import javakrk9.controllers.BookController;
import javakrk9.controllers.BorrowerController;
import javakrk9.models.BooksType;
import javakrk9.models.Borrower;

import java.io.IOException;

public class LibaryLauncher {

    public static void main(String[] args) throws IOException {
        AuthorController authorController = new AuthorController();
        authorController.save("Adam", "Mickiewicz", "Zaosie");

        BookController bookController = new BookController();
        bookController.save("The Shadow of The Wind", 2001,  97807538, "Carlos Ruiz Zafon", BooksType.ROMANCE,603,true,"Jacek", "super książka®",1);

        BorrowerController borrowerController = new BorrowerController();
        borrowerController.save("Janek", "Kowal", "Nowa Wieś",505894336,"j.kowal@gmail.com");
    }
}
