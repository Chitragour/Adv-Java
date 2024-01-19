package com.demo.service;

import java.util.List;

import com.demo.controller.ProductController;
import com.demo.model.*;

public interface ProductService {

	

	List<Product> getAllProducts();

	void addnewProduct(Product p);

	Product getById(int pid);

	void updateById(Product product);

	void deleteById(int id);



}
