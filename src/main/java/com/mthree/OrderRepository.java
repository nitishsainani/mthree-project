package com.mthree.Order;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

@Repository
public interface OrderRepository extends JpaRepository <OrderModel,Integer> {
}
