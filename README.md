# Simple-Payment-Tracking-API

# Tech Stack
my project created using spring initializr and dawnload zip and inside add dependancy
1 Java 17
2 Spring Boot 3
3 MySQL
4 Maven 
5 Postman for testing


 # MY Code formate
 Code Structure pallav project
 1src/
  main/     
  java/
- com.axipays/           //inside this created packages >controller,model, repo,service created
- controller → REST Controllers
- model/ → JPA Entity Models
- repository/ → JPA Repositories
- service/ → Business logic wrire
- resources/
- application.properties → DB config kiya
  

# Setup
Create DB:using sql
CREATE DATABASE payment_db; and run server

After this

In src/main/resources/application.properties  """""inside properties provide my username and pass to access data"""""

# properties>

spring.datasource.url=jdbc:mysql://localhost:3306/payment_db
spring.datasource.username=root
spring.datasource.password=Pallav@8269 
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

after this run project using cmd:



# mvn spring-boot:run

checking API usigg postmen



# API Endpoints

POST:Create a user

{
  "name": "John Doe",
  "email": "john@example.com",
  "phone": "1234567890",
  "country": "IN"
}
GET/by users url
List all users

PUT /users/id // """"id mean after run post database auto created id so put here using update delete get data by ID""""
Update user by ID

DELETE /users/id
Delete user by ID

Payments
POST /users/id/payments
Add a payment for a user
{
  "amount": 100.50,
  "currency": "USD",
  "description": "Test",
  "cardNo": "4111111111111111",
  "cardExpiry": "12/26",
  "cardCvc": "123"
}


GET /users/id/payments
Get all payments for a user


# Include
User and Payment CRUD operation
Luhn Algorithm Card Validation """" all added algo inside my code""
Mask card number in responses
Error handling with HTTP codes
Input validation


# Database Schema
users

#payments



# postman Testing i check my all api using postmen  
All APIs can be tested using Postman.





  
