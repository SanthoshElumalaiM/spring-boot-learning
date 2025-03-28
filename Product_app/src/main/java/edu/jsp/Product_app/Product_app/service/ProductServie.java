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
	
	public Product fetchById(long id)
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
	
	public String deleteById(long id)
	{
		Product p=fetchById(id);
		
		if(p!=null)
		{
			productRepository.deleteById(id);
			return "data deleted";
		}
		else {
			return "data not found";
		}
	}
	
	public String updatePrice(long id,double price)
	{
		Product p=fetchById(id);
		if(p!=null)
		{
			p.setPrice(price);
			productRepository.save(p);
			return "data updated";
			
		}
		else {
			return "data not found";
		}
		
	}
	
	public String update(Long id,Product newProd)
	{
		Product exProd= fetchById(id);
		
		if(exProd!=null)
		{
			newProd.setPid(id);
			productRepository.save(newProd);
			return "data updated";
			
		}
		return "data not found";
	}
	
}
