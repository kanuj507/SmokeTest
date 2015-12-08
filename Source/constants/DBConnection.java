package constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
public class DBConnection {
    Connection con;
	public Statement stmt = null; 
    public void connectionMethod() {
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
          /*  PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();*/
            
            

		/*	ResultSet RS = DBC.Get_Data_DB(connectionString,
					Constant_Class.DB_UserName, Constant_Class.DB_Password,
					query);
			*/
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
    public static void main(String[] args) {
    	DBConnection a = new DBConnection();
        a.loginCheck("avi", "avi3");
    }
}         

