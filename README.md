# ManagingTransactionIn-Spring-Boot

This project shows how to handle database transactions in a Spring Boot application using `@Transactional`.

It uses a simple Order and Payment flow to explain why transactions matter.  
Without `@Transactional`, an order can be saved even when payment fails, which leads to inconsistent data.

By using `@Transactional` at the service layer, Spring ensures that all related operations either succeed together or are rolled back when something goes wrong.

This project was built mainly for learning purposes and to help junior developers understand transaction management in Spring Boot.
