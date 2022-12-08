package com.crud.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.api.entities.Product;
import com.crud.api.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	//To save a single product
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	//To save multiple products
	public List<Product> saveProducts(List<Product> products){
		return productRepo.saveAll(products);
	}
	
	//To get all the products
	public List<Product> getProducts(){
		return productRepo.findAll();
	}
	
	//To get a product by it's id
	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}
	
	//To get a product by it's name
	public Product getProductByName(String name) {
		return productRepo.findByName(name).orElse(null);
	}
	
	//To delete a product
	public String deleteProduct(int id) {
		productRepo.deleteById(id);
		return id+" number Product is deleted.";
	}
	
	//To update a product
	public Product updateProduct(Product product) {
		//Finding the existing product
		Product existing = productRepo.findById(product.getId()).orElse(null);
		
		//Reseting the properties of existing product
		existing.setName(product.getName());
		existing.setQuantity(product.getQuantity());
		existing.setPrice(product.getPrice());
		
		//Saving the existing product
		return productRepo.save(existing);
	}
	
}
