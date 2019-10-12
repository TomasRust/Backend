package com.winkelmand.winkelmandAPI.service.impl;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winkelmand.winkelmandAPI.dto.BasketDto;
import com.winkelmand.winkelmandAPI.dto.UserDto;
import com.winkelmand.winkelmandAPI.entity.BasketEntity;
import com.winkelmand.winkelmandAPI.entity.UserEntity;
import com.winkelmand.winkelmandAPI.repository.BasketRepository;
import com.winkelmand.winkelmandAPI.service.BasketService;

@Service
//@Transactional
public class BasketServiceImpl implements BasketService {
	
	@Autowired
	BasketRepository basketRepository;

	@Override
	public BasketDto createBasket(BasketDto basket) {
		
		
//		BeanUtils.copyProperties(user, userEntity);
		ModelMapper modelMapper = new ModelMapper();
		BasketEntity basketEntity = modelMapper.map(basket, BasketEntity.class);
//		userEntity.setUserId("testUserId");
		
	
		BasketEntity storedBasketDetails = basketRepository.save(basketEntity);
		
//		BeanUtils.copyProperties(storedUserDetails, returnValue);
		BasketDto returnValue = modelMapper.map(storedBasketDetails, BasketDto.class);

		return returnValue;
	}

	
//	@Autowired
//	BasketEntity basketEntity;
//
//	@Override
//	public BasketDto createBasket(BasketDto basket) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public Long save(BasketEntity basketEntity) {
//		return basketDto.save(basketEntity);
//	}

//	@Override
//	public Long save(BasketEntity basketEntity) {
//		return basketDto.save(basketEntity);
//	}
//
//	@Override
//	public BasketDto save(BasketDto basket) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
