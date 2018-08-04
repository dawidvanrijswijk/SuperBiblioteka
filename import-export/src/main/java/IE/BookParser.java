package IE;

import javakrk9.models.Book;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BookParser implements IBookParser {

    @Override
    public List<Book> parse(String path) throws IOException {

        List<Book> bookList = new LinkedList<>();

        FileInputStream excelFile = new FileInputStream(new File(path));
        Sheet datatypeSheet;
        try (Workbook workbook = new HSSFWorkbook(excelFile)) {
            datatypeSheet = workbook.getSheetAt(0);
        }
        Iterator<Row> iterator = datatypeSheet.iterator();

        while (iterator.hasNext()) {

            Row currentRow = iterator.next();
            Book book = new Book();

            book.setTitle(currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_TITLE).getStringCellValue());
            book.setRelease(currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_PUBLISH_DATE).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            book.setIsbn(currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_ISBN).getStringCellValue());
            book.setPages((int)currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_PAGES_COUNT).getNumericCellValue());

            bookList.add(book);
        }

        return bookList;
    }

}
