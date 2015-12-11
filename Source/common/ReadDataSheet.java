package common;

import java.io.File;

import jxl.Sheet;
import jxl.Workbook;

public class ReadDataSheet {

	 
 	public String TCID;
 	public String TDID;
 	public String MODIFICATION;
 	public String QUANTITY;
 	
 	public  String tdid,qty,modification;
 	
 	
 	
	public String getTCID() {
		return TCID;
	}
	public void setTCID(String tCID) {
		TCID = tCID;
	}
	public String getTDID() {
		return TDID;
	}
	public void setTDID(String tDID) {
		TDID = tDID;
	}
	public String getMODIFICATION() {
		return MODIFICATION;
	}
	public void setMODIFICATION(String mODIFICATION) {
		MODIFICATION = mODIFICATION;
	}
	public String getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(String qUANTITY) {
		QUANTITY = qUANTITY;
	}
	
	
	
	
	public void readDataSheet(String testcase,String excelWorkbookName)
	{
		ReadDataSheet rs=new ReadDataSheet();
		try{
		String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
		   String exPath = workingDir +"\\TestScripts\\Data\\"+excelWorkbookName+".xls" ;
		File file = new File(exPath);
		System.out.println(" "+file);
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sheet = wb.getSheet(0);
		int rows = sheet.getRows();
		int column=sheet.getColumns();
		System.out.println("Rows "+rows);
		System.out.println("Column: "+column);
		
		
		for(int i=0;i<rows;i++)
		{
			rs.setTCID(sheet.getCell(0,i).getContents());
			if(testcase.equalsIgnoreCase(rs.getTCID())){
				rs.setMODIFICATION(sheet.getCell(2,i).getContents());
				rs.setTDID(sheet.getCell(1,i).getContents());
				rs.setQUANTITY(sheet.getCell(3, i).getContents());
			
			}
		}
		
		tdid=rs.getTDID();
		qty=rs.getQUANTITY();
		
		
		
		 //sheet.getCell("TCID").getContents();
		
		System.out.println("check : "+tdid+ "  qty "+qty );
		
		
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		}
 	
	
	public static void main(String g[])
	{
		ReadDataSheet rs=new ReadDataSheet();
		rs.readDataSheet("Test_Condition_2","DATASHEET");
	}
	
	
}
