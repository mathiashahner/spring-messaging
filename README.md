# spring-messaging

- PRODUCT_MICROSERVICE_BASE_URL=http://localhost:8080
- ORDER_MICROSERVICE_BASE_URL=http://localhost:8081

### Setup

- Clone repository:
```
git clone https://github.com/mathiashahner/spring-microservices-messaging.git
```
- Change directory:
```
cd spring-microservices-messaging
```
- Build and Run:
```
docker-compose up --build
```

### Test
- With the application running, access Swagger:
  - [product-microservice](http://localhost:8080/swagger-ui/index.html)
  - [order-microservice](http://localhost:8081/swagger-ui/index.html)
