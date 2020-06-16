package com.mthree.users;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="dealer") 
public class Dealer extends User {
	private String companyName;

	public Dealer() {
		// TODO Auto-generated constructor stub
	}

	public Dealer(int userId, String userName, String password, String fullName, String email, String dateOfBirth) {
		super(userId, userName, password, fullName, email, dateOfBirth);
		// TODO Auto-generated constructor stub
	}
	public Dealer(int userId, String userName, String password, String fullName, String email, String dateOfBirth,String companyName) {
		super(userId, userName, password, fullName, email, dateOfBirth);
		// TODO Auto-generated constructor stub
		this.companyName = companyName;
	}

	

	public Dealer(String companyName) {
		super();
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + "companyName="+companyName+"]";
	}
	

}
