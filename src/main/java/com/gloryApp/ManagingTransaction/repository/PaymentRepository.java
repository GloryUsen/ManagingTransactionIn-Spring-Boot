package com.gloryApp.ManagingTransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gloryApp.ManagingTransaction.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
    

}
