package jdbcproctice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Insert {

	public static void main(String[] args) {
		try {
			//1.LOAD AND REGISTER THR DRIVER
			Class.forName("org.postgresql.Driver");
			
			//2.establish connection
			Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/db","postgres","postgres123");
			
			PreparedStatement ps=con.prepareStatement("insert into users(empid,name,email,phno,des,sal)values(?,?,?,?,?,?)");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter empid");
			int empid=sc.nextInt();
			System.out.println("enter name");
			String name=sc.next();
			System.out.println("enter email");
			String email=sc.next();
			System.out.println("enter phno");
			Long phno=sc.nextLong();
			System.out.println("enter des");
			String des=sc.next();
			System.out.println("enter sal");
			double sal=sc.nextInt();
			
			ps.setInt(1, empid);
			ps.setString(2,name);
			ps.setString(3,email);
			ps.setLong(4,phno);
			ps.setString(5,des);
			ps.setDouble(6,sal);
			
			ps.executeUpdate();
			System.out.println("insert done");
			
			con.close();
			
		
		

	}catch(Exception e)
		{
		System.out.println(e);
		}
	}

}
