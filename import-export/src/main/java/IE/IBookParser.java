package IE;

import javakrk9.models.Book;
import java.io.IOException;
import java.util.List;

public interface IBookParser {

    List<Book> parse(String path) throws IOException;

}
