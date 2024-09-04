package ExcelFileUtil;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelfileutil {
	
	XSSFWorkbook wb;
	public Excelfileutil(String Excelpath) throws Throwable {
		FileInputStream fi=new FileInputStream(Excelpath);
		 wb = new XSSFWorkbook(fi);
	}
public int rowcount(String Sheetname) {
	return wb.getSheet(Sheetname).getLastRowNum();
	}
public String getcellData(String Sheetname,int row ,int column) {
	String data;
	
	if(wb.getSheet(Sheetname).getRow(row).getCell(column).getCellType()==CellType.NUMERIC) {
		int celldata=(int)wb.getSheet(Sheetname).getRow(row).getCell(column).getNumericCellValue();
		data=String.valueOf(celldata);
	}
	else {
		data=wb.getSheet(Sheetname).getRow(row).getCell(column).getStringCellValue();
	}
	return data;
	}

public void setcellData(String Sheetname,int rows,int column,String Status,String WriteExcel) throws Throwable {
	
	XSSFSheet ws = wb.getSheet(Sheetname);
	XSSFRow rownum = ws.getRow(rows);
	XSSFCell cell = rownum.createCell(column);
	cell.setCellValue(Status);
	if(Status.equalsIgnoreCase("pass")) {
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.GREEN.getIndex());
		font.setBold(true);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	}
	else if(Status.equalsIgnoreCase("Fail")) {
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.RED.getIndex());
		font.setBold(true);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	}
	else if(Status.equalsIgnoreCase("Blocked"))	{
		XSSFCellStyle style = wb.createCellStyle();
		XSSFFont font = wb.createFont();
		font.setColor(IndexedColors.BLACK.getIndex());
		font.setBold(true);
		style.setFont(font);
		rownum.getCell(column).setCellStyle(style);
	}
	FileOutputStream fo=new FileOutputStream( WriteExcel) ;
	wb.write(fo);
	}
}

