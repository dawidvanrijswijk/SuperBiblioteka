package IE;

import javakrk9.models.Book;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BookImport {

    private static final String FILE_NAME = "/Users/dawidvanrijswijk/OneDrive/Documents/codeImport.xlsx";


    public List<Book> parse() {
        try (FileInputStream stream = new FileInputStream(FILE_NAME)) {
            Workbook workbook = new HSSFWorkbook(stream);
            Sheet sheetAt = workbook.getSheetAt(0);
            List<Book> books = new ArrayList<>();
            for (int i = 1; i <= sheetAt.getLastRowNum(); i++) {
                Row row = sheetAt.getRow(i);
                Book book = new Book();
                book.setId((long) row.getCell(0).getNumericCellValue());
                book.setTitle(row.getCell(1).getStringCellValue());
                book.setRelease((long) row.getCell(2).getNumericCellValue());
                book.setIsbn((long) row.getCell(3).getNumericCellValue());
                book.setAuthorName((row.getCell(4).getStringCellValue()));
                book.setPages((int) row.getCell(5).getNumericCellValue());
                books.add(book);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}