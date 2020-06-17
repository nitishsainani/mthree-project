package com.mthree.orderrepositories;

import org.springframework.stereotype.Repository;

import com.mthree.orders.OrderModel;

import org.springframework.data.jpa.repository.*;

@Repository
public interface OrderRepository extends JpaRepository <OrderModel,Integer> {
}
