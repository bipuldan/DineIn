package com.dinein.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinein.exception.UserAlreadyExistsException;
import com.dinein.exception.UserNotFoundException;
import com.dinein.model.User;
import com.dinein.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepo;

	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		Optional<User> existingUser = userRepo.findByEmail(user.getEmail());
		if (existingUser.isPresent()) {
			throw new UserAlreadyExistsException("User with email already exists");
		}
		userRepo.save(user);
		return true;
	}

	@Override
	public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {
		
		User user = userRepo.findByEmailAndPassword(email, password);
		if (null == user) {
			throw new UserNotFoundException("UserId and Password mismatch");
		}
		return user;
	}


}
