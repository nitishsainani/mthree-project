package com.mthree.exchangeRepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mthree.exchanges.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository <Exchange,Integer> {

}
