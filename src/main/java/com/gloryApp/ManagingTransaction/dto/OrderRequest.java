package com.gloryApp.ManagingTransaction.dto;

import com.gloryApp.ManagingTransaction.entity.Order;
import com.gloryApp.ManagingTransaction.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class OrderRequest {
    private Order order;
    private Payment payment;


}
