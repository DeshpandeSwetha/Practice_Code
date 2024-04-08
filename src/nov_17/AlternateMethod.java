package nov_17;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AlternateMethod
{

	public static void main(String[] args) throws Throwable 
	{
		//read path of file
		FileInputStream fi = new FileInputStream("D://Live_Project_Automation/Sample_1.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws = wb.getSheet("Emp");
		//get first row from the sheet
		XSSFRow row = ws.getRow(0);
		//count no. of rows in the sheet
		int rc = ws.getLastRowNum();
		//print each cell data
		String fname = ws.getRow(4).getCell(0).getStringCellValue();
		String middlename = ws.getRow(3).getCell(1).getStringCellValue();
		String lastname = ws.getRow(10).getCell(2).getStringCellValue();
		int eid = (int) ws.getRow(5).getCell(3).getNumericCellValue();
		System.out.println(fname+"   "+middlename+"   "+lastname+"   "+eid);
		fi.close();
		wb.close();

	}

}
