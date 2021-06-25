package pages;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class testExcel {

    public static void main(String[] args) {
        try {
            File file = new File("E:\\test.xlsx");   //creating a new file instance  
            FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
//creating Workbook instance that refers to .xlsx file  
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
            Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
            while (itr.hasNext()) {
                Row row = itr.next();
                Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
                if(row.getRowNum()==0){
                        continue;
                    }
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                        if(cell.getColumnIndex() == 0){
                         System.out.print(cell.getCellType());   
                        
                    }
                }
                System.out.println("");
                System.out.println("--------------This is row-----------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
