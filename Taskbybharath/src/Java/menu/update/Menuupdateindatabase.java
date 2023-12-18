package Java.menu.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menuupdateindatabase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final String url = "jdbc:mysql://localhost:3306/billingdatabase";
		final String username = "root";
		final String password = "root@253";
		try {
			Connection con = DriverManager.getConnection(url, username, password);
			String query = "insert into menu values(?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			System.out.println("enter the item id:");
			int f1 = sc.nextInt();
			System.out.println("enter the item name: ");
			String f2 = sc.next();
			System.out.println("enter the price of the item:");
			int f3 = sc.nextInt();
			pstmt.setInt(1, f1);
			pstmt.setString(2, f2);
			pstmt.setInt(3, f3);
			pstmt.executeUpdate();
			System.out.println("Data inserted into the menu table successfully");
			System.out.println(" Total Menu inside the database:");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from menu");
			while (rs.next()) {
				int id = rs.getInt(1);
				System.out.print(id + "-");
				String name = rs.getString(2);
				System.out.print(name + "-");
				int price = rs.getInt("price");
				System.out.print(price);
				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
