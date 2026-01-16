package com.gloryApp.ManagingTransaction.service;

import com.gloryApp.ManagingTransaction.dto.OrderRequest;
import com.gloryApp.ManagingTransaction.dto.OrderResponse;

public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
