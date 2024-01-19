package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.*;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao pdao;
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.findAll();
	}
	@Override
	public void addnewProduct(Product p) {
		// TODO Auto-generated method stub
		pdao.save(p);
		
	}
	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		Optional<Product>op= pdao.findById(pid);
		if(op.isPresent())
		{
			return op.get();
		}
		return null;
	}
	@Override
	public void updateById(Product product) {
		// TODO Auto-generated method stub
		Optional<Product> op=pdao.findById(product.getPid());
		if(op.isPresent())
		{
			Product p=op.get();
			p.setPname(product.getPname());
			p.setPrice(product.getPrice());
			pdao.save(p);
		}
		
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		pdao.deleteById(id);
		
	}


}
