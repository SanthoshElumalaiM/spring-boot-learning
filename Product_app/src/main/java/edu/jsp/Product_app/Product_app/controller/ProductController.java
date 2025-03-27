package edu.jsp.Product_app.Product_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.jsp.Product_app.Product_app.entity.Product;
import edu.jsp.Product_app.Product_app.service.ProductServie;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	ProductServie productServie;
	
	@PostMapping("save")
	public Product saveProduct(@RequestBody Product p)
	{
		return  productServie.saveProduct(p);
	}
	
	@GetMapping("fetchById")
	public Product fetchById(long id) {
		return productServie.fetchById(id);
	}
	
	@GetMapping("fetchAll")
	public List<Product> fetchAll(){
		return productServie.fetchAll();
	}
	
	@DeleteMapping("deleteById/{id}")
	public String deleteById(@PathVariable long  id)
	{
		Product p=fetchById(id);
		if(p!=null)
		{
			productServie.deleteById(id);
			return "data deleted";
		}
		else {
			return "data not found";
		}
	}
	@PutMapping("updatePrice")
	public String updatePrice(@RequestParam long id,@RequestParam  double price)
	{
		 Product p=fetchById(id);
		 if(p!=null)
		 {
			 p.setPrice(79999);
			 productServie.update(id, price);
			 return "data updated";
		 }
		 else {
			 return "data not found";
		 }
		
	}
}
