package edu.jsp.Product_app.Product_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
		return productServie.fectById(id);
	}
	
	@GetMapping("fetchAll")
	public List<Product> fetchAll(){
		return productServie.fetchAll();
	}
}
