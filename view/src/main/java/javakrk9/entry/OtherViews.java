package javakrk9.entry;

class OtherViews {
    static void welcomeView() {
        System.out.println("Welcome to our library!");
    }

    static void initView() {
        System.out.println("\nWhat do you want to do?");
        System.out.println("Press \"1\" to add a book");
        System.out.println("Press \"2\" to remove a book");
        System.out.println("Press \"3\" to edit a book");
        System.out.println("Press \"4\" to print all books");
        System.out.println("Press \"5\" to add author");
        System.out.println("Press \"6\" to hire a book");
        System.out.println("Press \"7\" to return a book");
        System.out.println("Press \"8\" to import a book");
        System.out.println("Press \"9\" to export a book");
        System.out.println("Press \"0\" to exit");
    }

    static void invalidCharacter() {
        System.out.println("Invalid character!");
    }
}
