package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    /*
     * Excel file location.
     *
     * This points to:
     * src/main/resources/TestDataSwagLabs.xlsx
     */
    static String filePath =
            "C:\\Users\\ashit\\eclipse-workspace\\SwagLabsSauceDemo"
            + "\\src\\main\\resources\\TestDataSwagLabs.xlsx";


    /*
     * ==========================================
     * METHOD: Read data from Excel
     * ==========================================
     *
     * row = Excel row number
     * col = Excel column number
     *
     * Example:
     *
     * getCellData(1, 0) -> Username
     * getCellData(1, 1) -> Password
     * getCellData(1, 2) -> First Name
     * getCellData(1, 3) -> Last Name
     * getCellData(1, 4) -> ZIP Code
     *
     * DataFormatter is used because:
     *
     * Username, Password, FirstName and LastName
     * are normally stored as text.
     *
     * ZIP Code may be stored as a number.
     *
     * DataFormatter converts both text and numbers
     * into String format.
     */
    public static String getCellData(int row, int col)
            throws IOException {

        // Open the Excel file for reading
        FileInputStream fis =
                new FileInputStream(filePath);

        // Create workbook object
        XSSFWorkbook wb =
                new XSSFWorkbook(fis);

        /*
         * Get the worksheet named LoginPage.
         *
         * Make sure the Excel sheet tab is named exactly:
         * LoginPage
         */
        XSSFSheet sheet =
                wb.getSheet("LoginPage");


        // Check whether the sheet exists
        if (sheet == null) {

            wb.close();
            fis.close();

            throw new RuntimeException(
                    "Sheet 'LoginPage' not found"
            );
        }


        // Check whether the requested row exists
        if (sheet.getRow(row) == null) {

            wb.close();
            fis.close();

            throw new RuntimeException(
                    "Row not found: " + row
            );
        }


        // Check whether the requested cell exists
        if (sheet.getRow(row).getCell(col) == null) {

            wb.close();
            fis.close();

            throw new RuntimeException(
                    "Cell not found. Row: "
                    + row
                    + ", Column: "
                    + col
            );
        }


        /*
         * DataFormatter reads the cell exactly as it appears
         * in Excel and returns it as a String.
         *
         * Examples:
         *
         * John   -> "John"
         * 560001 -> "560001"
         */
        DataFormatter formatter =
                new DataFormatter();

        String data =
                formatter.formatCellValue(
                        sheet.getRow(row).getCell(col)
                );


        // Close workbook and input stream
        wb.close();
        fis.close();


        // Return the Excel value
        return data;
    }


    /*
     * ==========================================
     * METHOD: Write data into Excel
     * ==========================================
     *
     * Example:
     *
     * setCellData(7, 1, "Login Attempted");
     */
    public static void setCellData(
            int row,
            int col,
            String value) throws Exception {

        // Open the Excel file
        FileInputStream fis =
                new FileInputStream(filePath);

        // Create workbook object
        XSSFWorkbook wb =
                new XSSFWorkbook(fis);

        // Get the worksheet named LoginPage
        XSSFSheet sheet =
                wb.getSheet("LoginPage");


        // Check whether the sheet exists
        if (sheet == null) {

            wb.close();
            fis.close();

            throw new RuntimeException(
                    "Sheet 'LoginPage' not found"
            );
        }


        /*
         * If the row does not exist,
         * create a new row.
         */
        if (sheet.getRow(row) == null) {

            sheet.createRow(row);
        }


        /*
         * Create the requested cell
         * and write the value.
         */
        sheet.getRow(row)
             .createCell(col)
             .setCellValue(value);


        // Open the Excel file for writing
        FileOutputStream fos =
                new FileOutputStream(filePath);

        // Save changes into Excel
        wb.write(fos);


        // Close all resources
        wb.close();
        fos.close();
        fis.close();
    }
}