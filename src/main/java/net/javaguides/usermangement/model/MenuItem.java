package net.javaguides.usermangement.model;

public class MenuItem {

//	create table menuItem(
//			id int  not null auto_increment,
//			name varchar(200),
//			price double,
//			email varchar(255) not null ,
//			restID int not null,
//			menuID int not null,
//			 PRIMARY KEY(id,restID,menuID, email),  /* i have to make id written first*/
//			FOREIGN KEY (email,restID,menuID) REFERENCES menu(email,restID,id)
//			);
	
	
	private int ID;
	
	private String name ;
	private double price;
	private String email;
	private int restID;
	private int menuID;
	private int count;

	
	public MenuItem(String name, double price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}


	public MenuItem(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	public MenuItem(int iD, String name, double price, String email, int restID, int menuID) {
		super();
		ID = iD;
		this.name = name;
		this.price = price;
		this.email = email;
		this.restID = restID;
		this.menuID = menuID;
	}
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getRestID() {
		return restID;
	}
	public void setRestID(int restID) {
		this.restID = restID;
	}
	public int getMenuID() {
		return menuID;
	}
	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

}
