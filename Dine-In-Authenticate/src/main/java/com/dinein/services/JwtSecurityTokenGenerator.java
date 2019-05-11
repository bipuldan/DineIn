package com.dinein.services;

import java.util.Map;

import com.dinein.model.User;

public interface JwtSecurityTokenGenerator {
	
	Map<String, String> generateToken(User user);

}
