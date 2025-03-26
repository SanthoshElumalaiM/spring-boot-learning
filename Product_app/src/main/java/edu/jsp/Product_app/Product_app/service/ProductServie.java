package edu.jsp.Product_app.Product_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.jsp.Product_app.Product_app.entity.Product;
import edu.jsp.Product_app.Product_app.repo.ProductRepository;

@Service
public class ProductServie {
	
	@Autowired
	ProductRepository productRepository;
	
	public Product saveProduct(Product p)
	{
		return  productRepository.save(p);
	}
	
	public Product fectById(long id)
	{
		Optional<Product> o= productRepository.findById(id);
		
		if(o.isPresent()) {
			return o.get();
		}
		return null;
	}

	public List<Product> fetchAll()
	{
		return productRepository.findAll();
	}
}
