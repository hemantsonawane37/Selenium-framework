package testdata;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import static basetest.BaseClass.GetPropertiesObjects;

public class TestData {

    private String Path = "";
    private XSSFWorkbook workbook;

    public TestData(String path) throws IOException {
        if (!this.Path.equals(path)) {
            this.Path = path;
            File file = new File(this.Path);
            FileInputStream fileInputStream = new FileInputStream(file);
            this.workbook = new XSSFWorkbook(fileInputStream);
        }
    }

    public HashMap<String, String> getTestDataFromExcel(String[] columns) throws IOException {
        XSSFSheet sheet = workbook.getSheet("test data");
        Iterator<Row> rowIterator = sheet.iterator();
        Iterator<Cell> headings = sheet.getRow(0).cellIterator();
        String testcaseidgloble = GetPropertiesObjects().getProperty("testcaseid");
        HashMap<String, String> hashMap = new HashMap<>();


        //skipping first row because it has headings only.
        Row row = rowIterator.next();


        // here we are first finding testcase_id
        // when we find out testcase_id we will got row were there will all column
        //like firstname, productName, email, etc.

        int TestCaseColumn = 0;
        while (rowIterator.hasNext()) {
            row = rowIterator.next();
            String testcaseid = row.getCell(TestCaseColumn).getStringCellValue();
            if (testcaseid.equals(testcaseidgloble)) {
                for (String col : columns) {
                    while (headings.hasNext()) {
                        Cell headingcell = headings.next();
                        if (headingcell.getStringCellValue().equalsIgnoreCase(col)) {
                            hashMap.put(col, row.getCell(headingcell.getColumnIndex()).getStringCellValue());
                            break;
                        }
                    }
                }
                return hashMap;
            }
        }

        return hashMap;
    }

}
