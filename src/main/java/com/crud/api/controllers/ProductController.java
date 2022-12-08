package com.crud.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.api.entities.Product;
import com.crud.api.services.ProductService;

@RestController
public class ProductController {
	
	//To inject ProductService in Controller
	@Autowired
	private ProductService productService;
	
	//To save a single product
	@PostMapping("/addProduct")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	//To save multiple products
	@PostMapping("/addProducts")
	public List<Product> saveProducts(@RequestBody List<Product> products){
		return productService.saveProducts(products);
	}
	
	//To get all products
	@GetMapping("/products")
	public List<Product> findProducts() {
		return productService.getProducts();
	}
	
	//To get a product by it's id
	@GetMapping("/productById/{id}")
	public Product findProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	//To get a product by it's name
	@GetMapping("/productByName/{name}")
	public Product findProductByName(@PathVariable String name) {
		return productService.getProductByName(name);
	}
	
	//To update a product
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	//To delete a product
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		return productService.deleteProduct(id);
	}
	
}
