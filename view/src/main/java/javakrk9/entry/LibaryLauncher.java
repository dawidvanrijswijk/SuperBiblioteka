package javakrk9.entry;

import javakrk9.controllers.AuthorController;
import javakrk9.controllers.BookController;
import javakrk9.controllers.BorrowController;
import javakrk9.controllers.BorrowerController;
import javakrk9.models.*;

import java.io.IOException;
import java.util.Scanner;

public class LibaryLauncher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LibaryEnum libaryEnum = LibaryEnum.INIT;
        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();
        BorrowerController borrowerController = new BorrowerController();
        BorrowController borrowController = new BorrowController();

        OtherViews.welcomeView();
        do {
            switch (libaryEnum) {
                case INIT:
                    OtherViews.initView();
                    Integer decision = sc.nextInt();
                    sc.nextLine();
                    switch (decision) {
                        case 1:
                            libaryEnum = LibaryEnum.ADD_BOOK;
                            break;
                        case 2:
                            libaryEnum = LibaryEnum.REMOVE_BOOK;
                            break;
                        case 3:
                            libaryEnum = LibaryEnum.EDIT_BOOK;
                            break;
                        case 4:
                            libaryEnum = LibaryEnum.PRINT_ALL_BOOKS;
                            break;
                        case 5:
                            libaryEnum = LibaryEnum.ADD_AUTHOR;
                            break;
                        case 6:
                            libaryEnum = LibaryEnum.HIRE_BOOK;
                            break;
                        case 7:
                            libaryEnum = LibaryEnum.RETURN_BOOK;
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

                case ADD_BOOK: {
                    System.out.println("Enter book title");
                    String title = sc.nextLine();
                    System.out.println("Enter book release date");
                    Integer releaseDate = sc.nextInt();
                    System.out.println("Enter book ISBN number");
                    Integer isbn = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter book author");
                    String authorName = sc.nextLine();
                    System.out.println("Enter book type");
                    BooksType bookType = BooksType.valueOf(sc.nextLine());
                    System.out.println("Enter book pages");
                    Integer pages = sc.nextInt();
                    sc.nextLine();
                    System.out.println("You've successfully added a new book!");
                    try {
                        bookController.create(title, releaseDate, isbn, authorName, bookType, pages);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }libaryEnum = LibaryEnum.INIT;
                    break;
                }

                case PRINT_ALL_BOOKS: {
                    System.out.println("It's everything we got:");
                    try {
                        bookController.getAll().forEach(System.out::println);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }libaryEnum = LibaryEnum.INIT;
                    break;
                }

                case ADD_AUTHOR: {
                    System.out.print("Enter author name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter author surname: ");
                    String surname = sc.nextLine();
                    System.out.print("Enter author birthplace: ");
                    String birthplace = sc.nextLine();
                    System.out.println("You've successfully added a new author!");
                    try {
                        authorController.create(name, surname, birthplace);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }libaryEnum = LibaryEnum.INIT;
                    break;
                }
            }
        } while (libaryEnum != LibaryEnum.EXIT);
    }
}