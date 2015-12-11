package driver;

import java.util.HashMap;

import common.ReadDataSheet;
import constants.Constant_Class;
import general.Business_Process;
import reader.Data_Reader;

public class Driver_Script {
	ReadDataSheet RDS=new ReadDataSheet();
	Data_Reader DR=new Data_Reader();
	Constant_Class CC=new Constant_Class();
	Business_Process BP=new Business_Process();
	//ExcelWrite EW=new ExcelWrite();
	boolean dataReadflag=false;
	public static HashMap<String, String> hInputData=new HashMap<String, String>();
	String sworkbookName="";
	String sSheetName="";
	String sColumnNames="TCID,ON_1,BUSINESS_PROCESS,BUSINESS_FUNCTION,WHERE_STATUS,DATA";

	public void callScript() {
		// TODO Auto-generated method stub

		try				
		{
		//	DR.clear_Script_Data(sColumnNames);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		//
		//Step1: Read the data from OLS and OMS sheet
		try
		{
			hInputData=RDS.readDataSheet(Constant_Class.scriptName);
			//hInputData=DR.readData(hInputData,Constant_Class.input_Dotcom_WorkbookName,Constant_Class.input_Dotcom_SheetName,Constant_Class.scriptName);
			hInputData=DR.readData(hInputData,Constant_Class.input_Dotcom_WorkbookName,Constant_Class.input_Dotcom_SheetName,Constant_Class.scriptName);
//			hInputData=DR.readData(hInputData,Constant_Class.input_OLS_WorkbookName,Constant_Class.input_Dotcom_SheetName,Constant_Class.scriptName);					
		//	DR.read_Script(Constant_Class.scriptName,Constant_Class.input_Dotcom_SheetName,sColumnNames );
			System.out.println(hInputData.get("ORDERNUMBER"));
			dataReadflag=true;
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage()+"" );
		}
		
		//Step2: Read the scripts simultaneously
		try
		{
			if(dataReadflag)
			{
				for(int i=0;i<Constant_Class.TCID.size();i++)
				{
					Constant_Class.count=i;
					//hInputData=DR.put_script_Data_to_InputData(hInputData, i);
					Constant_Class.Environment_API=hInputData.get("ENVIRONMENT");
					BP.business_Process_Flow(hInputData);							
					
					
					
					
				}
					
				//logInfo("Script :------"+Constant_Class.TCID.get(0)+" Ends Here");
			}
		}
		catch (Exception e) {
//			
			System.out.println(e.getLocalizedMessage());
			System.out.println();
			e.printStackTrace();
		}
		
		finally
		{
			//Move to base State
			//Kill The IE browser
			//HL.restoreYantraToBase();
			
		}
}

	}

	
	
	

