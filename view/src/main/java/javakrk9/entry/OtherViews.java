package javakrk9.entry;

public class OtherViews {
    public static void welcomeView() {
        System.out.println("Welcome to our library!\n");
    }

    public static void initView() {
        System.out.println("What do you want to do?");
        System.out.println("Press \"1\" to add a book");
        System.out.println("Press \"2\" to remove a book");
        System.out.println("Press \"3\" to hire a book");
        System.out.println("Press \"4\" to return a book");
        System.out.println("Press \"5\" to exit");
    }

    public static void invalidCharacter() {
        System.out.println("Invalid character!");
    }
}
