package Java.billing.app.controller;


	import java.sql.SQLException;
import java.util.List;
	import java.util.Scanner;

	import Java.billing.app.model.Menu;
	import Java.billing.app.service.Billingappservice;
	import Java.billing.app.utility.Billingappexception;

	public class Billingappcontroller {

		private Billingappservice bilservice = new Billingappservice();

		public void viewMenu() {

			List<Menu> listofmenu;
			try {
				listofmenu = bilservice.viewMenu();

				System.out.println("MENU");
				System.out.println("Id" + "-" + "name" + "-" + "price");

				for (Menu m : listofmenu) {
					System.out.println(m.getId() + "-" + m.getName() + "-" + m.getPrice());

				}
			} catch (Billingappexception e) {
				System.out.println(e.getMessage());
			}

		}

		public void additemintomenu() {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the name of item:");
			String name = sc.next();
			System.out.println("enter the price of the item:");
			Float price = sc.nextFloat();
			Menu menu = new Menu(name, price);
			try {
				bilservice.addItemintoMenu(menu);
			} catch (Billingappexception e) {
				System.out.println(e.getMessage());
			}
		}
		public void Totalbill() throws SQLException {
			Scanner sc=new Scanner(System.in);
			System.out.println("enter the name of the item into menu:");
			String name=sc.next();
			System.out.println("enter the how much quantity you want:");
			int quantity=sc.nextInt();
			//Menu menu = new Menu(name, quantity);
			bilservice.generatebill(name,quantity);
			
		}
	}

