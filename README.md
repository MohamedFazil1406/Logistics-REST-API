# RSM Pack and Drop — Logistics REST API

A backend REST API for a pickup-and-delivery logistics service, built with Java, Spring Boot, Spring Data JPA, and MySQL.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Maven](https://img.shields.io/badge/Build-Maven-red)

## Overview

RSM Pack and Drop is a logistics backend REST API designed to support pickup-and-delivery operations. It provides full CRUD (Create, Read, Update, Delete) functionality across four core modules: **Customers**, **Orders**, **Drivers**, and **Deliveries**. The API has been tested using Postman.

## Features

- Full CRUD operations for Customers, Orders, Drivers, and Deliveries
- RESTful JSON API built on Spring Web
- Persistent storage in MySQL via Spring Data JPA (Hibernate), with tables auto-created on startup
- Tested with Postman for endpoint validation

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4.1.1
- **Data Layer:** Spring Data JPA (Hibernate)
- **Database:** MySQL
- **Build Tool:** Maven (with Maven Wrapper)
- **Utilities:** Lombok, Spring Boot DevTools
- **API Testing:** Postman

## Project Structure

```
Logistics-REST-API/
├── src/
│   ├── main/
│   │   ├── java/com/restAPI/rsm_pack_and_drop/
│   │   │   ├── RsmPackAndDropApplication.java   # Application entry point
│   │   │   ├── controller/
│   │   │   │   ├── CustomerController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   ├── DriverController.java
│   │   │   │   └── DeliveryController.java
│   │   │   ├── model/
│   │   │   │   ├── Customer.java
│   │   │   │   ├── Order.java
│   │   │   │   ├── Driver.java
│   │   │   │   └── Delivery.java
│   │   │   └── repo/
│   │   │       ├── CustomerRepo.java
│   │   │       ├── OrderRepo.java
│   │   │       ├── DriverRepo.java
│   │   │       └── DeliveryRepo.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/                                    # Unit and integration tests
├── pom.xml                                      # Maven configuration and dependencies
├── mvnw / mvnw.cmd                              # Maven wrapper scripts
└── .gitignore
```

## Installation & Setup

### Prerequisites

- Java 21 (JDK)
- MySQL installed and running on `localhost:3306`
- Maven (or use the included Maven Wrapper, no separate install needed)

### Steps

1. **Clone the repository**
   ```bash
   git clone https://github.com/Sai-manoj-ranga/Logistics-REST-API.git
   cd Logistics-REST-API
   ```

2. **Create the database**
   ```sql
   CREATE DATABASE logistics;
   ```

3. **Configure the application**

   Update `src/main/resources/application.properties` with your MySQL credentials:
   ```properties
   spring.application.name=rsm_pack_and_drop
   server.port=1919

   spring.datasource.url=jdbc:mysql://localhost:3306/logistics
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **Build the project**
   ```bash
   ./mvnw clean install
   ```

5. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

   The API starts on **http://localhost:1919**.

## API Endpoints

Base URL: `http://localhost:1919`

### Customers

| Method | Endpoint                | Description        |
|--------|-------------------------|--------------------|
| GET    | `/getCustList`          | Get all customers  |
| GET    | `/getCustomer/{cid}`    | Get customer by ID |
| POST   | `/createCustomer`       | Create a customer  |
| PUT    | `/updateCustomer/{cid}` | Update a customer  |
| DELETE | `/deleteCustomer/{cid}` | Delete a customer  |

### Orders

| Method | Endpoint                      | Description     |
|--------|-------------------------------|-----------------|
| GET    | `/getOrderDetails`            | Get all orders  |
| GET    | `/getOrderDetails/{order_id}` | Get order by ID |
| POST   | `/createOrders`               | Create an order |
| PUT    | `/updateOrder/{order_id}`     | Update an order |
| DELETE | `/deleteOrder/{order_id}`     | Delete an order |

### Drivers

| Method | Endpoint             | Description      |
|--------|----------------------|------------------|
| GET    | `/driversList`       | Get all drivers  |
| GET    | `/driver/{id}`       | Get driver by ID |
| POST   | `/newDriverEntry`    | Add a new driver |
| PUT    | `/updateDriver/{id}` | Update a driver  |
| DELETE | `/driverleft/{id}`   | Remove a driver  |

### Deliveries

| Method | Endpoint                    | Description        |
|--------|-----------------------------|--------------------|
| GET    | `/getDeliveryDetails`       | Get all deliveries |
| GET    | `/getDeliveryInfo/{did}`    | Get delivery by ID |
| POST   | `/createDeliveryInfo`       | Create a delivery  |
| PUT    | `/updateDeliveryInfo/{did}` | Update a delivery  |
| DELETE | `/deleteDeliveryInfo/{did}` | Delete a delivery  |

## Data Models

| Entity   | Table              | Fields |
|----------|--------------------|--------|
| Customer | `Customer_Details` | `cid`, `cName`, `email`, `PhoneNumber`, `Address` |
| Order    | `Order_details`    | `order_id`, `orderNumber`, `productName`, `quantity`, `weight`, `pickupAddress`, `deliveryAddress`, `orderDate`, `status` |
| Driver   | `Driver_details`   | `id`, `dname`, `phone`, `licenseNumber`, `vehicleNumber`, `availabilityStatus` |
| Delivery | `delivery_Details` | `did`, `deliveryId`, `orderDetails`, `driver`, `pickupTime`, `deliveryTime`, `status` |

## Example Requests

**Create a customer**
```bash
curl -X POST http://localhost:1919/createCustomer \
  -H "Content-Type: application/json" \
  -d '{
    "cName": "Ravi Kumar",
    "email": "ravi@example.com",
    "phoneNumber": "9876543210",
    "address": "Hyderabad, Telangana"
  }'
```

**Add a driver**
```bash
curl -X POST http://localhost:1919/newDriverEntry \
  -H "Content-Type: application/json" \
  -d '{
    "dname": "Suresh",
    "phone": "9123456780",
    "licenseNumber": "TS09-2020-1234567",
    "vehicleNumber": "TS09AB1234",
    "availabilityStatus": "Available"
  }'
```

## Screenshots / Demo

<img width="887" height="235" alt="image" src="https://github.com/user-attachments/assets/56029b2e-09f1-4752-b6f1-7703a23c3836" />
<img width="934" height="253" alt="image" src="https://github.com/user-attachments/assets/987b84b1-3a5a-4e3b-a16f-933473cc5181" />
<img width="932" height="256" alt="image" src="https://github.com/user-attachments/assets/982fc9e1-39a3-4816-ba89-162624648fa1" />
<img width="931" height="425" alt="image" src="https://github.com/user-attachments/assets/2e56440b-d5d6-468d-ad0d-66a88a5186e8" />





## Results / Outcomes

- Implemented full CRUD functionality across 4 logistics modules (Customers, Orders, Drivers, Deliveries)
- Validated all API endpoints using Postman

## Future Improvements

- Link entities with JPA relationships (Customer → Order → Delivery → Driver)
- Add input validation and centralized exception handling (return 404 for missing IDs)
- Use proper date/time types and a proper type for `Order.productName`
- Add authentication and authorization (Spring Security + JWT)
- Add Swagger/OpenAPI documentation
- Write unit and integration tests for all modules
- Containerize with Docker for easier deployment

## Author

**Sai Manoj Ranga**
- GitHub: [@Sai-manoj-ranga](https://github.com/Sai-manoj-ranga)
- LinkedIn: [ranga-sai-manoj](https://www.linkedin.com/in/ranga-sai-manoj/)
- Email: saimanojranga1919@gmail.com
