package IE;

import javakrk9.models.Book;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class BookExporter implements IBookExporter {

    @Override
    public void export(List<Book> bookList, String path) throws IOException {

        Workbook workbook = new Workbook() {
        };
        Sheet sheet = workbook.createSheet("Books");
        createHeader(workbook, sheet, createHeaderLabels());

        int rowNum = 1;
        for (Book book : bookList) {
            createRow(workbook, sheet, rowNum++, book.getId(), book.getTitle(), book.getRelease(),
                    book.getIsbn(), book.getPages());
        }

        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }

    private void createRow(Workbook workbook, Sheet sheet, int i, Long id, String title, LocalDate release, String isbn, Integer pages) {
    }

    private void createHeader(Workbook workbook, Sheet sheet, String[] header)
    {
        CellStyle cellStyle = createHeaderCellStyle(workbook);

        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < header.length; i++)
        {
            Cell createCell = headerRow.createCell(i);
            createCell.setCellStyle(cellStyle);
            createCell.setCellValue(header[i]);
        }

        sheet.setColumnWidth(BookXlsxDefinition.COLUMN_NUMBER_ID, 1000);
        sheet.setColumnWidth(BookXlsxDefinition.COLUMN_NUMBER_TITLE, 10000);
        sheet.setColumnWidth(BookXlsxDefinition.COLUMN_NUMBER_PUBLISH_DATE, 3500);
        sheet.setColumnWidth(BookXlsxDefinition.COLUMN_NUMBER_ISBN, 3000);
        sheet.setColumnWidth(BookXlsxDefinition.COLUMN_NUMBER_PAGES_COUNT, 3000);
        sheet.setColumnWidth(BookXlsxDefinition.COLUMN_NUMBER_DESCRIPTION, 10000);
    }

    private void createStringCell(Workbook workbook, Row row, int colNum, String value)
    {
        CellStyle cellStyle = workbook.createCellStyle();
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    private void createNumericCell(Workbook workbook, Row row, int colNum, Long value)
    {
        CellStyle cellStyle = workbook.createCellStyle();
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    private void createNumericCell(Workbook workbook, Row row, int colNum, int value)
    {
        CellStyle cellStyle = workbook.createCellStyle();
        Cell cell = row.createCell(colNum);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }

    private void createDateCell(Workbook workbook, Row row, int colNum, LocalDate value)
    {
        Cell cell = row.createCell(colNum);

        CellStyle cellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        short dateFormat = createHelper.createDataFormat().getFormat("yyyy-MM-dd");
        cellStyle.setDataFormat(dateFormat);

        cell.setCellValue(Date.from(value.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        cell.setCellStyle(cellStyle);
    }

    private void createRow(Workbook workbook, Sheet sheet, int rowNum, Long id, String title, LocalDate publishDate,
                           String isbn, int pagesCount, String description)
    {
        Row row = sheet.createRow(rowNum);
        createNumericCell(workbook, row, BookXlsxDefinition.COLUMN_NUMBER_ID, id);
        createStringCell(workbook, row, BookXlsxDefinition.COLUMN_NUMBER_TITLE, title);
        createDateCell(workbook, row, BookXlsxDefinition.COLUMN_NUMBER_PUBLISH_DATE, publishDate);
        createStringCell(workbook, row, BookXlsxDefinition.COLUMN_NUMBER_ISBN, isbn);
        createNumericCell(workbook, row, BookXlsxDefinition.COLUMN_NUMBER_PAGES_COUNT, pagesCount);
        createStringCell(workbook, row, BookXlsxDefinition.COLUMN_NUMBER_DESCRIPTION, description);
    }

    private CellStyle createHeaderCellStyle(Workbook workbook)
    {
        CellStyle result = workbook.createCellStyle();
        result.setFillForegroundColor(HSSFColor.GREY_25_PERCENT.index);
        return result;
    }

    private String[] createHeaderLabels()
    {
        String[] returnStringArray = new String[BookXlsxDefinition.COLUMN_COUNT];
        returnStringArray[BookXlsxDefinition.COLUMN_NUMBER_ID] = BookXlsxDefinition.ID;
        returnStringArray[BookXlsxDefinition.COLUMN_NUMBER_TITLE] = BookXlsxDefinition.TITLE;
        returnStringArray[BookXlsxDefinition.COLUMN_NUMBER_PUBLISH_DATE] = BookXlsxDefinition.PUBLISH_DATE;
        returnStringArray[BookXlsxDefinition.COLUMN_NUMBER_ISBN] = BookXlsxDefinition.ISBN;
        returnStringArray[BookXlsxDefinition.COLUMN_NUMBER_PAGES_COUNT] = BookXlsxDefinition.PAGES_COUNT;
        returnStringArray[BookXlsxDefinition.COLUMN_NUMBER_DESCRIPTION] = BookXlsxDefinition.DESCRIPTION;

        return returnStringArray;
    }

}
