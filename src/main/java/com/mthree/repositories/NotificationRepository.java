package com.mthree.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.dtos.NotificationDTO;
import com.mthree.models.Notification;
@Repository
public interface NotificationRepository extends JpaRepository <Notification,Integer> {
	
	@Query("select new com.mthree.dtos.NotificationDTO(n.message) from User u  inner join u.notifications n where u.userId=:userId")
	public List<NotificationDTO> findAllByUserId(@Param("userId")int userId);
	@Query(value="delete from notification where user_id=:userId",nativeQuery=true)
	
	@Modifying
	@Transactional
	public int deleteAllByUserId(@Param("userId")int userId);
	@Query(value="update notification set user_id=:userId where notification_id=:notificationId",nativeQuery=true)
	@Modifying
	@Transactional
	public int updateNotificationrById(@Param("notificationId")int notificationId,@Param("userId")int userId);
	

}
