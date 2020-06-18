package com.mthree.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mthree.models.Notification;
import com.mthree.models.OrderModel;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)  
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)  
@DiscriminatorValue(value="user")  
public class User {
	@Id
	@GeneratedValue
	protected int userId;
	protected String userName;
	protected String password;
	protected String fullName;
	protected String email;
	protected String dateOfBirth;
	@OneToMany(mappedBy="userId",cascade=CascadeType.ALL)
	@JsonBackReference
	protected List<OrderModel> orders;
	@OneToMany(mappedBy="userId",cascade=CascadeType.ALL)
	//@JsonBackReference
	protected List<Notification> notifications;
	public User()
	{
		
	}
	public User(int userId, String userName, String password, String fullName, String email, String dateOfBirth) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", email=" + email + ", dateOfBirth=" + dateOfBirth + "]";
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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