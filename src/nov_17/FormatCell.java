package nov_17;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormatCell 
{

	public static void main(String[] args) throws Throwable 
	{
		//read path of file
		FileInputStream fi = new FileInputStream("D://Live_Project_Automation/Sample_1.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws = wb.getSheet("Emp");
		//count no. of rows in the sheet
		int rc = ws.getLastRowNum();
		//to color in green
		/*for(int i=1;i<=rc;i++)
		{
			ws.getRow(i).createCell(4).setCellValue("Pass");
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			//color status to green
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(i).getCell(4).setCellStyle(style);
			
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D://Live_Project_Automation/Sample_2.xlsx");
		wb.write(fo);
		wb.close();*/
		
		//to color in red
		/*for(int i=1;i<=rc;i++)
		{
			ws.getRow(i).createCell(4).setCellValue("Fail");
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			//color status to green
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(i).getCell(4).setCellStyle(style);
			
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D://Live_Project_Automation/Sample_2.xlsx");
		wb.write(fo);
		wb.close();*/
		
		//to color in blue
		for(int i=1;i<=rc;i++)
		{
			ws.getRow(i).createCell(4).setCellValue("Blocked");
			XSSFCellStyle style = wb.createCellStyle();
			XSSFFont font = wb.createFont();
			//color status to green
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(i).getCell(4).setCellStyle(style);
			
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("D://Live_Project_Automation/Sample_2.xlsx");
		wb.write(fo);
		wb.close();
		

	}

}