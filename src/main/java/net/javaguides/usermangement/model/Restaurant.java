package net.javaguides.usermangement.model;

public class Restaurant {
/*
 * create table restaurant(
id int  not null auto_increment,
name varchar(200),
email varchar(255) not null ,
 PRIMARY KEY(id, email),  /* i have to make id written first*/
/*FOREIGN KEY (email) REFERENCES users(email)
);
 * */
 private int ID;
 private String name;
 private String email;
 Menu menu ;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Menu getMenu() {
	return menu;
}
public Restaurant(int iD, String name) {
	super();
	ID = iD;
	this.name = name;
}
public void setMenu(Menu menu) {
	this.menu = menu;
}
public Restaurant(int iD, String name, String email, Menu menu) {
	super();
	ID = iD;
	this.name = name;
	this.email = email;
	this.menu = menu;
}
public Restaurant() {
	// TODO Auto-generated constructor stub
}
 
}
