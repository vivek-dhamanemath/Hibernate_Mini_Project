package com.hibernate.Hibernate_Shopping_Cart.dao;

import java.util.Scanner;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Hibernate_Shopping_Cart.entity.Cart;
import com.hibernate.Hibernate_Shopping_Cart.entity.Product;
import com.hibernate.Hibernate_Shopping_Cart.entity.User;


public class ShoppingCartDao {

	Configuration cfg = new Configuration().configure()
											.addAnnotatedClass(User.class)
											.addAnnotatedClass(Cart.class)
											.addAnnotatedClass(Product.class);
	SessionFactory sf = cfg.buildSessionFactory();

	Scanner sc = new Scanner(System.in);

	public void addProduct() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		Product product = new Product();

		System.out.println("Enter product Id:");
		product.setProductId(sc.nextInt());
		sc.nextLine(); // consume newline

		System.out.println("Enter product name:");
		product.setProductName(sc.nextLine());

		System.out.println("Enter product brand:");
		product.setProductBrand(sc.nextLine());

		System.out.println("Enter product price:");
		product.setProductPrice(sc.nextInt());
		sc.nextLine(); // consume newline

		session.save(product);
		tran.commit();
		session.close();
	}

	public void addUserWithCart() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		User user = new User();

		System.out.println("Enter user Id:");
		user.setUserId(sc.nextInt());
		sc.nextLine(); // consume newline

		System.out.println("Enter user name:");
		user.setUsername(sc.nextLine());

		System.out.println("Enter user email:");
		user.setEmail(sc.nextLine());

		System.out.println("Enter user location:");
		user.setLocation(sc.nextLine());

		System.out.println("Enter user city:");
		user.setCity(sc.nextLine());

		Cart cart = new Cart();
		
		cart.setUser(user);
		user.setCart(cart);

		session.save(user);
		tran.commit();
		session.close();
		System.out.println("User with cart Saved Succesfully");
	}

	public void addProductToCart() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter product ID:");
		Product product = session.get(Product.class, sc.nextInt()); 
		sc.nextLine(); // consume newline

		if (product != null) {
			System.out.println("Enter the User Id:");
			User user = session.get(User.class, sc.nextInt());
			sc.nextLine(); // consume newline

			if(user!= null) {
				Cart cart = user.getCart();
				List<Product> plist = cart.getProducts();
				plist.add(product);

				session.update(cart);
				System.out.println("Product added to the cart");
			} else {
				System.out.println("User not found by Id!!");
			}
		} else {
			System.err.println("Product not found By Id!");
		}
		
		tran.commit();
		session.close();
	}
	
	public void removeProductFromCart() {
		Session session = sf.openSession();
		Transaction tran = session.beginTransaction();

		System.out.println("Enter product ID:");
		Product product = session.get(Product.class, sc.nextInt()); 
		sc.nextLine(); // consume newline

		if (product != null) {
			System.out.println("Enter the User Id:");
			User user = session.get(User.class, sc.nextInt());
			sc.nextLine(); // consume newline

			if(user!= null) {
				Cart cart = user.getCart();
				List<Product> plist = cart.getProducts();
				plist.add(product);

				session.update(cart);
				System.out.println("Product added to the cart");
			} else {
				System.out.println("User not found by Id!!");
			}
		} else {
			System.err.println("Product not found By Id!");
		}
		
		tran.commit();
		session.close();
	}


	public void findAllProductFromCart() {
		Session session = sf.openSession();

		System.out.println("Enter user ID:");
		int userId = sc.nextInt();
		sc.nextLine(); // consume newline

		User user = session.get(User.class, userId);

		if (user != null) {
			Cart cart = user.getCart();
			List<Product> products = cart.getProducts();
			for (Product product : products) {
				System.out.println("All products Details");
				System.out.println(product);
			}
		} else {
			System.out.println("User not found!");
		}

		session.close();
	}
}