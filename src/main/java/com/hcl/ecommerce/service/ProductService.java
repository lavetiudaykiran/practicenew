package com.hcl.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.exception.CustomException;
import com.hcl.ecommerce.model.Product;
import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.repositry.ProductRepositry;
import com.hcl.ecommerce.repositry.UserRepositry;

@Service
public class ProductService {

	@Autowired
	ProductRepositry productRepositry;

	@Autowired
	UserRepositry userRepositry;

	public String addProduct(ProductDto productDto) throws CustomException {

		String productName = productDto.getProductName();
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		Product productIn = productRepositry.findByProductName(productName);
		if (ObjectUtils.isEmpty(productIn)) {
			productRepositry.save(product);
			return "product are successfully saved";
		} else {
			throw new CustomException("product Already Existed");
		}
	}

	public List<ProductDto> productList(Long userId) {

		User user = userRepositry.findByUserId(userId);
		String userType = user.getUserType();
		if (userType.equals("priority")) {
			List<Product> products = productRepositry.findAll();
			return products.stream().map(product -> {
				ProductDto productDto = new ProductDto();
				BeanUtils.copyProperties(product, productDto);
				return productDto;
			}).collect(Collectors.toList());
		} else {
			Long count = productRepositry.count();
			PageRequest pagable = (PageRequest.of(0, (int) (count / 2), Sort.by(Sort.Direction.DESC, "productName")));
			Page<Product> products = productRepositry.findAll(pagable);
			return products.stream().map(product -> {
				ProductDto productDto = new ProductDto();
				BeanUtils.copyProperties(product, productDto);
				return productDto;
			}).collect(Collectors.toList());
		}
	}
}
