package com.mthree.dtos;

public class NotificationDTO {

	public NotificationDTO() {
		// TODO Auto-generated constructor stub
	}
	private String message;
	public NotificationDTO(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
