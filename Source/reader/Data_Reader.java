package reader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import constants.Constant_Class;

/*
public class Data_Reader {

}
*/
public class Data_Reader
{
	/**
	 * Script Name   : <b>Data_Read</b>
	 * Generated     : <b>May 14, 2013 7:05:21 AM</b>
	 * Description   : Functional Test Script
	 * Original Host : WinNT Version 6.1  Build 7601 (S)
	 * 
	 * @since  2013/05/14
	 * @author a158907
	 */
	
	
	
	

	 //connection object used to make connections to the excel sheets
	 public Connection conn = null;
	 //statements object used to run queries 
	 public Statement stmnt = null; 
	 //string object used to create queries
	 public String LQuery, DQuery;
	 // ResultSet Object to hold the Query Result
	 public ResultSet rs_Lable;
	    
	 // Metadata Object is created to get the Column Count
	 public ResultSetMetaData rsdt_Lable;
//	   Constant_Class CC=new Constant_Class();
	 static String script="";
	 static String sheet;
//	 Data_Store ds = new Data_Store();
	 public ResultSet rs;
	
	//---------------------------------------- FUNCTION DEFINITIONS --------------------------------------------------------
	 
	 	
	
	
	
	
	
	
	
	 /**
	    * 
	    *    
	    * @throws Exception
	    */
	   public void Open(String sExcelBoookname, String folderName) throws Exception
	   {
	    System.out.println("Inside Function Open()");
	    try{
	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
	     String dbURL = "jdbc:odbc:ExcelDB";
	     
	     String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
	     String FN = workingDir + "\\TestScripts\\"+"\\"+folderName+"\\"+sExcelBoookname+".xls" ;
	     System.out.println("Complete Excel Path :"+FN);
	     //conn = DriverManager.getConnection(dbURL,"",""); // username,
	     conn = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + FN + "; READONLY=false");
	      
	     //jdbcdbc:"+DatabaseName
	    // System.out.println(conn);
	     stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    // System.out.println(stmnt);
	    }
	    catch (Exception e) {
	     System.out.println(e.getMessage());
	    }
	        
	   }
	
	   /**
	    * 
	    *    
	    * @throws Exception
	    */
	   public void Open(String sExcelBoookname) throws Exception
	   {
	    System.out.println("Inside Function Open()");
	    try{
	     Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
	     String dbURL = "jdbc:odbc:ExcelDB";
	     String workingDir = System.getProperty("user.dir");
		   System.out.println("Current working directory : " + workingDir);
	     String FN = workingDir + "\\Data\\"+sExcelBoookname+".xls" ;
	     System.out.println("Complete Excel Path :"+FN);
	     //conn = DriverManager.getConnection(dbURL,"",""); // username,
	     conn = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + FN + "; READONLY=false");
	      
	     //jdbcdbc:"+DatabaseName
	    // System.out.println(conn);
	     stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    // System.out.println(stmnt);
	    }
	    catch (Exception e) {
	     System.out.println(e.getMessage());
	    }
	        
	   }
	
	   public HashMap<String, String> Get_Record(HashMap<String, String> hdata,String excelSheetName,String script)throws Exception
	   {
		   	System.out.println("Get_Record - Inside Get_Record");
		   
			int intRsLablelength = 0;
			int intDataCount=0;
			String strDataStoreValue[] = new String[1];
			String strDataStVal = ""; 
		       
		     try
		     {
		    	 LQuery = "Select * From ["+excelSheetName+"$] WHERE TCID = '"+script+"'";
			     rs_Lable = stmnt.executeQuery(LQuery);
			     System.out.println("Get_Record - Executed SQL Query");
		     }
		     catch (Exception e)
		     {
		    	 System.out.println(e.toString());
		    	 e.printStackTrace();
		     }
		     
		     try
		     {
		    	 rsdt_Lable= rs_Lable.getMetaData(); 
		    	 int intRowCount = 0;
			      
		    	 while ( rs_Lable.next() )
			     intRowCount++;
			      
			     if(intRowCount<=2)
			     {
			    	rs_Lable.beforeFirst();
			        System.out.println("Get_Record - Total row count is "+ intRowCount);
			        while(rs_Lable.next())
			        {
			        	intRsLablelength = rsdt_Lable.getColumnCount();
			        	
			            System.out.println("Get_Record - Column count: "+intRsLablelength);
			            //System.out.println(rs_Lable.getRow());
			            for(int i=1;i<=intRsLablelength;i++)
			            {
				           String strColumnName = rs_Lable.getMetaData().getColumnName(i);
				           System.out.println("Get_Record - Excel column name: "+ strColumnName);
				           //System.out.println("Coloumn Type : "+rsdt_Lable.getColumnClassName(i));
				           //String columnClassName = rsdt_Lable.getColumnClassName(i);

					        if(rs_Lable.getObject(strColumnName)!=null)
					        {
					         	strDataStVal=rs_Lable.getObject(strColumnName).toString();
					         	System.out.println("Get_Record - Excel column value: "+ strDataStVal);
					         	
					            if(strDataStVal!=null)   
					            {
					            	if (strDataStoreValue.length>=1)
					            	{
					            		if((strDataStVal.indexOf("\"")==0) && (strDataStVal.lastIndexOf("\"")==strDataStVal.length()-1))
					            		{
					            			System.out.println("Get_Record - Removed double quotes from : "+ strDataStVal);
					            			strDataStVal=strDataStVal.substring(1,strDataStVal.length()-1);
					            			System.out.println("Get_Record - After removing double quotes : "+ strDataStVal);
					            		}
					            		
					            		String strTempStore[]= new String[strDataStoreValue.length+1];
							            System.arraycopy(strDataStoreValue, 0, strTempStore, 0, strDataStoreValue.length);
							            strDataStoreValue=strTempStore;
					            	}
					            	strDataStoreValue[intDataCount]=strDataStVal;
					            	intDataCount++; 
					            }
					        }
					        else
					        {
					        	break;
					        }
			            }
			        }
			        System.out.println("Get_Record - Value read from record set");
			        System.out.println("Get_Record - Store value from Record set to Data Hashmap");
			        int intLen=strDataStoreValue.length;
			        for ( int i=0;i<intLen/2;i++)
			        {
			        	hdata.put(strDataStoreValue[i], strDataStoreValue[intLen/2+i]);
			        	//System.out.println("Get_Record - "+strDataStoreValue[i]+" value is : "+ds.get(strDataStoreValue[i]));
			        }
		      }
	          else 
	          {
	        	  System.out.println("Get_Record - Retrieved More than 2 rows for "+script); 
		      }
			      
	     }
		 catch(SQLException e)
		 {
			 if(e.getErrorCode() == -5017)
			 {
				 System.out.println("Get_Record - please convert int value to string by using \" at start and ends");
			 }
			 else
			 {
				 System.out.println(e);
			     e.printStackTrace(); 
			 }
			 System.out.println(e);
		 }
		 catch(Exception e)
	     { 
		       System.out.println(e);
		       e.printStackTrace();
	     }
		     
	     Excel_Reader.script = script;
	     Close();
	     return hdata;
		   
	   }
	   
	   public void Close() throws Exception
	   {
	       try
	       {
	         rs_Lable.close();
	         stmnt.close();
	         conn.close();
	       }
	       
	       catch (Exception e) 
	       {
	         System.out.println(e.toString());
	         e.printStackTrace();
	       }
	   }
	   
	   
	   public HashMap<String, String> readData(HashMap<String, String> hdata,String sExcelBoookname,String sheetname,String scriptName)
	   {
		   try
		   {
			   Open(sExcelBoookname);
			   hdata=Get_Record(hdata,sheetname, scriptName);
		   }
		   catch (Exception e) {
			System.out.println("Error in data read : with error msg : ----"+e.getLocalizedMessage());
		}
		   return hdata;
	   }
	   
	   
	   
	   public ArrayList<String> read_Single_Row( String excelSheetName,String column_Name) throws Exception
	   {
		 
		   System.out.println("Get_Record - Inside Get_Record");
		   
			int intRsLablelength = 0;
			int intDataCount=0;
			ArrayList<String> data=new ArrayList<String>();
			String strDataStVal = ""; 
		       
		     try
		     {
		    	 LQuery = "Select "+column_Name+" From ["+excelSheetName+"$]";
			     rs_Lable = stmnt.executeQuery(LQuery);
			     System.out.println("Get_Record - Executed SQL Query");
		     }
		     catch (Exception e)
		     {
		    	 System.out.println(e.toString());
		    	 e.printStackTrace();
		     }
		     ResultSetMetaData RSM=rs_Lable.getMetaData();
		     while(rs_Lable.next())
 			{
 				System.out.println("Column count: "+RSM.getColumnCount());
 				if(rs_Lable.getObject(column_Name).toString()!=null)
 				{
 					String temp="";
 					temp=rs_Lable.getObject(column_Name).toString();
 					if((temp.indexOf("\"")==0) && (temp.lastIndexOf("\"")==temp.length()-1))
            		{
            			System.out.println("Get_Record - Removed double quotes from : "+ temp);
            			temp=temp.substring(1,temp.length()-1);
            			System.out.println("Get_Record - After removing double quotes : "+ temp);
            			
            		}
 					data.add(temp);
 					
 				}
 			}
		  
	     Excel_Reader.script = script;
	     Close();
	     return data;
	   }
	   
	   public void read_Script( String workBookName,String foldername,String columnNames) throws Exception
	   {
		   ArrayList<String> TCCID=new ArrayList<String>();
		   String[] columnName= columnNames.split(",");
		   
		   HashMap<String, ArrayList<String>> hColumnnames=new HashMap<String, ArrayList<String>>();
		   hColumnnames.put("TCID", Constant_Class.TCID);
		   hColumnnames.put("BUSINESS_PROCESS",Constant_Class.BUSINESS_PROCESS);
		   hColumnnames.put("ON_1",Constant_Class.ON);
		   hColumnnames.put("BUSINESS_FUNCTION",Constant_Class.BUSINESS_FUNCTION);
		   hColumnnames.put("WHERE_STATUS",Constant_Class.WHERE_STATUS);
		   hColumnnames.put("DATA",Constant_Class.DATA);
		   for(int i=0;i<columnName.length;i++)
		   {
			   Open(workBookName,foldername);			
			   hColumnnames.get(columnName[i]).addAll(read_Single_Row(workBookName,columnName[i]));
		   }
		 
	   }
	  
	   public void clear_Script_Data( String columnNames) throws Exception
	   {
		   Constant_Class.TCID.clear();
		   Constant_Class.BUSINESS_PROCESS.clear();
		   Constant_Class.ON.clear();
		   Constant_Class.BUSINESS_FUNCTION.clear();
		   Constant_Class.WHERE_STATUS.clear();
		   Constant_Class.DATA.clear();
	
		 
	   } 
	   
	   public HashMap<String, String> put_script_Data_to_InputData(HashMap<String, String> hdata, int rowCounter)
	   {
		   hdata.put("TCID", Constant_Class.TCID.get(rowCounter));
		   hdata.put("BUSINESS_PROCESS", Constant_Class.BUSINESS_PROCESS.get(rowCounter));
		   hdata.put("ON_1", Constant_Class.ON.get(rowCounter));
		   hdata.put("BUSINESS_FUNCTION", Constant_Class.BUSINESS_FUNCTION.get(rowCounter));
		   hdata.put("WHERE_STATUS", Constant_Class.WHERE_STATUS.get(rowCounter));
		   hdata.put("DATA", Constant_Class.DATA.get(rowCounter));
		   return hdata;
	   }
	public void testMain(Object[] args) throws Exception 
	{
		HashMap<String, String> hdata=new HashMap<String, String>();
		hdata=readData(hdata,"OMS_DATASHEET","Dotcom","MUCHL_MCCP_FULMT_FN01");
		hdata=readData(hdata,"OMS_DATASHEET","Dummy","ABC");
				System.out.println(hdata.get("ORDERNO"));
				System.out.println(hdata.get("My_Name"));
		read_Script("OMS_DATASHEET","RND","TCID,ON_1,BUSINESS_PROCESS,BUSINESS_FUNCTION,WHERE_STATUS,DATA");
		
		for(int i=0;i<Constant_Class.TCID.size();i++)
		{
			System.out.println(Constant_Class.TCID.get(i));
			System.out.println(Constant_Class.BUSINESS_PROCESS.get(i));
			System.out.println(Constant_Class.ON.get(i));
			System.out.println(Constant_Class.BUSINESS_FUNCTION.get(i));
			System.out.println(Constant_Class.WHERE_STATUS.get(i));
			System.out.println(Constant_Class.DATA.get(i));
		}
	
		
	}
}

