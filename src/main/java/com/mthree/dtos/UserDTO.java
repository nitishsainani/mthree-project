package com.mthree.dtos;

public class UserDTO {
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String dateOfBirth;
	public UserDTO()
	{
		
	}
	public UserDTO(String userName, String password, String fullName, String email, String dateOfBirth) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "UserDTO [userName=" + userName + ", password=" + password + ", fullName=" + fullName + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + "]";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
