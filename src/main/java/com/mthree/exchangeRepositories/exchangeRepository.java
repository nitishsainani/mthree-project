package com.mthree.exchangeRepositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

@Repository
public interface ExchangeRepository extends JpaRepository <Exchange,Integer> {

}