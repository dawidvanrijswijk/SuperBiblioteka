package IE;

import javakrk9.models.Book;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.ZoneId;
import java.util.LinkedList;
import java.util.List;

public class BookParser implements IBookParser {

    @Override
    public List<Book> parse(String path) throws IOException {

        List<Book> bookList = new LinkedList<>();

        FileInputStream excelFile = new FileInputStream(new File(path));
        Workbook workbook = new XSSFWorkbook(excelFile);
        Sheet datatypeSheet = workbook.getSheetAt(0);

        for (int i = 1; i <= datatypeSheet.getLastRowNum(); i++) {

            Row currentRow = datatypeSheet.getRow(i);

            Book book = new Book();

            book.setTitle(currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_TITLE).getRow().getCell(i).toString());
            book.setRelease(currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_PUBLISH_DATE).getDateCellValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            book.setIsbn(currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_ISBN).getStringCellValue());
            book.setPages((int) currentRow.getCell(BookXlsxDefinition.COLUMN_NUMBER_PAGES_COUNT).getNumericCellValue());

            bookList.add(book);
        }

        return bookList;
    }
}