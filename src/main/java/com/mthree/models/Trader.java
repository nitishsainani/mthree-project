package com.mthree.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="trader") 
public class Trader extends User {

	public Trader() {
		// TODO Auto-generated constructor stub
	}

	public Trader(int userId, String userName, String password, String fullName, String email, String dateOfBirth) {
		super(userId, userName, password, fullName, email, dateOfBirth);
		// TODO Auto-generated constructor stub
	}

}
