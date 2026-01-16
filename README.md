# ManagingTransaction-In-Spring-Boot

This project shows how to handle database transactions in a Spring Boot application using `@Transactional`.

It uses a simple Order and Payment flow to explain why transactions matter.  
Without `@Transactional`, an order can be saved even when payment fails, which leads to inconsistent data.

#######
If anything fails during the process, all changes made in that transaction are rolled back (undone) so the database stays consistent.

###### Steps a person takes:

Add items to cart → create an order record in DB.
Make a payment → deduct money from account.
Possible problem without @Transactional:
Payment is successful, but saving the order fails (maybe a database error).
Now money is gone, but the order isn’t recorded — inconsistent state.

#### With @Transactional:

Both order saving and payment deduction happen inside one transaction.
If any step fails (like order saving), everything is rolled back — the payment is undone, the order is not saved.
The system stays consistent.
By using `@Transactional` at the service layer, Spring ensures that all related operations either succeed together or are rolled back when something goes wrong.

This project was built mainly for learning purposes and to help junior developers understand transaction management in Spring Boot.
