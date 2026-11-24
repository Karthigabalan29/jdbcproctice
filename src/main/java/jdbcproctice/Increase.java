package jdbcproctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Increase {

	public static void main(String[] args) {
		try {
			//1.LOAD AND REGISTER THR DRIVER
			Class.forName("org.postgresql.Driver");
			
			//2.establish connection
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/db","postgres","postgres123");
			
			PreparedStatement ps=con.prepareStatement("UPDATE employee SET sal = sal + ? WHERE des = ?");
			
			Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Des: ");
	        String designation = sc.nextLine();

	        System.out.print("Enter Bonus Amount: ");
	        double bonus = sc.nextDouble();
	        
	        ps.setDouble(1, bonus);
	        ps.setString(2, designation);

	        int result = ps.executeUpdate();

	        System.out.println(result + " employee(s) salary updated.");

	        con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

}
