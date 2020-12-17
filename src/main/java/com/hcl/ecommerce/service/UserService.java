package com.hcl.ecommerce.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import com.hcl.ecommerce.dto.UserDto;
import com.hcl.ecommerce.exception.CustomException;
import com.hcl.ecommerce.model.User;
import com.hcl.ecommerce.repositry.UserRepositry;

@Service
public class UserService {
	
	@Autowired
	UserRepositry userRepositry;

	public String addUser(UserDto userDto) throws CustomException {
		String userName = userDto.getUserName();
		String email = userDto.getMail();
		User user = new User();
		BeanUtils.copyProperties(userDto, user);
		User userIn = userRepositry.findByUserNameAndMail(userName, email);
		if (ObjectUtils.isEmpty(userIn)) {
			userRepositry.save(user);
			return "Registration successfully Done";
		} else {
			throw new CustomException("user Already Existed");
		}
	}

	public String loginUser(String userName, String password) throws CustomException {
		User user = userRepositry.findByUserNameAndPassword(userName, password);
		if (ObjectUtils.isEmpty(user)) {
			throw new CustomException("your login details are mismatch");
		} else {
			return "you are successfully login";
		}
	}
}
