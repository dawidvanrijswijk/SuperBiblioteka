package IE;

import javakrk9.models.Book;
import java.io.IOException;
import java.util.List;

public interface IBookExporter {

    void export(List<Book> bookList, String path) throws IOException;

}
