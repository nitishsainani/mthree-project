package com.mthree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mthree.dtos.NotificationDTO;
import com.mthree.repositories.NotificationRepository;
import com.mthree.models.Notification;

@Service
public class NotificationService {

	public NotificationService() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	private NotificationRepository notifrepo;
	public List<NotificationDTO> getNotifById(int userId)
	{
		return notifrepo.findAllByUserId(userId);
	}
	public List<Notification> getNotif()
	{
		return notifrepo.findAll();
	}
   public boolean deleteNotifById(int notifId)
   {
	   if(notifrepo.existsById(notifId))
	   {
	 notifrepo.deleteById(notifId);
	 return true;
	   }
	   else
		   return false;
   }
   public boolean deleteNotif()
   {
	  
	 notifrepo.deleteAll();
	 return true;
	 
   }
   public boolean deleteNotifByUserId(int notifId)
   {
	   
	 int n=notifrepo.deleteAllByUserId(notifId);
	 if(n!=0)
		 return true;
	 else
		 return false;
	
   }
   public boolean addNotif(Notification n,int userId)
   {
//	    notifrepo.save(n);
//	    notifrepo.updateUserId();
	   if(n!=null) {
		    notifrepo.save(n);
		    
		    if(notifrepo.updateNotificationrById(n.getNotificationId(),userId)==1)
			    return true;
			    else 
			    	return false;
		}
		return false;
	   
   }
}
