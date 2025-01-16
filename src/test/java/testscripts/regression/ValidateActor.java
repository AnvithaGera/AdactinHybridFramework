package testscripts.regression;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateActor {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		String dburl="jdbc:mysql://localhost:3306/sakila";
		
		String username="root";
		
		String password="soobin@30419";
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn=DriverManager.getConnection(dburl,username,password);
		
		PreparedStatement ps=conn.prepareStatement("select * from actor where last_name='TEMPLE';");
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			for(int i=1;i<=4;i++)
			{
				System.out.print(rs.getString(i)+"\t");
			}
			System.out.println();
		}
	}

}
