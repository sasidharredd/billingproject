package Java.billing.app.utility;

import Java.billing.app.model.Menu;

public class Validatedata {
private  boolean isValidName(String name) {
	String regex="[A-Z][a-z]+( [A-Z][a-z]+)*";
	 return name.matches(regex);
}
private boolean isvalidPrice(Float price) {
	return true;
}
public void validatingiputdata(Menu m) throws Billingappexception {
	if(!isValidName(m.getName())) {
		throw new Billingappexception("Please check the name entered:"+m.getName());
		
	}
	if(!isvalidPrice(m.getPrice())) {
		throw new Billingappexception("Please check the price entered:"+m.getPrice());
	}
}
}
