package com.winkelmand.winkelmandAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.winkelmand.winkelmandAPI.dto.UserDto;
import com.winkelmand.winkelmandAPI.entity.UserEntity;
import com.winkelmand.winkelmandAPI.repository.UserRepository;
import com.winkelmand.winkelmandAPI.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	/* Dto staat voor data transfer object */

	@Override
	public UserDto createUser(UserDto user) {
		
		
//		BeanUtils.copyProperties(user, userEntity);
		ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);
//		userEntity.setUserId("testUserId");
		
	
		UserEntity storedUserDetails = userRepository.save(userEntity);
		
//		BeanUtils.copyProperties(storedUserDetails, returnValue);
		UserDto returnValue = modelMapper.map(storedUserDetails, UserDto.class);

		return returnValue;
	}

	@Override
	public UserDto getUserByUserId(String userId) {
		
		//Define returnValue
		UserDto returnValue = new UserDto();
		
		UserEntity userEntity = userRepository.findByUserId(userId);
		
//		if(userEntity == null) throw new UsernameNotFoundException(userId);
		BeanUtils.copyProperties(userEntity, returnValue);
		
		return returnValue;
	}

	@Override
	public UserDto updateUser(String userId, UserDto user) {
		
		UserDto returnValue = new UserDto();
		UserEntity userEntity = userRepository.findByUserId(userId);
		
		//Nog een exception toevoegen als er geen id is gevonden
		//Onderzoek UserNameNotFoundException van Spring
		
		//Op dit moment mogelijk om firstname en lastname aan te passen
		userEntity.setFirstName(user.getFirstName());
		userEntity.setLastName(user.getLastName());
		
		//methode save komt van Spring
		UserEntity updatedUserDetails = userRepository.save(userEntity);
		
		BeanUtils.copyProperties(updatedUserDetails, returnValue);

		
		return returnValue;
	}

	@Override
	public void deleteUser(String userId) {
		UserEntity userEntity = userRepository.findByUserId(userId);

		//Exception toevoegen
		
		userRepository.delete(userEntity);
		
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {

		List<UserDto> returnValue = new ArrayList<>();
		
		//Door PagingAndSorting toe te voegen van Spring mogelijk om
		//gebruik te maken van PageRequest.of
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);
		List<UserEntity> users = usersPage.getContent();
		
		for(UserEntity userEntity : users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			returnValue.add(userDto);
			
		}
		return returnValue;
	}
	
	
	
	

}
