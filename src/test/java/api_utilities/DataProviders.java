package api_utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        // Get the path to the Excel file
        String path = System.getProperty("user.dir") + "//testData/Untitled spreadsheet.xlsx";

        // Create an instance of XlUtility class and pass the file path
        XlUtility x1 = new XlUtility(path);

        // Get the number of rows and columns from the Excel sheet
        int rownum = x1.getRowCount("Sheet1");
        int colcount = x1.getCellCount("Sheet1", 1);

        // Initialize a 2D array to store the Excel data
        String apiData[][] = new String[rownum][colcount];

        // Loop through the rows and columns to read data from Excel and store it in the
        // array
        for (int i = 1; i < rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                // Get cell data
                String cellData = x1.getCellData("Sheet1", i, j);

                // Print cell data for debugging
                System.out.println("Cell Data: " + cellData);

                // Store the data in the array
                apiData[i - 1][j] = cellData;
            }
        }

        // Return the 2D array containing Excel data
        return apiData;
    }
}
