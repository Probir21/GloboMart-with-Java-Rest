package org.globomart.productcatalogue.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.globomart.productcatalogue.model.Product;
import org.globomart.productcatalogue.service.ProductCatalogueService;

@Path("/products")
public class ProductResource {
	ProductCatalogueService productCatService = new ProductCatalogueService();
	
	//Add a product
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String addProduct(Product product) {
		int id = productCatService.addNewProduct(product);
		return "Product added with id : "+ id ;
	}
	
	//Delete a product based on Product Id
	@DELETE
	@Path("/{productId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String removeProduct(@PathParam("productId") int productId){
		int id = productCatService.removeProduct(productId);
		return "Product deleted with id : "+ id ;
	}
	
	//Retrieve all products
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getAllProducts(){
		return productCatService.getProducts();
	}
	
	//Retrieve all products of given type
	@GET
	@Path("/productType/{productType}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Product> getProductByType(@PathParam("productType") String productType){
		return productCatService.getProductByType(productType);
	}
	
	//Retrieve price of given product id
	@GET
	@Path("/{productId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getPriceById(@PathParam("productId") int productId){
		Double price = productCatService.getPriceById(productId);
		return "Price of Product Item : "+ productId + " is : "+ price;
	}

}
