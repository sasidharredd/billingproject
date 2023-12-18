package Java.billing.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Java.billing.app.controller.Billingappcontroller;

public class Billingapp {
	public static void main(String[] args) throws SQLException {
		Billingappcontroller billingappcontroller=new Billingappcontroller();
		//billingappcontroller.viewMenu();
		//billingappcontroller.additemintomenu();
		billingappcontroller.Totalbill();
		
	}

}
