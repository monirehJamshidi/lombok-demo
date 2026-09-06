# Lombok Demo

A small Spring Boot project demonstrating how **Project Lombok** can reduce boilerplate code and improve code readability in Java applications.

The project focuses on commonly used Lombok annotations and shows how they can be used in a simple service-based application.

## 🚀 Technologies

* Java
* Spring Boot
* Project Lombok
* Maven
* REST API

## 📚 Lombok Annotations Covered

### `@Getter`

Generates getter methods automatically.

### `@Setter`

Generates setter methods automatically.

### `@Builder`

Provides the Builder pattern for readable and flexible object creation.

```java
Order order = Order.builder()
        .id(1L)
        .product("Laptop")
        .quantity(5)
        .price(1500.0)
        .build();
```

### `@Value`

Creates an immutable-style class with:

* `private final` fields
* getters
* required constructor
* `equals()`
* `hashCode()`
* `toString()`

No setters are generated.

### `@RequiredArgsConstructor`

Generates a constructor for `final` and `@NonNull` fields.

It is especially useful for constructor injection in Spring applications.

```java
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
}
```

### `@Slf4j`

Automatically creates an SLF4J logger.

```java
@Slf4j
public class OrderService {

    public void createOrder() {
        log.info("Creating a new order");
    }
}
```

## 🏗️ Project Structure

```text
lombok-demo/
├── src/
│   └── main/
│       └── java/
│           └── com.example.lombokdemo/
│               ├── controller/
│               │   └── OrderController.java
│               ├── service/
│               │   └── OrderService.java
│               ├── dto/
│               │   └── OrderResponse.java
│               └── model/
│                   └── Order.java
├── pom.xml
└── README.md
```

## 🔄 Application Flow

The project demonstrates a simple request/response flow:

```text
Client
  ↓
OrderController
  ↓
OrderService
  ↓
Order
  ↓
OrderResponse
  ↓
Client
```

The `Order` model uses `@Builder` and `@Getter`.

The `OrderResponse` DTO uses `@Value` and `@Builder`.

The `OrderService` uses `@RequiredArgsConstructor` and `@Slf4j`.

## ▶️ Running the Project

Clone the repository:

```bash
git clone <your-repository-url>
```

Navigate to the project:

```bash
cd lombok-demo
```

Run the application with Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## 🧪 Testing the API

Send a `POST` request to:

```text
POST http://localhost:8080/orders
```

Example response:

```json
{
  "id": 1,
  "product": "Laptop",
  "quantity": 5,
  "price": 1500.0
}
```

## ⚠️ Lombok and JPA Best Practice

Lombok should be used intentionally, especially with JPA entities.

Using `@Data` blindly on an entity can generate `equals()`, `hashCode()`, `toString()`, and setters that may not be appropriate for JPA entity design.

For entities, it is often better to use specific annotations such as:

```java
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
```

## 🎯 What This Project Demonstrates

This project was created to understand:

* How Lombok reduces boilerplate code
* How common Lombok annotations work
* Builder pattern with `@Builder`
* Immutable DTOs with `@Value`
* Constructor generation with `@RequiredArgsConstructor`
* Logging with `@Slf4j`
* Practical Lombok usage in a Spring Boot application
* Important considerations when using Lombok with JPA

## 💡 Key Takeaway

Lombok is not simply about writing less code.

The important part is understanding **what code each annotation generates and when it is appropriate to use it**.

Less boilerplate ✅
Cleaner code ✅
Better readability ✅
Intentional usage matters. 💡

## 📌 Related LinkedIn Post

I also shared a LinkedIn post about this project and the Lombok annotations covered here.

🔗 LinkedIn: <your-linkedin-post-url>
