package javakrk9.entry;

public class OtherViews {
    public static void welcomeView() {
        System.out.println("Welcome to our library!");
    }

    public static void initView() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("Press \"1\" to add a book");
        System.out.println("Press \"2\" to remove a book");
        System.out.println("Press \"3\" to edit a book");
        System.out.println("Press \"4\" to print all books");
        System.out.println("Press \"5\" to add author");
        System.out.println("Press \"6\" to hire a book");
        System.out.println("Press \"7\" to return a book");
        System.out.println("Press \"0\" to exit");
    }

    public static void invalidCharacter() {
        System.out.println("Invalid character!");
    }
}
