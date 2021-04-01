package day18;
import java.sql.*;

public class JdbcDemo12
{
   public static void main(String str[]) throws Exception
   {
	try
	{
  	  Connection con=DBUtility.getConnection();
	  Statement st=con.createStatement();  
//	  st.execute("insert into sam values('hapa',111)");
	  st.execute("delete from sam where age=21");
	  st.executeUpdate("update sam set name='newname' where age=31;");
	  PreparedStatement ps=con.prepareStatement("select * from sam where age=?");
	  ps.setInt(1, 111);
	  ResultSet rs = ps.executeQuery();
	  System.out.println(rs.getString(1));
	 System.out.println("empno"+"\t empname");
	  while(rs.next())
	  {
		String e1=rs.getString(1);
		int e=rs.getInt(2);
		System.out.println("name = " +e1 +"\t age = " +e);
	  }
	  DBUtility.closeConnection(null, null);
	System.out.println("records successfully  deleted");
	}catch(Exception e){e.printStackTrace();}
     }
}