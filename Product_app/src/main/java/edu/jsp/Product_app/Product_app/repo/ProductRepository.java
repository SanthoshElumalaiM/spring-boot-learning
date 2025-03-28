package edu.jsp.Product_app.Product_app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.jsp.Product_app.Product_app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

}
