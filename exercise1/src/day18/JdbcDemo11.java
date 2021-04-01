package day18;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcDemo11 {
	public static void main(String[] args) throws Exception {
		Connection con = DBUtility.getConnection();
		
		Statement st =con.createStatement();
		
		ResultSet res = st.executeQuery("select * from sam;");
		
		while(res.next()) {
			System.out.println("name "+res.getString(1)+" age "+res.getString(2));
		}
		DBUtility.closeConnection(null, null);
	}
}
