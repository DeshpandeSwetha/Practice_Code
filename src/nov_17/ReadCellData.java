package nov_17;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCellData
{

	public static void main(String[] args) throws Throwable 
	{
		//read path of file
		FileInputStream fi = new FileInputStream("D://Live_Project_Automation/Sample_1.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws = wb.getSheetAt(0);
		//count no. of rows in the sheet
		int rc = ws.getLastRowNum();
		//get 10th row from the sheet
		XSSFRow row = ws.getRow(9);
		//get each cell
		XSSFCell c1 = row.getCell(0);
		XSSFCell c2 = row.getCell(1);
		XSSFCell c3 = row.getCell(2);
		XSSFCell c4 = row.getCell(3);
		String fname = c1.getStringCellValue();
		String middlename = c2.getStringCellValue();
		String lastname = c3.getStringCellValue();
		int eid = (int) c4.getNumericCellValue();
		System.out.println(fname+"   "+middlename+"   "+lastname+"   "+eid);
		fi.close();
		wb.close();

	}

}
