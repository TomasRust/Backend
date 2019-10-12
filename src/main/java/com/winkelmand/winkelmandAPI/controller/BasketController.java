package com.winkelmand.winkelmandAPI.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.winkelmand.winkelmandAPI.dto.BasketDto;
import com.winkelmand.winkelmandAPI.dto.UserDto;
import com.winkelmand.winkelmandAPI.entity.BasketEntity;
import com.winkelmand.winkelmandAPI.model.request.BasketDetailsRequestModel;
import com.winkelmand.winkelmandAPI.model.request.UserDetailsRequestModel;
import com.winkelmand.winkelmandAPI.model.response.BasketRest;
import com.winkelmand.winkelmandAPI.model.response.UserRest;
import com.winkelmand.winkelmandAPI.service.BasketService;


@RestController
public class BasketController {
	
	@Autowired
	BasketService basketService;
	
//	@RequestMapping(value = "/users/{idUser}/baskets", method = RequestMethod.POST)
//	public @ResponseBody ResponseEntity<Void> create(@RequestBody BasketEntity basketEntity, HttpServletRequest request) throws URISyntaxException {
//		Long id = basketService.save(basketEntity);
//		HttpHeaders header = new HttpHeaders();
//		header.setLocation(new URI(request.getRequestURL() + "/" + id.toString()));
//		return new ResponseEntity<Void>(header, HttpStatus.CREATED);
//	}
	
	@PostMapping
	public BasketRest createBasket(@RequestBody BasketDetailsRequestModel basketDetails) {
		
		//ReturnValue voor UserRest datatype
//		UserRest returnValue = new UserRest();
		
//		UserDto userDto = new UserDto();
		
		//BeanUtils kopieert source object naar een target object
//		BeanUtils.copyProperties(userDetails, userDto);
		
		ModelMapper modelMapper = new ModelMapper();
		BasketDto basketDto = modelMapper.map(basketDetails, BasketDto.class);
		
		//UserDto zal bijvoorbeeld userId terugsturen als
		//onderdeel van de returnValue
		BasketDto createdBasket = basketService.createBasket(basketDto);
//		BeanUtils.copyProperties(createdUser, returnValue);
		BasketRest returnValue = modelMapper.map(createdBasket, BasketRest.class);
		
		return returnValue;
	}

}
