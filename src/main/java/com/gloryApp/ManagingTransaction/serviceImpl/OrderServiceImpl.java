package com.gloryApp.ManagingTransaction.serviceImpl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.gloryApp.ManagingTransaction.dto.OrderRequest;
import com.gloryApp.ManagingTransaction.dto.OrderResponse;
import com.gloryApp.ManagingTransaction.entity.Order;
import com.gloryApp.ManagingTransaction.entity.Payment;
import com.gloryApp.ManagingTransaction.exception.PaymentException;
import com.gloryApp.ManagingTransaction.repository.OrderRepository;
import com.gloryApp.ManagingTransaction.repository.PaymentRepository;
import com.gloryApp.ManagingTransaction.service.OrderService;

@Service

public class OrderServiceImpl implements OrderService{

    private OrderRepository orderRepository;
    private PaymentRepository paymentRepository;

    public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }


    // This method is to save the Order Details
    @Override
    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setStatus("INPROGRESS");
        order.setOrderTrackingNumber(UUID.randomUUID().toString());
        orderRepository.save(order);

        Payment payment = orderRequest.getPayment();

    if (!payment.getCardType().equals("DEBIT")){
        // Add payment processing logic here
        throw new PaymentException("Payment card Type not supported");
    }

    // To Save the Payment Details

    // Setting order id to payment, then call the OrderId and then get the orderId from the order object.
    payment.setOrderId(order.getId());
     paymentRepository.save(payment);

     // Crating Order Response
     OrderResponse orderResponse = new OrderResponse();
     
     //Filling up order response object
     orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
     orderResponse.setStatus(order.getStatus());
     orderResponse.setMessage("SUCCESS");

        return orderResponse;
    

}

/** NOTE
 Without transaction, what happens basically is that, the order information will get saved in the db.
 But if payment fails for this order, then payment info won't save in the db.

 Let say, if a user enters th payment card as a credit card, then what will happen is that, the above
 condition will throw an exception and the payment details won't save in the db.
 But if the @Transactional annotation is used, then the order details that is saved will get rollback
 */

}
