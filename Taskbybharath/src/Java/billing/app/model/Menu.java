package Java.billing.app.model;

public class Menu {
	private Integer quantity;
public Menu(Integer quantity, Float price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}
private Integer id;
private String name;
private Float price;
public Menu(Integer id, String name, Float price) {
	super();
	this.id = id;
	this.name = name;
	this.price = price;
}
public Menu(String name, Float price) {
	super();
	this.name = name;
	this.price = price;
}
public Menu() {
	super();
}
public Menu(String name2, int quantity) {
	
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Float getPrice() {
	return price;
}
public void setPrice(Float price) {
	this.price = price;
}


}
