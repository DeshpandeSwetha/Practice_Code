package nov_17;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AllRowsCellData 
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
			String fname = ws.getRow(i).getCell(0).getStringCellValue();
			String middlename = ws.getRow(i).getCell(1).getStringCellValue();
			String lastname = ws.getRow(i).getCell(2).getStringCellValue();
			int eid = (int) ws.getRow(i).getCell(3).getNumericCellValue();
			System.out.println(fname+"   "+middlename+"   "+lastname+"   "+eid);
			//write pass into status cell
			ws.getRow(i).createCell(4).setCellValue("Pass");
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D://Live_Project_Automation/Results_1.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
