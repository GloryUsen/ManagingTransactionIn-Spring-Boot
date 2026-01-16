package com.gloryApp.ManagingTransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gloryApp.ManagingTransaction.entity.Order;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends JpaRepository<Order, Long>{


    @Override
    @Transactional(timeout = 10)
    void deleteById(Long aLong);
}
