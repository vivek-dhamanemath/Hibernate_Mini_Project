package com.hibernate.Hibernate_Shopping_Cart;


import java.util.Scanner;

import com.hibernate.Hibernate_Shopping_Cart.dao.ShoppingCartDao;

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