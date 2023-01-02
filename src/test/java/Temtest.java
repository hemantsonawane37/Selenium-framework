import basetest.BaseClass;
import testdata.TestData;

import java.io.IOException;
import java.util.HashMap;

public class Temtest extends BaseClass {
    public static void main(String[] args) throws IOException {
        TestData testData = new TestData("C:\\Users\\hemant\\OneDrive\\Documents\\Luma.xlsx");
        HashMap<String, String> map = testData.getTestDataFromExcel(new String[]{"firstname", "lastname", "email","password","confirmpassword"});
        Object[][] obj = new Object[][]{{map}};

        System.out.println(obj[0][0]);
    }
}
