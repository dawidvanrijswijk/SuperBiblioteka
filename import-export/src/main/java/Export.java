import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Export {
    private static final String FILE_NAME = "/Users/dawidvanrijswijk/OneDrive/Documents/Book3.xlsx";

    public static void main(String[] args) {

        try {
            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new HSSFWorkbook(excelFile);
            Sheet dataTypeSheet = workbook.getSheetAt(0);
            for (Row currentRow : dataTypeSheet) {
                for (Cell currentCell : currentRow) {
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                        System.out.print(currentCell.getStringCellValue() + "--");
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}