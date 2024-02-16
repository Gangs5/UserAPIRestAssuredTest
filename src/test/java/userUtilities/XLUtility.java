package userUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtility {
	
	    public FileInputStream fi;
		public FileOutputStream fo;
		public XSSFWorkbook workbook;
		public XSSFSheet sheet;
		public XSSFCell cell;
		public XSSFRow row;
		public CellStyle style;
		String path;
		
		
		public XLUtility(String path) {this.path = path;}
		
		public int getRowCount(String sheetName)throws IOException {
			
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet =  workbook.getSheet(sheetName);
			int rowcount = sheet.getLastRowNum();
			workbook.close();
			fi.close();
			return rowcount;
			}
		
		public int getcellcount(String Sheetname, int rownum) throws IOException {
			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			sheet = workbook.getSheet(Sheetname);
		    row = sheet.getRow(rownum);
			int cellcount = row.getLastCellNum();
			workbook.close();
			fi.close();
			return cellcount;
			}
		
         public String getcelldata(String sheetname, int rownum, int cellnum, String data) throws IOException {
			
			fi= new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			
			sheet=workbook.getSheet(sheetname);
			 
			if(workbook.getSheetIndex(sheetname)==-1)
			workbook.createSheet(sheetname); 
			sheet=workbook.getSheet(sheetname);
			row=sheet.getRow(rownum);
			cell=row.getCell(cellnum);
			
			DataFormatter formatter= new DataFormatter();
			String data1;
			
			try {
				data1=formatter.formatCellValue(cell);
			}
			catch(Exception e)
			{
			data1="";	
			}
			return data1;
			}
			
				public String setcelldata(String sheetname, int rownum, int cellnum, String data) throws IOException {
			
			fi= new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
			 
			if(workbook.getSheetIndex(sheetname)==-1)
			workbook.createSheet(sheetname); 
			sheet=workbook.getSheet(sheetname);
			  
		  if(sheet.getRow(rownum)==null)
			 sheet.createRow(rownum);
			 sheet.getRow(rownum).createCell(cellnum).setCellValue(data);
			 fo = new FileOutputStream(path);
			 workbook.write(fo); 
			 workbook.close(); 
			 fi.close();
			 fo.close(); 
			 return data;
			 
		}
}

		



