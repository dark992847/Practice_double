package XMLPrac;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class xmlDummy {
	
	@Test
	public void dummy() throws IOException{
		System.out.println("dark");
		FileInputStream fis=new FileInputStream("C://temp//dark.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int column=0;
//		ArrayList<Object> array=new ArrayList<Object>();
		int count= workbook.getNumberOfSheets();
		System.out.println("Count "+count);
		for(int i=0;i<count;i++) {
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase("dummy")) {
				System.out.println("Sheet at Index "+i);
				XSSFSheet sheet=workbook.getSheetAt(i);
				System.out.println("SheetName "+sheet.getSheetName());
				Iterator<Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				Iterator<Cell> cells=firstRow.cellIterator();
				while(cells.hasNext()) {
					Cell cell=cells.next();
					System.out.println("column name "+cell.getStringCellValue());
					if(cell.getStringCellValue().equalsIgnoreCase("Testcase")) {
						break;
						
					}
					column++;
				}
				while(rows.hasNext()) {
					Row row=rows.next();
					if(row.getCell(column).getStringCellValue().equalsIgnoreCase("flipkart")) {
						Iterator<Cell> cells1=row.iterator();
						while(cells1.hasNext()) {
							Cell cell1=cells1.next();
							System.out.println(cell1.getStringCellValue());
						}
					}
				}
				
			}
			
		}
		
	}
	

}
