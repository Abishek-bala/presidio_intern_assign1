package day18;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
public class JdbcDemo7 {
	public static void main(String[] args) throws Exception{
		Connection con=DBUtility.getConnection();
		
//		 CallableStatement cs= con.prepareCall("{call proc1()}");
//		
//		 int i=cs.executeUpdate();
//		
//		 System.out.println("No of rows updated...:"+i);
//		
//		 Statement st= con.createStatement();
//		 boolean b=st.execute("insert into users values (3,'raja','spider',0)");
//		 System.out.println(b);
//		
//		CallableStatement cs=con.prepareCall("{call proc2(?,?)}");
//		cs.setString(1, "ramu");
//		cs.setInt(2, 0);
//		
//		cs.executeUpdate();
		
		CallableStatement cs=con.prepareCall("{call proc3(?,?)}");
		cs.setString(1, "somu");
		cs.registerOutParameter(2, Types.INTEGER);
		
		cs.execute();
		
		System.out.println("The flag value of ramu is...:"+cs.getInt(2));
		DBUtility.closeConnection(null, null);
	}
}