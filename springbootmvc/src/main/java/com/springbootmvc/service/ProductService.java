package com.springbootmvc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootmvc.entity.ProductEntity;
import com.springbootmvc.model.ProductModel;
import com.springbootmvc.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public ProductService(ProductRepository productRepository)
	{
		this.productRepository=productRepository;
	}
	public ProductEntity serviceLogic(ProductModel productModel)
	{
	    ProductEntity productEntity=convert(productModel);
		return productRepository.save(productEntity);
	}
	public ProductEntity convert(ProductModel productModel)
	{
		ProductEntity productEntity=new ProductEntity();
		productEntity.setName(productModel.getName());
		productEntity.setBrand(productModel.getBrand());
		productEntity.setMadein(productModel.getMadein());
		productEntity.setPrice(productModel.getPrice());
		productEntity.setQuantity(productModel.getQuantity());
		productEntity.setDiscountrate(productModel.getDiscountrate());
		productEntity.setDiscountamount(((productEntity.getPrice())*(productEntity.getDiscountrate()))/100);
		productEntity.setOfferprice(productEntity.getPrice()-productEntity.getDiscountamount());
		productEntity.setTaxrate(18.00);
		productEntity.setFinalprice(productEntity.getOfferprice()+((productEntity.getTaxrate()*productEntity.getOfferprice())/100));
		productEntity.setStockvalue(productEntity.getPrice()*productEntity.getQuantity());
		return productEntity;
	}
	public List<ProductEntity> getdetails()
	{
		return productRepository.findAll();
	}
	public ProductEntity searchpro(int id)
	{
		Optional<ProductEntity>optionaldata=productRepository.findById(id);
		if(optionaldata.isPresent())
		{
			return optionaldata.get();
		}
		else
		{
		return null;	
		}
	}
	public void deleteproductbyid(int id)
	{
		productRepository.deleteById(id);
	}
   public ProductModel editform(int id)
   {
	   Optional<ProductEntity>product=productRepository.findById(id);
	   if(product.isPresent())
	   {
		   ProductModel model=new ProductModel();
		   ProductEntity pr=new ProductEntity();
		   pr=product.get();
		  model.setName(pr.getName());
		  model.setBrand(pr.getBrand());
		  model.setMadein(pr.getMadein());
		  model.setPrice(pr.getPrice());
		  model.setQuantity(pr.getQuantity());
		  model.setDiscountrate(pr.getDiscountrate());
		   return model;
	   }else
	   {
		   return null;
	   }
	
   }
    public void editsubmit(ProductModel model,int id)
    {
    	Optional<ProductEntity>product=productRepository.findById(id);
    	ProductEntity pro;
    	if(product.isPresent())
    	{
    		pro=product.get();
    	
    	pro.setName(model.getName());
		pro.setBrand(model.getBrand());
		pro.setMadein(model.getMadein());
		pro.setPrice(model.getPrice());
		pro.setQuantity(model.getQuantity());
		pro.setDiscountrate(model.getDiscountrate());
		pro.setDiscountamount(((model.getPrice())*(model.getDiscountrate()))/100);
		pro.setOfferprice(model.getPrice()-pro.getDiscountamount());
		pro.setTaxrate(18.00);
		pro.setFinalprice(pro.getOfferprice()+((pro.getTaxrate()*pro.getOfferprice())/100));
		pro.setStockvalue(pro.getPrice()*pro.getQuantity());
		productRepository.save(pro);
    	}
    	
    }
}