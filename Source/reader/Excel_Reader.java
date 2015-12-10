package reader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import resources.Data_Store;

public class Excel_Reader
{
//----------------------------------------- GLOBAL DECLARATIONS -------------------------------------------------------- 
 
 public static String sWorkBookName="";
 public static String sWorkSheetName="";
 
 
 public static String  excelSheetName ="";
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
    
 static String script;
 static String sheet;
// Data_Store ds = new Data_Store();
 public ResultSet rs;
 
 
 
//---------------------------------------- FUNCTION DEFINITIONS --------------------------------------------------------
 
 
//************************************************* 1 - ROW ********************************************************* 
 /**
  * This function will return the number of arrays based on a particular column value.
  * @param sheet: Excel Sheet Name
  * @return: 
  * @throws Exception 
  */
 public int get_RowCount(String sExcelBookName, String sExcelSheetName) throws Exception
 {
	 System.out.println("Inside getRowCount Function");
		String var="Y";
		int noOfRows = 0;
		int Count = 0;
		int totalCount=0;
		
		//First open the excel sheet by making a connection
		Open(sExcelBookName);	
		
		//Execute the query
		LQuery = "Select * From ["+sExcelSheetName+"$]";
		rs = stmnt.executeQuery(LQuery);
		System.out.println("Get_Record - Executed SQL Query");		    	
		//ResultSet rs=stmnt.executeQuery("Select * from [Item_Group$]");
		
		while(rs.next())
		{
			totalCount++;
			/*	CONST.aExecFlag.add(rs.getString("EXECUTE"));		//here we are fixing the column
				System.out.println("CONST.aExecFlag :"+CONST.aExecFlag);
				
				try
				{
					System.out.println("No Of Rows :"+CONST.aExecFlag.get(noOfRows));
					if(CONST.aExecFlag.get(noOfRows).equals(null))
						break;
					if(CONST.aExecFlag.get(noOfRows).equalsIgnoreCase("Y") || CONST.aExecFlag.get(noOfRows).equalsIgnoreCase("N"))
					{
						Count++;
						
//						CONST.primaryCol.add(rs.getString("SL_NO"));
//						try
//						{
//							if(CONST.primaryCol.get(noOfRows)==null)
//								break;
//						}catch(Exception e){}
					}						
					noOfRows++;
				}catch(Exception e){}*/
		}
			
		System.out.println("No Of Rows 'Y' :"+Count);
		System.out.println("TotalCount :"+totalCount);
		return totalCount;	
 }
 
 /**
   * This function interfaces between the other Scripts & this class & performs opening & fetching 
   * of the record .
   * 
   * @author    Sunil Pratap
   * @category  Reusable Code - Only Function to be called for using this class
   * 
   */
  public Data_Store Initiate_Excel_1Row(Data_Store ds,String sExcelBookName,String sExcelSheetName,String sScript)throws Exception
  {   
   //  System.out.println("Initiate_Excel - Inside Initiate_Excel");
   try
   {
    Open(sExcelBookName);
   // System.out.println("After open");
    ds=Get_Record_1Row(ds,sExcelSheetName,sScript);
   } 
   catch(Exception e)
   {
    System.out.println("Initiate_Excel - Problem encountered"); 
    System.out.println(e.toString());
    e.printStackTrace();
   }
   System.out.println("Initiate_Excel - Exiting Initiate_Excel");
   return ds;
  }
 
 
 
 
 
//************************************************* 2 - ROW *********************************************************
       
