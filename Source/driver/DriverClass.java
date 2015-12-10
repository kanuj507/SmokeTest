package driver;
/*
public class DriverClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Class.forName("oracle.jdbc.driver.OracleDriver");
          con = DriverManager.getConnection("jdbc:oracle:thin:@(description=(load_balance=on)(failover=on)(address=(protocol=tcp)(host=dlocdb06)(port=50000))(connect_data=(service_name=ot01eodbsvc.world)(failover_mode=(type=select)(method=basic))(server=dedicated)))", "omsreadonly", "support");
	}

}*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import constants.Constant_Class;
public class DriverClass {
    Connection con;
    static DriverClass DC =new DriverClass();
    Driver_Script DS=new Driver_Script();
    
  //modify_orderLevelLOS
  	public Connection conn = null;
  	//statements object used to run queries 
  	public Statement stmnt = null; 
  	//string object used to create queries
  	public String testCaseQuery, DQuery;
  	// ResultSet Object to hold the Query Result
  	public ResultSet rs_Lable;
  	public ResultSetMetaData rsdata_Table;
    public void connectionMethod() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@(description=(load_balance=on)(failover=on)(address=(protocol=tcp)(host=dlocdb06)(port=50000))(connect_data=(service_name=ot01eodbsvc.world)(failover_mode=(type=select)(method=basic))(server=dedicated)))", "omsreadonly", "support");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    
    public void connectToExcel(String excelName) throws Exception
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

		   String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
		String exPath = workingDir +"\\Data\\"+ excelName ;

		System.out.println("Path of the Excel :"+exPath);

		conn = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + exPath + "; READONLY=false");
		System.out.println("connection : "+conn.getCatalog());

		stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		System.out.println("statement : "+stmnt);

	}
    
    public ArrayList<String>  get_ScriptIDs( String excelWorkbookName,String sheetName) throws Exception
	{
		ArrayList<String> testCasesNames = new ArrayList<String>();
		connectToExcel(excelWorkbookName+".xls");
		testCaseQuery = "Select TCID From ["+sheetName +"$] where Execute='Y'";
		rs_Lable = stmnt.executeQuery(testCaseQuery);
		rsdata_Table= rs_Lable.getMetaData(); 

		String colName = "";
		while(rs_Lable.next())
		{
			if(rs_Lable.getString("TCID")!=null)
			{	
				testCasesNames.add(rs_Lable.getString("TCID"));
			}
		}
			
		return testCasesNames;
	}
    public static void main(String[] args) throws Exception {
    	
	System.out.println("started");
		
		Constant_Class.input_Dotcom_WorkbookName="Execute_Script";
		Constant_Class.input_Dotcom_SheetName="SmokeTest";
		
		DC.execute();
    //	ArrayList<String> temparray = new ArrayList<String>();
		//temparray= DC.get_ScriptIDs(Constant_Class.input_Dotcom_WorkbookName,Constant_Class.input_Dotcom_SheetName);
    }
	private void execute() {
		// TODO Auto-generated method stub
	
		try
		{
			ArrayList<String> temparray = new ArrayList<String>();
			temparray= get_ScriptIDs(Constant_Class.input_Dotcom_WorkbookName,Constant_Class.input_Dotcom_SheetName);//General_OrderCreate
			
			for(int numTestCases=0;numTestCases<temparray.size();numTestCases++)
				
			{
				
				System.out.println(temparray.get(numTestCases));
				Constant_Class.scriptName=temparray.get(numTestCases);
				try
				{
					//EW.setExcelHeader(temparray.get(numTestCases));
					//callScript("KD.Driver_Script");//General_OrderCreation_Script
					
					DS.callScript();
					Constant_Class.count=0;
				}
				catch (Exception e) {
				e.printStackTrace();	
				System.out.println(e.getMessage());
				}
				System.out.println("calling script : "+temparray.get(numTestCases));
			  
			   
			}
			/*Reporter.BusinessProcessReporter.removeAllAppenders();
			Reporter.emailReporter.removeAllAppenders();*/
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage()+"");
			
		
		}
	}
}         

