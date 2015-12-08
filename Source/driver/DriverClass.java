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
import java.sql.SQLException;
public class DriverClass {
    Connection con;
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
    public void loginCheck(String uid, String pwd) {
        connectionMethod();
        try {
            String sql = "SELECT * FROM ADMIN_LOGIN WHERE ADMINUID=? AND ADMINPWD=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, uid);
            ps.setString(2, pwd);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                rs.getString(1);
                rs.getString(2);
                rs.getString(3);
            }
        } catch (SQLException sqle) {
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
    	DriverClass a = new DriverClass();
        a.loginCheck("avi", "avi3");
    }
}         

