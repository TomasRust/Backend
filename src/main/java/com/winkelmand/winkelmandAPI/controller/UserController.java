package com.winkelmand.winkelmandAPI.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.winkelmand.winkelmandAPI.dto.UserDto;
import com.winkelmand.winkelmandAPI.model.request.UserDetailsRequestModel;
import com.winkelmand.winkelmandAPI.model.response.ActivityStatusModel;
import com.winkelmand.winkelmandAPI.model.response.RequestActivityName;
import com.winkelmand.winkelmandAPI.model.response.RequestActivityStatus;
import com.winkelmand.winkelmandAPI.model.response.UserRest;
import com.winkelmand.winkelmandAPI.service.UserService;

@RestController
@RequestMapping("user") //http://localhost:8080/users/
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@GetMapping(path="/{userId}")
	public UserRest getUser(@PathVariable String userId) {
		
		UserRest returnValue = new UserRest();
		
		UserDto userDto = userService.getUserByUserId(userId);
		BeanUtils.copyProperties(userDto, returnValue);
		
		return returnValue;
	}
	
	
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		//ReturnValue voor UserRest datatype
//		UserRest returnValue = new UserRest();
		
//		UserDto userDto = new UserDto();
		
		//BeanUtils kopieert source object naar een target object
//		BeanUtils.copyProperties(userDetails, userDto);
		
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(userDetails, UserDto.class);
		
		//UserDto zal bijvoorbeeld userId terugsturen als
		//onderdeel van de returnValue
		UserDto createdUser = userService.createUser(userDto);
//		BeanUtils.copyProperties(createdUser, returnValue);
		UserRest returnValue = modelMapper.map(createdUser, UserRest.class);
		
		return returnValue;
	}
	
	//UserDetailsRequestModel voor het aanpassen van
	//bijvoorbeeld naam of achternaam
	@PutMapping(path="/{userId}") 
	public UserRest updateUser(@PathVariable String userId,
			@RequestBody UserDetailsRequestModel userDetails) {
		
	//Voor het aanpassen komt veel code overeen als bij POST
	//Belangrijkste verschil is dat createUser nu updateUser is
		
		//ReturnValue voor UserRest datatype
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		
		//BeanUtils kopieert source object naar een target object
		BeanUtils.copyProperties(userDetails, userDto);
		
		//UserDto zal bijvoorbeeld userId terugsturen als
		//onderdeel van de returnValue
		//(id, userDto) met "id" geef je aan van wie je de gegevens
		//wilt gaan veranderen en daarna wat met "userDto"
		UserDto updateUser = userService.updateUser(userId, userDto);
		BeanUtils.copyProperties(updateUser, returnValue);
		
		return returnValue;	
		
	}
	
	@DeleteMapping(path="/{userId}")
	public ActivityStatusModel deleteUser(@PathVariable String userId) {
		
		ActivityStatusModel returnValue = new ActivityStatusModel();
		
		
		returnValue.setActivityName(RequestActivityName.DELETE.name());
		
		userService.deleteUser(userId);
		
		returnValue.setActivityResult(RequestActivityStatus.SUCCES.name());
		
		return returnValue;
	}
	
	//Ophalen van klantenlijst
	//Binnen Postman voer je bijvoorbeeld in:
	// http://localhost:8080:/users?page=1&limit=20
	@GetMapping
	public List<UserRest> getUsers(@RequestParam(value="page", defaultValue="0")int page,
			@RequestParam(value="limit", defaultValue="20")int limit) {
		
		List<UserRest> returnValue = new ArrayList<>();
		
		List<UserDto> users = userService.getUsers(page, limit);
		
		for (UserDto userDto : users) {
			UserRest userModel = new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			returnValue.add(userModel);
		}
		return returnValue;
	}
}
