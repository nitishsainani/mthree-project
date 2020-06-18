package com.mthree.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mthree.dtos.NotificationDTO;
import com.mthree.models.Notification;
import com.mthree.services.NotificationService;
import com.mthree.responses.BaseResponse;

@RestController
public class NotificationController {

	public NotificationController() {
		// TODO Auto-generated constructor stub
	}
  @Autowired
  private NotificationService notifservice;
  
  @GetMapping("/getnotif/{userId}")
  public BaseResponse getnotif(@PathVariable("userId")int userId)
  {
	  List<NotificationDTO> n=notifservice.getNotifById(userId);
	  if(n.isEmpty())
		  return new BaseResponse(200,"no");
	  else
	  return new BaseResponse(200,"yes",n);
  }
  @GetMapping("/getnotif")
  public BaseResponse getAllnotif()
  {
	  List<Notification> n=notifservice.getNotif();
	  if(n.isEmpty())
		  return new BaseResponse(200,"no");
	  else
	  return new BaseResponse(200,"yes",n);
  }
  @PostMapping("/addnotif/{userId}")
  public BaseResponse addnotif(@RequestBody Notification n,@PathVariable("userId")int userId)
  {
	  boolean nof=notifservice.addNotif(n,userId); 
	  if(nof)
		  return new BaseResponse(200,"yes");
	  else
	  return new BaseResponse(200,"no");
  }
  @DeleteMapping("/deletenotif/{notifId}")
  public BaseResponse deletenotif(@PathVariable("notifId")int notifId)
  {
	  boolean n=notifservice.deleteNotifById(notifId);
	  if(n)
		  return new BaseResponse(200,"yes");
	  else
	  return new BaseResponse(200,"no");
  }
@DeleteMapping("/deletenotifByUserId/{userId}")
public BaseResponse deletenotifbyuserid(@PathVariable("userId")int userId)
{
	  boolean n=notifservice.deleteNotifByUserId(userId);
	  if(n)
		  return new BaseResponse(200,"yes");
	  else
	  return new BaseResponse(200,"no");
}
  @DeleteMapping("/deletenotif")
  public  BaseResponse deletenotif()
  {
	  boolean n=notifservice.deleteNotif();
	  if(n)
		  return new BaseResponse(200,"yes");
	  else
	  return new BaseResponse(200,"no");
  }
}
