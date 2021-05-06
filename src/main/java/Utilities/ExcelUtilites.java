package Utilities;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class ExcelUtilites {

    public String readExcel(String SheetName,String ColumnName)
            throws EncryptedDocumentException, InvalidFormatException, IOException {
        File file = new File(Constant_Inputs.Path_TestData);
        FileInputStream fi = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fi);
        Sheet sheet = wb.getSheet(SheetName);
        // it will take value from first row
        Row row = sheet.getRow(0);
        // it will give you count of row which is used or filled
        short lastcolumnused = row.getLastCellNum();

        int colnum = 0;
        for (int i = 0; i < lastcolumnused; i++) {
            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
                colnum = i;
                break;
            }
        }

        // it will take value from Second row
        row = sheet.getRow(1);
        org.apache.poi.ss.usermodel.Cell column = row.getCell(colnum);
        String CellValue = column.getStringCellValue();
        return CellValue;
    }



    /*-----------------To write output in the Excel File------------------------------*/


    public void writeValueInExcel(String sheetName,String ColumnName,String value) throws EncryptedDocumentException, InvalidFormatException, IOException {
        //System.out.println("under calling excel");
        File file = new File("D:\\WheelsEMI\\WEMI_UsedTw\\UsedTW\\excelFiles\\UserIDPasswords.xlsx");
        FileInputStream fi = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fi);
        org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet(sheetName);
        // it will take value from first row
        Row row = sheet.getRow(0);
        // it will give you count of row which is used or filled
        short lastcolumnused = row.getLastCellNum();

        int colnum = 0;
        for (int i = 0; i < lastcolumnused; i++) {
            if (row.getCell(i).getStringCellValue().equalsIgnoreCase(ColumnName)) {
                //System.out.println("Found column name");
                colnum = i;
                break;
            }
        }

        System.out.println(colnum);
        // it will take value from Second row
        row = sheet.getRow(1);
        //org.apache.poi.ss.usermodel.Cell column = row.getCell(colnum);
        Cell columnNew = row.getCell(colnum);
        //System.out.println("column number is :="+columnNew);
        columnNew.setCellValue(value);
        FileOutputStream outputStream = new FileOutputStream(file);
        wb.write(outputStream);
        outputStream.close();
    }

}
