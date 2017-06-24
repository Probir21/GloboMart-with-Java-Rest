package org.globomart.productcatalogue.database;

import java.util.HashMap;
import java.util.Map;

import org.globomart.productcatalogue.model.Product;

public class ProductDatabase {
	private static Map<Integer, Product> productDatabase = new HashMap<>();

	public static Map<Integer, Product> getProductDatabase() {
		return productDatabase;
	}
}
