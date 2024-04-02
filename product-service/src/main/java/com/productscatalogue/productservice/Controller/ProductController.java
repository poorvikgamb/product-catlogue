package com.productscatalogue.productservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.productscatalogue.productservice.DTO.ProductRequest;
import com.productscatalogue.productservice.DTO.ProductResponse;
import com.productscatalogue.productservice.Service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")

public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public void ProductService(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody ProductRequest productRequest) {
		productService.createProduct(productRequest);
		
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAllProducts(){
		return productService.getAllProduct();		
	}
	

}
