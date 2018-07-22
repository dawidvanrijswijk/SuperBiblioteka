package javakrk9.entry;

import javakrk9.controllers.AuthorController;
import javakrk9.controllers.BookController;
import javakrk9.controllers.BorrowController;
import javakrk9.controllers.BorrowerController;
import javakrk9.models.Author;
import javakrk9.models.Book;
import javakrk9.models.Borrow;
import javakrk9.models.Borrower;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibaryLauncher {

    public static void main(String[] args) {
//        authorController.save("Adam", "Mickiewicz", "Zaosie");
//
//        bookController.save("The Shadow of The Wind", 2001,  97807538, "Carlos Ruiz Zafon", BooksType.ROMANCE,603,true,"Jacek", "super książka®",1);
//
//        borrowerController.save("Janek", "Kowal", "Nowa Wieś",505894336,"j.kowal@gmail.com");
//
//        borrowController.save(1, 2,2000/23/12);

        Scanner sc = new Scanner(System.in);
        LibaryEnum libaryEnum = LibaryEnum.INIT;
        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();
        BorrowerController borrowerController = new BorrowerController();
        BorrowController borrowController = new BorrowController();
        Map<String, Author> authorHashMap = new HashMap<>();
        Map<String, Book> bookMap;
        Map<String, Borrow> borrowMap;
        Map<String, Borrower> borrowerMap;

        Author author = null;
        Book book = null;
        Borrower borrower = null;
        Borrow borrow = null;

        OtherViews.welcomeView();
        do {
            switch (libaryEnum) {
                case INIT:
                    OtherViews.initView();
                    Integer decision = sc.nextInt();
                    switch (decision) {
                        case 1:
                            libaryEnum = LibaryEnum.ADDING;
                            break;
                        case 2:
                            libaryEnum = LibaryEnum.REMOVING;
                            break;
                        case 3:
                            libaryEnum = LibaryEnum.HIRING;
                            break;
                        case 4:
                            libaryEnum = LibaryEnum.RETURNING;
                            break;
                        case 0:
                            libaryEnum = LibaryEnum.EXIT;
                            break;
                        default:
                            OtherViews.invalidCharacter();
                            libaryEnum = LibaryEnum.INIT;
                            break;
                    }
                    break;

                case REMOVING:

            }
        }while (book == null);
    }
}