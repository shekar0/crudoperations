package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class getbyemail {
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
			String sql="select * from "+sc.next()+" where email=?";
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			System.out.println("enter email :");
			pmst.setString(1, sc.next());
						
			ResultSet rs=pmst.executeQuery();
			while(rs.next())
			{
				System.out.println("id = "+rs.getInt("id")+"\nname = "+rs.getString("name")+"\nemail = "+rs.getString("email"));
			}
			
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
