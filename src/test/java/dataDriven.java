import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class dataDriven {

    public ArrayList<String> getData(String testcaseName) throws IOException {

        ArrayList<String> a = new ArrayList<>();

        FileInputStream fis = new FileInputStream("/Users/telkomdev/Java/ExcelDriven/src/main/java/Framework/Main.java");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++) {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);

                //Identify test case column by scanning the entire 1st row
                //once column is identified, then scan entire testcase to identify purchase test case
                //after you grab purchase test case row, pull all the data of that row & feed into test


                //Identify test case column by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator(); //this got an ability to move to each and every row. which sheet is collectio of rows
                Row firstRow = rows.next(); //move to / read the first row

                Iterator<Cell> ce = firstRow.cellIterator(); //using Iterator cell. which row is collection of cells
                int k = 0; //increment while loop
                int column = 0; //initiate index of column
                while (ce.hasNext()) {
                    Cell value = ce.next(); //move to / read the first cell
                    if (value.getStringCellValue().equalsIgnoreCase("TestCases")){
                        //desired column
                        column = k;
                    }
                    k++;
                }

                //once column is identified, then scan entire testcase to identify purchase test case
                while (rows.hasNext()) {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName)){

                        //after you grab purchase test case row, pull all the data of that row & feed into test
                        Iterator<Cell> cv = r.cellIterator();
                        while (cv.hasNext()) {
                            Cell c = cv.next();
                            if (c.getCellType() == CellType.STRING){
                                a.add(c.getStringCellValue());
                            }else {
                                a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
                            }
                        }
                    }
                }
            }
        }
        return a;
    }

    public static void main(String[] args) throws IOException {


    }
}
