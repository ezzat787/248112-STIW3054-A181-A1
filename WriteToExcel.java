
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;


public class WriteToExcel {


    public void writeExcel(){
        try {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Wiki Malaysia TRIVIA");


            int rowCount = 0;

            for (Data adata : Scraper.ListAll() ) {

                Row row = sheet.createRow(rowCount++);


                Cell cel1 = row.createCell(0);
                cel1.setCellValue(adata.getCol1());

                Cell cel2 = row.createCell(1);
                cel2.setCellValue(adata.getCol2());

                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);

            }

            FileOutputStream out = new FileOutputStream(new File("E:\\WikiMalaysia.xlsx"));
            workbook.write(out);
            workbook.close();
            System.out.println("\nWikiMalaysia.xlsx written successfully");

        } catch (Exception e){
            System.out.println("error while trying to write data to WikiMalaysia.xlsx");
        }

    }

}
