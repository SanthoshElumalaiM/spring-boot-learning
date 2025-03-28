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
	
	@GetMapping("fetchById/{id}")
	public Product fetchById(@PathVariable Long id) {
		return productServie.fetchById(id);
	}
	
	@GetMapping("fetchAll")
	public List<Product> fetchAll(){
		return productServie.fetchAll();
	}
	
	@DeleteMapping("deleteById/{id}")
	public String deleteById(@PathVariable long  id)
	{
		return	productServie.deleteById(id);
			
	}
	@PutMapping("updatePrice")
	public String updatePrice(@RequestParam long id,@RequestParam  double price)
	{
		 
		return productServie.updatePrice(id, price);
		
	}
	
	@PutMapping("upadte/{id}")
	public String update(@PathVariable Long id ,@RequestBody Product newProd)
	{
		return productServie.update(id, newProd);
	}
}
