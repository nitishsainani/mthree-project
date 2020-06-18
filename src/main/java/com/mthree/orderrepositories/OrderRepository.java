package com.mthree.orderrepositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mthree.dtos.OrderDTO;
import com.mthree.orders.OrderModel;

@Repository
public interface OrderRepository extends JpaRepository <OrderModel,Integer> {
	
	@Query(value="update order_model set user_id=:userId,instrument_id=:instrumentId where order_id=:orderId",nativeQuery=true)
	@Modifying
	@Transactional
	public int updateLimitOrderById(@Param("orderId")int orderId,@Param("userId")int userId,@Param("instrumentId")int instrumentId);
   
	@Query(value="update order_model set user_id=:userId,instrument_id=:instrumentId where order_id=:orderId",nativeQuery=true)
	@Modifying
	@Transactional
	public int updateMarketOrderById(@Param("orderId")int orderId,@Param("userId")int userId,@Param("instrumentId")int instrumentId);

	@Query("select new com.mthree.dtos.OrderDTO(o.orderId,u.userId,o.instrumentName,o.side,o.status,o.exchangeId) from User u  inner join u.orders o where u.userId=:userId")
	//@Query(value="select order_id,user_id,instrument_id,side,status,exchange_id from order_model where user_id=:userId",nativeQuery=true)
	public List<OrderDTO> displayOrders(@Param("userId")int userId);
}
