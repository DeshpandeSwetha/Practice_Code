package nov_17;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Convert 
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
		for(int i=1;i<=rc;i++)
		{
			if(wb.getSheet("Emp").getRow(i).getCell(3).getCellType()==CellType.NUMERIC)
			{
				int celldata = (int) wb.getSheet("Emp").getRow(i).getCell(3).getNumericCellValue();
				//convert int to string type
				String eid = String.valueOf(celldata);
				System.out.println(eid);
			}
		}

	}

}
