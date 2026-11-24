package jdbcproctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		try {
			//1.LOAD AND REGISTER THR DRIVER
			Class.forName("org.postgresql.Driver");
			
			//2.establish connection
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/db","postgres","postgres123");
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM employee WHERE empid = ?");
			
			Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Employee ID: ");
	        int empid = sc.nextInt();
	        
	        ps.setInt(1, empid);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            System.out.println("Employee Found");
	            System.out.println("ID          : " + rs.getInt("empid"));
	            System.out.println("Name        : " + rs.getString("name"));
	            System.out.println("Email       : " + rs.getString("email"));
	            System.out.println("Phno       : " + rs.getLong("phno"));
	            System.out.println("Des : " + rs.getString("des"));
	            System.out.println("Sal      : " + rs.getDouble("sal"));
	        } else {
	            System.out.println("Employee Not Found");
	        }

	        con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		

	}

}
