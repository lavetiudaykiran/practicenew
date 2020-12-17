package com.hcl.ecommerce.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.exception.CustomException;
import com.hcl.ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) throws CustomException {

		String response = productService.addProduct(productDto);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<List<ProductDto>> productList(@RequestParam Long userId) {

		List<ProductDto> products = productService.productList(userId);
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
}
