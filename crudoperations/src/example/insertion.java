package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
	private static final String User="root";
	private static final String Password="root";
	
	
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter database name :");
		    String Url="jdbc:mysql://localhost:3306/"+sc.next();
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter table name :");
			String sql="insert into "+sc.next()+"(id ,name ,email) values(?,?,?)";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			System.out.println("enter id :");
			pmst.setInt(1, sc.nextInt());
			System.out.println("enter name :");
			pmst.setString(2, sc.next());
			System.out.println("enter email :");
			pmst.setString(3, sc.next());
			
			int i=pmst.executeUpdate();
			if(i>0)
			{
				System.out.println("successfully inserted");
			}
			else {
				System.out.println("not inserted");
			}
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
