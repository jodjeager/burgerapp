package com.learn.burgerapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.learn.burgerapp.dto.UserDto;
import com.learn.burgerapp.entities.User;
import com.learn.burgerapp.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User  user = modelMapper.map(userDto, User.class);
		
		User savedUser = userRepository.save(user);
		
		UserDto savedDto = modelMapper.map(savedUser, UserDto.class);
		
		
		return savedDto;
	}

}
