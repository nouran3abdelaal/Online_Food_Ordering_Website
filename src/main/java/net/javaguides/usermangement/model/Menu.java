package net.javaguides.usermangement.model;

import java.util.ArrayList;

public class Menu {
//	create table menu (
//			id int  not null auto_increment,
//			email varchar(255) not null ,
//			restID int not null,
//			 PRIMARY KEY(id,restID, email),  /* i have to make id written first*/
//			FOREIGN KEY (email,restID) REFERENCES restaurant(email,id)
//			);
	
	private int ID;
	private String email;
	private int restID;
	private ArrayList<MenuItem> menu = new ArrayList<MenuItem>(); // Create an ArrayList object
	
	
	
	public Menu(ArrayList<MenuItem> menu) {
		super();
		this.menu = menu;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public ArrayList<MenuItem> getMenu() {
		return menu;
	}

	public int getSize() {
		return menu.size();
	}

	public void setMenu(ArrayList<MenuItem> menu) {
		this.menu = menu;
	}

	public Menu(int iD, String email, int restID, ArrayList<MenuItem> menu) {
		super();
		ID = iD;
		this.email = email;
		this.restID = restID;
		this.menu = menu;
	}

	public Menu() {
		// TODO Auto-generated constructor stub
	}

}
