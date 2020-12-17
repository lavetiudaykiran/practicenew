package com.hcl.ecommerce.repositry;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.hcl.ecommerce.model.User;

@Repository
public interface UserRepositry extends PagingAndSortingRepository<User, Long> {

	User findByUserNameAndMail(String userName, String emil);

	User findByUserNameAndPassword(String userName, String password);

	User findByUserId(Long userId);
}
