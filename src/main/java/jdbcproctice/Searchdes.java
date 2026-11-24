package jdbcproctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Searchdes {

	public static void main(String[] args) {
		try {
			//1.LOAD AND REGISTER THR DRIVER
			Class.forName("org.postgresql.Driver");
			
			//2.establish connection
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/db","postgres","postgres123");
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM employee WHERE des = ?");
			
			Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Des: ");
	        String des = sc.nextLine();
	        
	        ps.setString(1, des);

	        ResultSet rs = ps.executeQuery();

	        

	        while (rs.next()) {
	            

	            System.out.println("------------------------");
	            System.out.println("ID          : " + rs.getInt("empid"));
	            System.out.println("Name        : " + rs.getString("name"));
	            System.out.println("Email       : " + rs.getString("email"));
	            System.out.println("Phno      : " + rs.getLong("phno"));
	            System.out.println("Des : " + rs.getString("des"));
	            System.out.println("Salary      : " + rs.getDouble("salary"));
	        }
	        
	        ps.executeUpdate();
	        System.out.println("done");
	        
	        con.close();
		

	}catch(Exception e)
		{
		System.out.println(e);
		}
		}

}
