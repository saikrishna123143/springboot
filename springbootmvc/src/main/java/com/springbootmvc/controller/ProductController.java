package com.springbootmvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springbootmvc.entity.ProductEntity;
import com.springbootmvc.model.ProductModel;
import com.springbootmvc.service.ProductService;

import jakarta.validation.Valid;

@Controller
public class ProductController {
@Autowired
ProductService productService;
@GetMapping("/productform")
public String getProductForm(ProductModel productModel,Model model)
{
	
	productModel.setMadein("India");
	productModel.setQuantity(2);
	productModel.setDiscountrate(10.00);
	model.addAttribute("productModel",productModel);
	return "addproduct";
}
@PostMapping("/savepoint")
public String savepoint(@Valid ProductModel productModel,BindingResult bindingResult,Model model)
{
	HashMap<String,String>validationerror=new HashMap<String,String>();
	if(bindingResult.hasErrors())
	{
	for(FieldError error:bindingResult.getFieldErrors())
	{
		validationerror.put(error.getField(),error.getDefaultMessage());
	}
	model.addAttribute("error",validationerror);
	return "addproduct";
	}
	productService.serviceLogic(productModel);
	return "redirect:/getDetails";
}
@GetMapping("/contactus")
public String getcontactus()
{
	return "contactus";
}
@PostMapping("/contact")
public String savecontact()
{
	return "success1";
}
@GetMapping("/aboutus")
public String getaboutus()
{
	return "aboutus";
}
@GetMapping("/getDetails")
public String getdetails(Model model)
{
	List<ProductEntity>products=productService.getdetails();
	model.addAttribute("balayya",products);
	return "productdetails";
}
@GetMapping("/search")
public String search()
{
	return "searchproduct";
}
@PostMapping("/search-product")
public String searchproduct(int id,Model model)
{
	ProductEntity productEntity= productService.searchpro(id);
	model.addAttribute("balayya",productEntity);
	return "searchproduct";
}
@GetMapping("/delete/{id}")
public String deleteproductbyid(@PathVariable("id") int id)
{
	productService.deleteproductbyid(id);
	return "redirect:/getDetails";
}
@GetMapping("/edit/{id}")
public String editform(@PathVariable("id") int id,Model model)
{
	ProductModel model2=new ProductModel();
	model2=productService.editform(id);
	model.addAttribute("product", model2);
	model.addAttribute("id",id);
	return "edit-form";
}
@PostMapping("/editsubmit/{id}")
public String editsubmit(@PathVariable int id,ProductModel model)
{
	productService.editsubmit(model,id);
	return "redirect:/getDetails";
}

}
