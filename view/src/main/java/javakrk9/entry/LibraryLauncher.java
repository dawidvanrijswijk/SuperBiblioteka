package javakrk9.entry;

import javakrk9.controllers.AuthorController;
import javakrk9.controllers.BookController;
import javakrk9.controllers.BorrowController;
import javakrk9.controllers.BorrowerController;
import javakrk9.models.*;

import java.io.IOException;
import java.util.Scanner;

public class LibraryLauncher {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        LibraryEnum libraryEnum = LibraryEnum.MENU;
        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();
        BorrowerController borrowerController = new BorrowerController();
        BorrowController borrowController = new BorrowController();

        OtherViews.welcomeView();
        do switch (libraryEnum) {
            case MENU:
                OtherViews.initView();
                Integer decision = sc.nextInt();
                sc.nextLine();
                switch (decision) {
                    case 1:
                        libraryEnum = LibraryEnum.ADD_BOOK;
                        break;
                    case 2:
                        libraryEnum = LibraryEnum.REMOVE_BOOK;
                        break;
                    case 3:
                        libraryEnum = LibraryEnum.EDIT_BOOK;
                        break;
                    case 4:
                        libraryEnum = LibraryEnum.PRINT_ALL_BOOKS;
                        break;
                    case 5:
                        libraryEnum = LibraryEnum.ADD_AUTHOR;
                        break;
                    case 6:
                        libraryEnum = LibraryEnum.HIRE_BOOK;
                        break;
                    case 7:
                        libraryEnum = LibraryEnum.RETURN_BOOK;
                        break;
                    case 0:
                        libraryEnum = LibraryEnum.EXIT;
                        break;
                    default:
                        OtherViews.invalidCharacter();
                        libraryEnum = LibraryEnum.MENU;
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
                bookController.create(title, releaseDate, isbn, authorName, bookType, pages);
                libraryEnum = LibraryEnum.MENU;
                break;
            }

            case REMOVE_BOOK: {
                System.out.println("Enter ID of the book you wanna remove");
                int id = sc.nextInt();
                bookController.delete((long) id);
                libraryEnum = LibraryEnum.MENU;
                break;
            }

            case EDIT_BOOK: {

            }

            case PRINT_ALL_BOOKS: {
                System.out.println("It's everything we got:");
                bookController.getAll().forEach(System.out::println);
                libraryEnum = LibraryEnum.MENU;
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
                authorController.create(name, surname, birthplace);
                libraryEnum = LibraryEnum.MENU;
                break;
            }

            case HIRE_BOOK: {

            }

            case RETURN_BOOK: {

            }
        } while (libraryEnum != LibraryEnum.EXIT);
    }
}