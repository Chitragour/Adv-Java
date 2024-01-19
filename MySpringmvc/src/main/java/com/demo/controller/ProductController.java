package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.*;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService pservice;
	
	@GetMapping("/getproducts")
	public ModelAndView getProducts(HttpSession session) {
		User u=(User) session.getAttribute("user");
		if(u!=null) {
		   System.out.println(u);
		   List<Product> plist=pservice.getAllProducts();
		   return new ModelAndView("displayproduct","plist",plist);
		}
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping("/addproduct")
	public String displayaddform(HttpSession session) {
		User u=(User) session.getAttribute("user");
		if(u!=null) 
		   return "addproduct";
		return "redirect:/"; 
	}
	
	@PostMapping("/insertProduct")
	public ModelAndView insertProduct(@RequestParam int pid, @RequestParam String pname,@RequestParam int price) {
		Product p=new Product(pid,pname,price);
		pservice.addnewProduct(p);
		return new ModelAndView("redirect:/product/getproducts");
		
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") int pid) {
		Product p=pservice.getById(pid);
		return new ModelAndView("editProduct","p",p);
		
	}
	
	@PostMapping("/updateProduct")
	public ModelAndView updateProdut(@RequestParam int pid, @RequestParam String pname,@RequestParam int price) {
		pservice.updateById(new Product(pid,pname,price));
		return new ModelAndView("redirect:/product/getproducts");
	}
	
	@GetMapping("delete/{id}")
	public ModelAndView deleteProduct(@PathVariable int id) {
		pservice.deleteById(id);
		return new ModelAndView("redirect:/product/getproducts");
	}
	
}
