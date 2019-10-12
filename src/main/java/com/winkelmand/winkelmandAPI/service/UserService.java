package com.winkelmand.winkelmandAPI.service;

import java.util.List;

import com.winkelmand.winkelmandAPI.dto.UserDto;

public interface UserService  {
	/*UserDto createUser(UserDto user);
	  UserDto getUser(String email); */
	
//	UserDto getUserByUserId(String userId);
	
//	UserDto createUser(UserDto user);
	
	UserDto createUser(UserDto user);
	UserDto getUserByUserId(String userId);
	UserDto updateUser(String userId, UserDto user);
	void deleteUser(String userId);
	List<UserDto> getUsers(int page, int limit);

}
