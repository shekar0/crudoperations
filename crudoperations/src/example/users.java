package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class users {
	private static final String User="root";
	private static final String Password="root";
	private static final String Url="jdbc:mysql://localhost:3306/";
	
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(Url, User, Password);
			System.out.println("enter database name :");
			String sql="create database "+sc.next();
			
			PreparedStatement pmst=conn.prepareStatement(sql);
			
			int i=pmst.executeUpdate();
			if(i==0)
			{
				System.out.println("successfully created");
			}
			else {
				System.out.println("not created");
			}
			conn.close();
			pmst.close();
			sc.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
