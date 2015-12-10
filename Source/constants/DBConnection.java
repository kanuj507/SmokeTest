package constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnection {
	
	
	
	

	public static Connection conn = null;
	public static Statement stmt = null;
	public static ResultSet rst = null;
	public static ResultSet rst_ItemTable = null;
	public static ResultSet rst_TaxTable = null;
	public static ResultSet rst_TenderTable = null;
	public static ResultSet rst_ErrorTable = null;
	public static ResultSet rst_StagingTable = null;
	public ResultSetMetaData rsMd_Lable;
	public ResultSet rs_Lable;
	int  dbRecordCount=0;
	int dbRecordCountOrg=0;
	public Statement stmnt = null; 
	public PreparedStatement stm=null; 
    Connection con;
    /*public void connectionMethod() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@(description=(load_balance=on)(failover=on)(address=(protocol=tcp)(host=dlocdb06)(port=50000))(connect_data=(service_name=ot01eodbsvc.world)(failover_mode=(type=select)(method=basic))(server=dedicated)))", "omsreadonly", "support");
        	stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
    public void loginCheck(String uid, String pwd) {
   
        String temp="";
        String temp2="";
        try {
            String query = "SELECT order_header_key FROM yfs_order_header WHERE order_no='2223238097241'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            
            

			ResultSet RS = DBC.Get_Data_DB(connectionString,
					Constant_Class.DB_UserName, Constant_Class.DB_Password,
					query);
			
			System.out.println("Connection done");
		     connectionMethod();
			ResultSet	RS  = stmt.executeQuery(query);
			if (RS != null) {
				ResultSetMetaData RSM = RS.getMetaData();
				while (RS.next()) {
					System.out.println("Column count: " + RSM.getColumnCount());
					if (RS.getObject("order_header_key").toString() != null) {
						temp = RS.getObject("order_header_key").toString();
						temp2 = temp.replaceAll("\\s", "");
						System.out.println("order_header_key - " + temp2);
					}
				}
			}
		} 
           catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/    
    
    
	public ResultSet Get_Data_DB(String ConnectionString,String userName,String password,String qury) throws SQLException
	{
		String databaseName="ot02eodb";
		String hostNumber="dlocdb03";
		String portNumber="50000";
		String orderNumber="1111187438628";
		String result="";
		try
		{
				try
				{	
					Class.forName("oracle.jdbc.driver.OracleDriver");
				//	DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
//					String url = "jdbc:oracle:thin:@"+databaseName.substring(1)+":"+hostNumber+":"+databaseName;
					try	
					{
						System.out.println("Connection String:"+ConnectionString+" Username: "+userName+" Password: "+password);
						conn = DriverManager.getConnection(ConnectionString,userName,password);
						stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
					
					}//end try
					catch (SQLException e)
					{
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
					
				}
				catch (Exception e)
				{
					e.printStackTrace();
					System.out.println(e.getMessage());
				}
				try
				{	
					System.out.println("Connection done");
					rs_Lable  = stmt.executeQuery(qury);//"Select order_header_key from yfs_order_header where order_No='"+orderNumber+"'");
					
					
				}
				catch (Exception e) {
					System.out.println(e.getMessage());
				}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return rs_Lable;
	}
	

    public static void main(String[] args) {
    	
    }
}         