   /**
  * This function interfaces between the other Scripts & this class & performs opening & fetching 
  * of the record .
  * 
  * @author    Deepti Devadas
  * @category  Reusable Code - Only Function to be called for using this class
  * 
  */
   public Data_Store Initiate_Excel(Data_Store ds,String script)throws Exception
   {
    
    System.out.println("Initiate_Excel - Inside Initiate_Excel");
    try
    {
     Open();
        ds=Get_Record(ds,script);
    }
    catch(Exception e)
    {
     System.out.println("Initiate_Excel - Problem encountered"); 
     System.out.println(e.toString());
        e.printStackTrace();
    }
    System.out.println("Initiate_Excel - Exiting Initiate_Excel");
    return ds;
   }
   public Data_Store Initiate_Excel(Data_Store ds,String sExcelBookName,String sExcelSheetName,String sScript)throws Exception
	 {		 
		 //  System.out.println("Initiate_Excel - Inside Initiate_Excel");
		 try
		 {
			 Open(sExcelBookName);
			 System.out.println("After open");
			 ds=Get_Record(ds,sExcelSheetName,sScript);
		 }	
		 catch(Exception e)
		 {
			 System.out.println("Initiate_Excel - Problem encountered"); 
			 System.out.println(e.toString());
			 e.printStackTrace();
		 }
		 System.out.println("Initiate_Excel - Exiting Initiate_Excel");
		 return ds;
	 }
   /**
   * Example of function overloading
   * It takes the name of the sheet as well
  * This function interfaces between the other Scripts & this class & performs opening & fetching 
  * of the record .
  * @category  Reusable Code - Only Function to be called for using this class
  */
  public Data_Store Initiate_Excel(Data_Store ds,String sheet,String script)throws Exception
  {
    
   System.out.println("Initiate_Excel - Inside Initiate_Excel");
   try
   {
    Open();
    ds=Get_Record(ds,sheet,script);
   }
   catch(Exception e)
   {
    System.out.println("Initiate_Excel - Problem encountered"); 
    System.out.println(e.toString());
    e.printStackTrace();
   }
    System.out.println("Initiate_Excel - Exiting Initiate_Excel");
    return ds;
  }
 
 /**
   * This function interfaces between the other Scripts & this class & performs opening & fetching 
   * of the record .
   * 
   * @author    Sunil Pratap
   * @category  Reusable Code - Only Function to be called for using this class
   * 
   */
  public Data_Store Initiate_Excel_2Row(Data_Store ds,String sExcelBookName,String sExcelSheetName,String sScript)throws Exception
  {   
   //  System.out.println("Initiate_Excel - Inside Initiate_Excel");
   try
   {
    Open(sExcelBookName);
    System.out.println("After open");
    ds=Get_Record(ds,sExcelSheetName,sScript);
   } 
   catch(Exception e)
   {
    System.out.println("Initiate_Excel - Problem encountered"); 
    System.out.println(e.toString());
    e.printStackTrace();
   }
   System.out.println("Initiate_Excel - Exiting Initiate_Excel");
   return ds;
  }
  
