package com.winkelmand.winkelmandAPI.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.winkelmand.winkelmandAPI.entity.BasketEntity;
import com.winkelmand.winkelmandAPI.entity.UserEntity;

@Repository
public interface BasketRepository extends PagingAndSortingRepository<BasketEntity, Long> {
	
	BasketEntity findByBasketId(Long basketId);

	

}
