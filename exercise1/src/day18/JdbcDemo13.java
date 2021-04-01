package day18;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JdbcDemo13 {
	public static void main(String[] args) throws Exception {
		Connection con = DBUtility.getConnection();
		
		PreparedStatement ps = con.prepareStatement("insert into sam values (?,?)");
		
		ps.setString(1,"hello there");
		ps.setInt(2, 32);
		ps.executeUpdate();
		DBUtility.closeConnection(null, null);
	}
}
