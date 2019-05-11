package com.dinein.services;

import com.dinein.exception.UserAlreadyExistsException;
import com.dinein.exception.UserNotFoundException;
import com.dinein.model.User;

public interface UserService {

	boolean saveUser(User user) throws UserAlreadyExistsException;

	User findByEmailAndPassword(String email, String password) throws UserNotFoundException;

}
