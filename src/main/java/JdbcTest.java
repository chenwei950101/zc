

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcTest {
	public static void main(String[] args) {
	String sql="select * from tbl_user ";
	Connection con=null;
    Statement st=null;
    ResultSet rs=null;
  
    try {
		  Class.forName("com.mysql.jdbc.Driver");
		  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_db","root","123456");
		  st=con.createStatement();
		  rs=st.executeQuery(sql);
		  
		  System.out.println(rs==null);
		  while(rs.next()){
			  System.out.println(rs.getInt("id"+""));
			  System.out.println(rs.getString("name"+""));
			  System.out.println(rs.getString("password"+""));
			  System.out.println(rs.getString("email"+""));
			  System.out.println();
		  }
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	try {
		st.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}