   /**
  * This function executes the SQL Query & Fetches the input data rows corresponding to the Test Case
  * @author    Deepti Devadas
  * @category  Reusable Code - Fetching Input Data
  * 
  */
   public Data_Store Get_Record(Data_Store ds,String script)throws Exception
   {
     System.out.println("Get_Record - Inside Get_Record");
    
  int intRsLablelength = 0;
  int intDataCount=0;
  String strData_StoreValue[] = new String[1];
  String strDataStVal = ""; 
        
      try
      {
       LQuery = "Select * From ["+excelSheetName+"$] WHERE TEST_CASE_ID = '"+script+"'";
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
                 if (strData_StoreValue.length>=1)
                 {
                  if((strDataStVal.indexOf("\"")==0) && (strDataStVal.lastIndexOf("\"")==strDataStVal.length()-1))
                  {
                   System.out.println("Get_Record - Removed double quotes from : "+ strDataStVal);
                   strDataStVal=strDataStVal.substring(1,strDataStVal.length()-1);
                   System.out.println("Get_Record - After removing double quotes : "+ strDataStVal);
                  }
                  if(strDataStVal.equals("NA"))
                  {
                   strDataStVal="";
                  }
                  String strTempStore[]= new String[strData_StoreValue.length+1];
                  System.arraycopy(strData_StoreValue, 0, strTempStore, 0, strData_StoreValue.length);
                  strData_StoreValue=strTempStore;
                 }
                 strData_StoreValue[intDataCount]=strDataStVal;
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
          System.out.println("Get_Record - Store value from Record set to Data Set");
          int intLen=strData_StoreValue.length;
          for ( int i=0;i<intLen/2;i++)
          {
           ds.put(strData_StoreValue[i], strData_StoreValue[intLen/2+i]);
           //System.out.println("Get_Record - "+strData_StoreValue[i]+" value is : "+ds.get(strData_StoreValue[i]));
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
    System.out.println("Get_Record - please convert int value to string by using \" at start and end");
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
     return ds;
    
   }
   
   /**
	 * This function executes the SQL Query & Fetches the input data rows corresponding to the Test Case
	 * @author 			Deepti Devadas
	 * @category		Reusable Code - Fetching Input Data
	 * 
	 */
   public Data_Store Get_Record(Data_Store ds,String excelSheetName,String script)throws Exception
   {
	   	System.out.println("Get_Record - Inside Get_Record");
	   
		int intRsLablelength = 0;
		int intDataCount=0;
		String strDataStoreValue[] = new String[1];
		String strDataStVal = ""; 
	       
	     try
	     {
	    	 LQuery = "Select * From ["+excelSheetName+"$] WHERE AUTOMATION_SCRIPT_ID = '"+script+"'";
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
				            		if(strDataStVal.equals("NA"))
				            		{
				            			strDataStVal="";
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
		        System.out.println("Get_Record - Store value from Record set to Data Set");
		        int intLen=strDataStoreValue.length;
		        for ( int i=0;i<intLen/2;i++)
		        {
		        	ds.put(strDataStoreValue[i], strDataStoreValue[intLen/2+i]);
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
			 System.out.println("Get_Record - please convert int value to string by using \" at start and end");
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
     return ds;
	   
   }
   /**
	 * This function executes the SQL Query & Fetches the input data rows corresponding to the Test Case
	 * @author 			Deepti Devadas
	 * @category		Reusable Code - Fetching Input Data
	 * 
	 */
   public Data_Store Get_Record_Mod(Data_Store ds,String excelSheetName,String script)throws Exception
   {
   	 int intRsLablelength = 0;
		 int intDataCount=0;
		 String strData_StoreValue[] = new String[1];
		 String strDataStVal = ""; 
	       
		 try
	     {
	    	 LQuery = "Select * From ["+excelSheetName+"$] WHERE SL_NO = '"+script+"'";
		     rs_Lable = stmnt.executeQuery(LQuery);
		    // System.out.println("Get_Record - Executed SQL Query");
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
		    //    System.out.println("Get_Record - Total row count is "+ intRowCount);
		        while(rs_Lable.next())
		        {
		        	intRsLablelength = rsdt_Lable.getColumnCount();
		        	
		       //     System.out.println("Get_Record - Column count: "+intRsLablelength);
		            for(int i=1;i<=intRsLablelength;i++)
		            {
			           String strColumnName = rs_Lable.getMetaData().getColumnName(i);
			     //      System.out.println("Get_Record - Excel column name: "+ strColumnName);
			         	strDataStVal=rs_Lable.getObject(strColumnName).toString();
			     //    	System.out.println("Get_Record - Excel column value: "+ strDataStVal);
			         	
			            if(strDataStVal!=null)   
			            {
			            	if (strData_StoreValue.length>=1)
			            	{
			            		if((strDataStVal.indexOf("\"")==0) && (strDataStVal.lastIndexOf("\"")==strDataStVal.length()-1))
			            		{
			           // 			System.out.println("Get_Record - Removed double quotes from : "+ strDataStVal);
			            			strDataStVal=strDataStVal.substring(1,strDataStVal.length()-1);
			            //			System.out.println("Get_Record - After removing double quotes : "+ strDataStVal);
			            		}
			            		if(strDataStVal.equalsIgnoreCase("na"))
			            		{
			            			strDataStVal="";
			            		}            		
			            	}
			            	ds.put(strColumnName, strDataStVal);
			            }
		            }//End of for
		        }//End of while
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
				 System.out.println("Get_Record - please convert int value to string by using \" at start and end");
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
		 System.out.println("Hi");
		 return ds; 	   
   }
    /**
  * This function executes the SQL Query & Fetches the input data rows corresponding to the Test Case
  * @author    Sunil
  */
   public Data_Store Get_Record_1Row(Data_Store ds,String sExcelSheetname,String sScript)throws Exception
   {   
  int intRsLablelength = 0;
  int intDataCount=0;
  String strData_StoreValue[] = new String[1];
  String strDataStVal = ""; 
        
      try
      {
       LQuery = "Select * From ["+sExcelSheetname+"$] WHERE SL_No = '"+sScript+"'";
       rs_Lable = stmnt.executeQuery(LQuery);
      // System.out.println("Get_Record - Executed SQL Query");
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
      //    System.out.println("Get_Record - Total row count is "+ intRowCount);
          while(rs_Lable.next())
          {
           intRsLablelength = rsdt_Lable.getColumnCount();
           
         //     System.out.println("Get_Record - Column count: "+intRsLablelength);
              for(int i=1;i<=intRsLablelength;i++)
              {
              String strColumnName = rs_Lable.getMetaData().getColumnName(i);
        //      System.out.println("Get_Record - Excel column name: "+ strColumnName);
             strDataStVal=rs_Lable.getObject(strColumnName).toString();
        //     System.out.println("Get_Record - Excel column value: "+ strDataStVal);
             
               if(strDataStVal!=null)   
               {
                if (strData_StoreValue.length>=1)
                {
                 if((strDataStVal.indexOf("\"")==0) && (strDataStVal.lastIndexOf("\"")==strDataStVal.length()-1))
                 {
              //    System.out.println("Get_Record - Removed double quotes from : "+ strDataStVal);
                  strDataStVal=strDataStVal.substring(1,strDataStVal.length()-1);
               //   System.out.println("Get_Record - After removing double quotes : "+ strDataStVal);
                 }
                 if(strDataStVal.equalsIgnoreCase("na"))
                 {
                  strDataStVal="";
                 }              
                }
                ds.put(strColumnName, strDataStVal);
               }
              }//End of for
          }//End of while
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
     System.out.println("Get_Record - please convert int value to string by using \" at start and end");
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
     return ds;
    
   }
    
   /**
  * This function is used to close the jdbc connection
  * @author    Deepti Devadas
  * @category  Reusable Code - Close jdbc connection
  * 
  */   
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
 
  /**
  * This function Converts the data in the Data_Store to coma "," seperated String Format
  * @author    Deepti Devadas
  * @category  Reusable Code - Convert input Data to Coma Seperated Format
  * 
  */
 public String ConvertData(Data_Store ds)
 {
  String strInputData= "";
  int intStrLen = ds.getSize();
  strInputData= strInputData+ds.getValueStore(0);
  for (int i=1; i<intStrLen; i++)
  {
   strInputData+=","+ds.getValueStore(i);
  }
  return strInputData;
  
 }
 
   /**
   * This function establishes a connection to the Excel File & opens it for manipulation
   * @category  Reusable Code - Fetching Input Data
   */
   public void Open() throws Exception
   {
    System.out.println("Open - Inside Open function");
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    
   //    ITestProject myRftProj = RationalTestScript.getCurrentProject();  
    String workingDir = System.getProperty("user.dir");
	   System.out.println("Current working directory : " + workingDir);
       
       String FN = workingDir + "\\Data\\BBY_DataSheet.xls" ;
       System.out.println("Open - Excel to be read is"+FN);
       try 
       {
         conn = DriverManager.getConnection("jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + FN + "; READONLY=false");
       }
       catch(Exception e)
       {
         System.out.println("Open - Problem encountered while creating connection"); 
      System.out.println(e.toString());
         e.printStackTrace();
       }
         
       try 
       {
        stmnt =conn.createStatement();
        stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
       }
       catch(Exception e)
       {
        System.out.println("Open - Problem encountered while creating stmnt"); 
        System.out.println(e.toString());
         e.printStackTrace();
       }
       
       System.out.println("Open - Exiting Open function");
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
    // System.out.println("Project Location :"+projLocation);
    // System.out.println("PATH  :"+"\\Data\\"+sExcelBoookname+".xls");
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
   
 public void testMain(Object[] args) 
 {
//     try
//     {
//        Open();
//        Get_Record(ds, "BB02_QFOC_FN_10");
//       Close();
//     }
//     catch(Exception b)
//     {
//      System.out.println("Exception occurred");
//     }
 }
} 

