package com.winkelmand.winkelmandAPI.service;

import org.springframework.stereotype.Service;

import com.winkelmand.winkelmandAPI.dto.BasketDto;
import com.winkelmand.winkelmandAPI.dto.UserDto;
import com.winkelmand.winkelmandAPI.entity.BasketEntity;

public interface BasketService {
	

	
	BasketDto createBasket(BasketDto basket);
	
//	BasketDto save(BasketDto basket);

//	Long save(BasketEntity basketEntity);
	

}
