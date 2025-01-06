# Hibernate Shopping Cart

This project is a simple shopping cart application using Hibernate ORM. It demonstrates basic CRUD operations and relationships between entities such as User, Cart, and Product.

## Project Structure

```
Hibernate_Shopping_Cart/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── jsp/
│   │   │   │   │   ├── hibernate/
│   │   │   │   │   │   ├── shopping_cart/
│   │   │   │   │   │   │   ├── App.java
│   │   │   │   │   │   │   ├── dao/
│   │   │   │   │   │   │   │   ├── ShoppingCartDao.java
│   │   │   │   │   │   │   ├── entity/
│   │   │   │   │   │   │   │   ├── Cart.java
│   │   │   │   │   │   │   │   ├── Product.java
│   │   │   │   │   │   │   │   ├── User.java
│   ├── resources/
│   │   ├── hibernate.cfg.xml
│
├── pom.xml
├── README.md
```

## Entities

### User

Represents a user in the system.

```java
@Entity
public class User {
    @Id
    private int userId;
    private String username;
    private String email;
    private String location;
    private String city;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    // Getters and Setters
}
```

### Cart

Represents a shopping cart associated with a user.

```java
@Entity
public class Cart {
    @Id
    private int cartId;

    @ManyToMany
    private List<Product> products;

    @OneToOne
    private User user;

    // Getters and Setters
}
```

### Product

Represents a product in the system.

```java
@Entity
public class Product {
    @Id
    private int productId;
    private String productName;
    private String productBrand;
    private int productPrice;

    // Getters and Setters
}
```

## DAO

### ShoppingCartDao

Contains methods to perform CRUD operations on the entities.

```java
public class ShoppingCartDao {
    // Configuration and SessionFactory setup

    public void addProduct() {
        // Implementation
    }

    public void addUserWithCart() {
        // Implementation
    }

    public void addProductToCart() {
        // Implementation
    }

    public void removeProductFromCart() {
        // Implementation
    }

    public void findAllProductFromCart() {
        // Implementation
    }
}
```

## Main Application

### App

Contains the main method to interact with the user and perform operations.

```java
public class App {
    public static void main(String[] args) {
        ShoppingCartDao dao = new ShoppingCartDao();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Product");
            System.out.println("2. Add User with Cart");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Find All Products from Cart");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dao.addProduct();
                    break;
                case 2:
                    dao.addUserWithCart();
                    break;
                case 3:
                    dao.addProductToCart();
                    break;
                case 4:
                    dao.removeProductFromCart();
                    break;
                case 5:
                    dao.findAllProductFromCart();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
```

## Configuration

### Hibernate Configuration

The `hibernate.cfg.xml` file contains the configuration for Hibernate.

```xml
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL8Dialect</property>
        <property name="hibernate.connection.driver_class">com.mysql.cj.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernate_shopping_cart?createDatabaseIfNotExist=true</property>
        <property name="hibernate.connection.username">root</property>
        <property name="hibernate.connection.password">password</property>
        <property name="hibernate.hbm2ddl.auto">update</property>
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>

        <mapping class="com.jsp.hibernate.shopping_cart.entity.User"/>
        <mapping class="com.jsp.hibernate.shopping_cart.entity.Cart"/>
        <mapping class="com.jsp.hibernate.shopping_cart.entity.Product"/>
    </session-factory>
</hibernate-configuration>
```

## Running the Application

1. Ensure you have MySQL running and create a database named `hibernate_shopping_cart`.
2. Update the `hibernate.cfg.xml` file with your MySQL username and password.
3. Run the `App` class to start the application.

## License

This project is licensed under the MIT License.
