package Java.billing.app.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Java.billing.app.model.Menu;

public class Billinapprepo {
	public static Connection con = null;
	private Float price;

	public List<Menu> viewMenu() {
		try {
			establishconnection();

			System.out.println("connection established succesffuly");
			Statement stmt = con.createStatement();
			String sqlquery = "Select * from menu";
			ResultSet resultset = stmt.executeQuery(sqlquery);
			List<Menu> menu = new ArrayList<Menu>();
			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name = resultset.getString("name");
				Float price = resultset.getFloat("price");
				Menu m = new Menu(id, name, price);
				menu.add(m);

			}

			return menu;
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());

		}

		// System.out.println("menu:" + id + "-" + name + "-" + price);

	}

	public void establishconnection() throws SQLException {
		final String url = "jdbc:mysql://localhost:3306/billingdatabase";
		final String username = "root";
		final String password = "root@253";
		// Connection con;
if(con==null) {
		con = DriverManager.getConnection(url, username, password);
		
}
	}
	public void additem(Menu m) {
		try {
			establishconnection();
			PreparedStatement pstmt=con.prepareStatement("insert into menu (name,price) values (?,?)");
			pstmt.setString(1, m.getName());
			pstmt.setFloat(2, m.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
throw new RuntimeException(e.getMessage());
		}
		
	}
	public List<Menu> viewwithname(String name) {
		try { 
			establishconnection();
			PreparedStatement pstmt=con.prepareStatement("select * from menu where name=?");
			pstmt.setString(1, name);
			ResultSet resultset = pstmt.executeQuery();
			List<Menu> menu = new ArrayList<Menu>();
			while (resultset.next()) {
				int id = resultset.getInt("id");
				String name1 = resultset.getString("name");
				Float price = resultset.getFloat("price");
				Menu m = new Menu(id, name1, price);
				menu.add(m);

			}
			return menu;

		}
		catch(SQLException e) {
			throw new  RuntimeException(e.getMessage());
		}
	}
	public    Float getpricewithname(String name) throws SQLException {
		establishconnection();
		PreparedStatement pstmt=con.prepareStatement("select price from menu where name=?");
pstmt.setString(1, name);
Float price = null;
//List<Menu> menu = new ArrayList<Menu>();

ResultSet resultset = pstmt.executeQuery();

if (resultset.next()) {
	 price = resultset.getFloat("price");
}
return price;
	}
}
