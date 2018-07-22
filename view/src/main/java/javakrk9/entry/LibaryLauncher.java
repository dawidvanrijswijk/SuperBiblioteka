package javakrk9.entry;

import javakrk9.controllers.AuthorController;
import javakrk9.controllers.BookController;
import javakrk9.controllers.BorrowController;
import javakrk9.controllers.BorrowerController;
import javakrk9.exceptions.AuthorNotFoundException;
import javakrk9.models.Author;
import javakrk9.models.Book;
import javakrk9.models.Borrow;
import javakrk9.models.Borrower;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LibaryLauncher {

    public static void main(String[] args) {

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

                case ADDING:
                    System.out.print("Enter author ID: ");
                    Long id = Long.valueOf(sc.next());
                    System.out.print("Enter author name: ");
                    String name = sc.next();
                    System.out.print("Enter author surname: ");
                    String surname = sc.next();
                    System.out.print("Enter author birthplace: ");
                    String birthplace = sc.next();
                    try {
                        authorController.update(id,name,surname,birthplace);
                    } catch (IOException | AuthorNotFoundException e) {
                        e.printStackTrace();
                    }
                    System.out.println("You've successfully added a new author!");
            }
        }while (book == null);
    }
}