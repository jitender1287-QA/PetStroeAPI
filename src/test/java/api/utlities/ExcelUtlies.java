package api.utlities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtlies {
 
	public static FileInputStream file;
	public static FileOutputStream fileouput;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static CellStyle style;
	 String path;
	 public ExcelUtlies(String path) {
		 this.path=path;
	 }
	public  int getRowCount( String sheetname) throws IOException {
		file=new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetname);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		file.close();
		return rowcount;
	}
	public  int getCellcount(String sheetname,int rownum) throws IOException {
		file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		file.close();
		return cellcount;
	}
	
	public  String getcellData(String sheetname,int rownum,int colum) throws IOException {
		file=new FileInputStream(path);
		try {
			workbook=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell=row.getCell(colum);
		String data;
		try {
			//data=cell.toString();
			DataFormatter fomatter = new DataFormatter();
		data=fomatter.formatCellValue(cell);
		}
		catch(Exception e){
			data="";
		}
		
		workbook.close();
		file.close();
		return data;
		
	}
	
	public static void setcellData(String xlfile ,String Xlsheet,int rownum,int colum,String data) throws IOException {
		
		file=new FileInputStream(xlfile);
		try {
			workbook=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(Xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colum);
		cell.setCellValue(data);
		fileouput= new FileOutputStream(xlfile);
		workbook.close();
		file.close();
		fileouput.close();
		
	}
	public static void fillcolorgreen(String xlfile ,String Xlsheet,int rownum,int colum) throws IOException {

		file=new FileInputStream(xlfile);
		try {
			workbook=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(Xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colum);
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fileouput=new FileOutputStream(xlfile);
		workbook.write(fileouput);
		workbook.close();
		fileouput.close();
		file.close();
		
	}
	public static void fillcolored(String xlfile ,String Xlsheet,int rownum,int colum) throws IOException {

		file=new FileInputStream(xlfile);
		try {
			workbook=new XSSFWorkbook(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(Xlsheet);
		row=sheet.getRow(rownum);
		cell=row.createCell(colum);
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fileouput=new FileOutputStream(xlfile);
		try {
			workbook.write(fileouput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		workbook.close();
		fileouput.close();
		file.close();
		
	}
	
}
