package javakrk9.models;

public enum  BooksType {

    SINECE_FICTION("Science Fiction"),
    HORROR("Horror"),
    ROMANCE("Romance"),
    TRAVEL("Travel"),
    SCIENCE("Science"),
    HISTORY("History"),
    FANTASY("Fantasy");

    private String text;

    BooksType(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
