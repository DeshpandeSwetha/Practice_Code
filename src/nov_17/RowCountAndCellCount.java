package nov_17;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowCountAndCellCount
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
		//no. of cells in the first row
		int cc = row.getLastCellNum();
		System.out.println("No. of rows are::"+ rc+"No. of columns are::"+cc);
		fi.close();
		wb.close();
		
	}

}
