package edu.jsp.Product_app.Product_app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.jsp.Product_app.Product_app.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	

	//save
	//findById(id)
	//findAll()
	//deleteById(id)
	//delete(Object o)
	
	Product findByName(String name);
	
	@Query(value="select p from Product p where p.price > :price")
	List<Product> fecthByPrice(@Param("price") double price);
	
}
