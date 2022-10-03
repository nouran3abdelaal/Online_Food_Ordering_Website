package net.javaguides.usermangement.model;

public class users {

	private String email;
	private String name;
	private String phoneNumber;
	private int type;
	private String city;
	private String streetName;
	private int buildingNumber;
	private int departmentNumber;
	private String password;

	


	public users(String email, String name, String phoneNumber, int type, String city, String streetName,
			int buildingNumber, int departmentNumber, String password) {
		super();
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.city = city;
		this.streetName = streetName;
		this.buildingNumber = buildingNumber;
		this.departmentNumber = departmentNumber;
		this.password = password;
	}
	public String toString() {
		return "email: "+email+"\n"+
				"Name: "+name+  "\n"+
				"phoneNumber: "+ phoneNumber +"\n"+
				"type: "+ type+"\n"+
				
"city: "+ city+"\n"+
"streetName: "+ streetName+"\n"+
"buildingNumber: "+ buildingNumber+"\n"+
"departmentNumber: "+ departmentNumber+"\n"+
"password: "+ password+"\n";


	}





	public users(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public users(String email, String name, String phoneNumber, int type, String password) {
		super();
		this.email = email;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.type=type;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getStreetName() {
		return streetName;
	}





	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}





	public int getBuildingNumber() {
		return buildingNumber;
	}





	public void setBuildingNumber(int buildingNumber) {
		this.buildingNumber = buildingNumber;
	}





	public int getDepartmentNumber() {
		return departmentNumber;
	}





	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}





	public users() {
		// TODO Auto-generated constructor stub
	}



	

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}

}
