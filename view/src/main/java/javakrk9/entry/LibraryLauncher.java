package javakrk9.entry;

import javakrk9.controllers.AuthorController;
import javakrk9.controllers.BookController;
import javakrk9.controllers.BorrowController;
import javakrk9.controllers.BorrowerController;
import javakrk9.exceptions.ItemNotFoundException;
import javakrk9.models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryLauncher {

    public static void main(String[] args) throws IOException, ItemNotFoundException {

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
                        libraryEnum = LibraryEnum.BORROW_BOOK;
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
                System.out.println("List of our actual authors: ");
                System.out.println(authorController.getAll());
                System.out.println("Enter book title: ");
                String title = sc.nextLine();
                System.out.println("Enter book release date: ");
                Integer releaseDate = sc.nextInt();
                System.out.println("Enter book ISBN number: ");
                Integer isbn = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter book author: ");
                String authorName = sc.nextLine();
                System.out.println("Enter book type: ");
                BooksType bookType = BooksType.valueOf(sc.nextLine());
                System.out.println("Enter book pages: ");
                Integer pages = sc.nextInt();
                sc.nextLine();
                System.out.println("You've successfully added a new book!");
                bookController.create(title, releaseDate, isbn, authorName, bookType, pages);
                libraryEnum = LibraryEnum.MENU;
                break;
            }

            case REMOVE_BOOK: {
                System.out.println("Enter ID of the book you wanna remove: ");
                int id = sc.nextInt();
                bookController.delete((long) id);
                System.out.println("You've successfully removed a book!");
                libraryEnum = LibraryEnum.MENU;
                break;
            }

            case EDIT_BOOK: {
                System.out.println("It's everything we got:");
                bookController.getAll().forEach(b -> System.out.println(b.getId() + " - " + b.getTitle()));
                System.out.println("Enter ID of the book you wanna edit: ");
                Long id = (long) sc.nextInt();
                sc.nextLine();
                System.out.println("Enter book title: ");
                String title = sc.nextLine();
                System.out.println("Enter book release date: ");
                Integer releaseDate = sc.nextInt();
                System.out.println("Enter book ISBN number: ");
                Integer isbn = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter book author: ");
                String authorName = sc.nextLine();
                System.out.println("Enter book type: ");
                BooksType bookType = BooksType.valueOf(sc.nextLine());
                System.out.println("Enter book pages: ");
                Integer pages = sc.nextInt();
                sc.nextLine();
                bookController.update(id, title, releaseDate, isbn, authorName, bookType, pages);
                libraryEnum = LibraryEnum.MENU;
                break;
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

            case BORROW_BOOK: {
                System.out.println("All our readers: ");
                borrowController.getAll().forEach(System.out::println);
                System.out.println("\n");
                System.out.println("It's everything we've got: ");
                bookController.getAll().forEach(System.out::println);
                System.out.println("\n");
                System.out.println("Type in Id of the book you wanna borrow");
                Long borrowId = (long) sc.nextInt();
                sc.nextLine();
                System.out.println("Type in ID of you as a borrower");
                Long borrowerId = (long) sc.nextInt();
                sc.nextLine();
                borrowController.create(borrowId, borrowerId, LocalDate.now());
                libraryEnum = LibraryEnum.MENU;
                break;
            }

            case RETURN_BOOK: {

            }
        } while (libraryEnum != LibraryEnum.EXIT);
    }
}