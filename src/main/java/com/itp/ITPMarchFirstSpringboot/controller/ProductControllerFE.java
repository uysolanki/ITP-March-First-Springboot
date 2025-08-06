package com.itp.ITPMarchFirstSpringboot.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itp.ITPMarchFirstSpringboot.entity.Product;
import com.itp.ITPMarchFirstSpringboot.service.ProductService;

@Controller
public class ProductControllerFE {
	
	@Autowired
	ProductService productService;
	
	@RequestMapping("/addProductForm")
	public String addProductForm(Model model)
	{
		Product product =new Product();
		model.addAttribute("product",product);
		return "add-product-form";
	}
	
	@PostMapping("/addSingleProduct")
	public String addSingleProduct(@ModelAttribute Product product)
	{
		productService.addSingleProduct(product);
		return "redirect:/allProducts";
	}
	
	@RequestMapping("/allProducts")
	public String allProducts(Model model)
	{
		List<Product> products= productService.allProducts();
		model.addAttribute("products",products);
		return "all-products";
	}
	
	@GetMapping("/deleteProduct/{prodId}")
	public String deleteProduct(@PathVariable int prodId )
	{
		productService.deleteProduct(prodId);
		return "redirect:/allProducts";
	}
	
	
	@GetMapping("/updateProductForm/{prodId}")
	public String updateProductForm(@PathVariable int prodId,Model model )
	{
		Product product=productService.getSingleProduct(prodId);
		model.addAttribute("product",product);
		return "update-product-form";
	}
	
	
	@PostMapping("/updateProduct/{prodId}")
	public String updateProduct(@PathVariable int prodId, @ModelAttribute Product newValues )
	{
		productService.updateProduct(prodId,newValues);
		return "redirect:/allProducts";
	}
	
	
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			    "you do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

	
	@GetMapping("/getSingleProduct/{prodId}")
	public Product getSingleProduct(@PathVariable int prodId)
	{
		return productService.getSingleProduct(prodId);
	}
	
	@GetMapping("/products/sort/{field}/{direction}")
	public List<Product> sortProducts(@PathVariable String field,@PathVariable String direction)
	{
		return productService.sortProducts(field,direction);
	}
	
	@GetMapping("/productsByPagination/{pageNumber}/{pageSize}")
	public Page<Product> productsByPagination(@PathVariable int pageNumber,@PathVariable int pageSize)
	{
		return productService.productsByPagination(pageNumber,pageSize);
	}

	@GetMapping("/productsBySortAndPagination/{pageNumber}/{pageSize}/{fieldName}")
	public Page<Product> productsBySortAndPagination(@PathVariable int pageNumber,@PathVariable int pageSize,@PathVariable String fieldName)
	{
		return productService.productsBySortAndPagination(pageNumber,pageSize,fieldName);
	}
	
	
	
	
	
	@GetMapping("/calTimeFromLastModify/{prodId}")
	public String calTimeFromLastModify(@PathVariable int prodId)
	{
		long days= productService.calTimeFromLastModify(prodId);
		return "Last Modified was before " + days + " days. ";
	}
	
	
}
