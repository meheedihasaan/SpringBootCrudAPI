package com.crud.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.api.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	//To find product by it's name
	Optional<Product> findByName(String name);

}
