package com.productscatalogue.productservice.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.productscatalogue.productservice.DTO.ProductRequest;
import com.productscatalogue.productservice.DTO.ProductResponse;
import com.productscatalogue.productservice.Repository.ProductRepository;
import com.productscatalogue.productservice.model.Product;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	
	private final ProductRepository productRepository;
	
	public void createProduct(ProductRequest productRequest) {
		
		Product product = Product.builder()
				.name(productRequest.getName())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.build();
		
		productRepository.save(product);
		log.info("Product {} is saved", product.getId());
		
		
	}

	public List<ProductResponse> getAllProduct() {
		List<Product> products = productRepository.findAll();
		
		return products.stream().map(this::mapProductResponse).toList();
		
	}
	
	private ProductResponse mapProductResponse(Product product) {
		
		return ProductResponse.builder()
				.id(product.getId())
				.name(product.getName())
				.description(product.getDescription())
				.price(product.getPrice())
				.build();
		
	}
	
	
	

}