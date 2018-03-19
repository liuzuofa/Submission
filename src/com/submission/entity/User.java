package com.submission.entity;

public class User {

	private int id;
	private String email;
	private String password;
	private String type;
	private String name;
	private String education;
	private String tel;
	private String address;
	private String state;
	
	public User(){
		
	}

	public User(String education, String tel, String address) {
		super();
		this.education = education;
		this.tel = tel;
		this.address = address;
	}

	public User(String email, String password, String type, String name, String education, String tel, String address) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
		this.name = name;
		this.education = education;
		this.tel = tel;
		this.address = address;
	}	
	
	public User(String email, String password, String type, String name, String education, String tel, String address,String state) {
		super();
		this.email = email;
		this.password = password;
		this.type = type;
		this.name = name;
		this.education = education;
		this.tel = tel;
		this.address = address;
		this.state = state;
	}	
	
	public User(int id, String email, String password, String type, String name, String education, String tel,
			String address, String state) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.type = type;
		this.name = name;
		this.education = education;
		this.tel = tel;
		this.address = address;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", type=" + type + ", name=" + name
				+ ", education=" + education + ", tel=" + tel + ", address=" + address + ", state=" + state + "]";
	}

	
	
	
}
