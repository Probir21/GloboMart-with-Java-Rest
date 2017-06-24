package org.globomart.productcatalogue.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.globomart.productcatalogue.database.ProductDatabase;
import org.globomart.productcatalogue.model.Product;


/*Create stub for database instead of actual database. 
 * Here use a map to store the value instead of
 * actual database. So after bounce the server
 * all data will be deleted.
 */
public class ProductCatalogueService {
	
	private Map<Integer, Product> products = ProductDatabase.getProductDatabase();
	
	//Add a product
	public Integer addNewProduct(Product product){
		products.put(product.getProductId(), product);
		return product.getProductId();
	}
	
	//Remove a product
	public Integer removeProduct(int id){
		Product product = products.get(id);
		products.remove(id);
		return product.getProductId();
	}
	
	//Show all products
	public List<Product> getProducts(){
		return new ArrayList<Product>(products.values());
	}

	//Show all products of given type
	public List<Product> getProductByType(String type){
		List<Product> sameTypeOfProducts = new ArrayList<>();
		List<Product> productList = new ArrayList<>(products.values());
		for(Product product : productList){
			if(product.getProductType().equals(type)){
				sameTypeOfProducts.add(product);
			}
		}
		return sameTypeOfProducts;
	}
	
	//Show price of a given product
	public Double getPriceById(int id) {
		return products.get(id).getPrice();
	}
}
