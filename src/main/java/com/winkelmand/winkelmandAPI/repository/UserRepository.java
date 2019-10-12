package com.winkelmand.winkelmandAPI.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.winkelmand.winkelmandAPI.entity.UserEntity;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, String> {
/*	UserEntity findByEmail(String email); */
	
//	UserEntity findByUserId(String userId);
	
	UserEntity findByUserId(String userId);

}
