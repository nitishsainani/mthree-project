package com.mthree.notifications;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mthree.users.User;
@Entity
public class Notification {
	@Id
	@GeneratedValue
	private int notificationId;
	private String message;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userId;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public User getUserId() {
		return userId;
	}

	public Notification() {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	public void setUserId(User user) {
		this.userId = user;
	}

	public Notification(String message, User userId) {
		super();
		this.message = message;
		this.userId = userId;
	}

	public Notification(int notificationId, String message, User userId) {
		super();
		this.notificationId = notificationId;
		this.message = message;
		this.userId = userId;
	}
	

}
