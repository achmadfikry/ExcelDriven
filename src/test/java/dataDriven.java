import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class dataDriven {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/Users/telkomdev/Java/ExcelDriven/src/main/java/Framework/Main.java");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                //Identify test case column by scanning the entire 1st row
                Iterator<Row> row = sheet.iterator(); //this got an ability to move to each and every row. which sheet is collectio of rows
                Row firstRow = row.next(); //move to / read the first row

                Iterator<Cell> ce = firstRow.cellIterator(); //using Iterator cell. which row is collection of cells
                while (ce.hasNext()) {
                    Cell value = ce.next(); //move to / read the first cell
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")){
                        //desired column
                    }
                }

            }

        }

    }
}
