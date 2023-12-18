package Java.billing.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Java.billing.app.model.Menu;
import Java.billing.app.repository.Billinapprepo;
import Java.billing.app.utility.Billingappexception;
import Java.billing.app.utility.Validatedata;

public class Billingappservice {
	private Billinapprepo repo = new Billinapprepo();
	public List<Menu> viewMenu() throws Billingappexception {
		List<Menu> repomenulist = repo.viewMenu();
		if (repomenulist.isEmpty()) {
			throw new Billingappexception("items not avalible in the menu");
		} else {
			return repomenulist;
		}
	}
	public void addItemintoMenu(Menu m) throws Billingappexception {
		Validatedata validdata=new Validatedata();
		validdata.validatingiputdata(m);
		List<Menu> exisistingprod=repo.viewwithname(m.getName());
		if(!exisistingprod.isEmpty()) {
			throw new Billingappexception("Product already availible in menu:"+m.getName());
		}
		repo.additem(m);
		System.out.println("Item added into the menu successfully");
	}
	
	public void generatebill(String productname, Integer quantity) throws SQLException {
		//System.out.println(productname);
		Float prod=repo.getpricewithname(productname);
		 float d= quantity*prod;
		 System.out.println("Total price of the your selected item will be:"+d);
		}
	}


