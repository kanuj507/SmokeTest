package dto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDto {
	
	public static ArrayList<String>  getExecute=new ArrayList();
	public static ArrayList<String>  executeTCID=new ArrayList();
	public ArrayList<String> getGetExecute() {
		return getExecute;
	}
	public void setGetExecute(ArrayList<String> string) {
		this.getExecute = string;
	}




	public String 	TCID = null;
	private String ACTIONS = null;
	private String ID_TYPE = null;
	private String VALUE = null;
	private String DATA = null;
	private String 	TDID = null;
	private String SKUValue = null;
	private int QTY;
	//private String VALUE = null;

	public String 	EXECUTE = null;
	
	
	public String getEXECUTE() {
		return EXECUTE;
	}
	public void setEXECUTE(String eXECUTE) {
		EXECUTE = eXECUTE;
	}
	public String getTCID() {
		return TCID;
	}
	public void setTCID(String tCID) {
		TCID = tCID;
	}
	public String getACTIONS() {
		return ACTIONS;
	}
	public void setACTIONS(String aCTIONS) {
		ACTIONS = aCTIONS;
	}
	public String getID_TYPE() {
		return ID_TYPE;
	}
	public void setID_TYPE(String iD_TYPE) {
		ID_TYPE = iD_TYPE;
	}
	public String getVALUE() {
		return VALUE;
	}
	public void setVALUE(String vALUE) {
		VALUE = vALUE;
	}
	public String getDATA() {
		return DATA;
	}
	public void setDATA(String dATA) {
		DATA = dATA;
	}
	public String getTDID() {
		return TDID;
	}
	public void setTDID(String tDID) {
		TDID = tDID;
	}
	public String getSKUValue() {
		return SKUValue;
	}
	public void setSKUValue(String sKUValue) {
		SKUValue = sKUValue;
	}
	public int getQTY() {
		return QTY;
	}
	public void setQTY(int qTY) {
		QTY = qTY;
	}
	
	
	
	
	public static void main(String g[]) 
	{
		DataDto ddto=new DataDto();
		try{
		ArrayList<String> executeTC = new ArrayList();
		String execute = null;
		  String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
		   String exPath = workingDir +"\\TestScripts\\Data\\Execute_Script.xls" ;
		File file = new File(exPath);
		System.out.println(" "+file);
		Workbook wb = Workbook.getWorkbook(file);
		Sheet sheet = wb.getSheet(0);
		int rows = sheet.getRows();
		int column=sheet.getColumns();
		System.out.println("Rows "+rows);
		for(int i=1;i<rows;i++)
		{
			ddto.setTCID(sheet.getCell(0, i).getContents());
			ddto.setEXECUTE(sheet.getCell(1, i).getContents());
			if(ddto.getEXECUTE().equalsIgnoreCase("Y"))
			{
			getExecute.add(ddto.getEXECUTE()); 
			executeTCID.add(ddto.getTCID());
			}
		}
	System.out.println("execute condition :" +executeTCID);
	System.out.println(getExecute);
		
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
