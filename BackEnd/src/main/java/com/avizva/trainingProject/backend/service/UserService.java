package com.avizva.trainingProject.backend.service;

import javax.servlet.http.HttpServletRequest;

import com.avizva.trainingProject.backend.model.User;

public interface UserService {
	public boolean registerUser(User user);

	public boolean authLogin(String username , String password , HttpServletRequest request);
	public boolean forgotPass(String email);
	public boolean resetPass(String email, String onetimepass, String password);
	public boolean deactivate(HttpServletRequest request);

	public boolean updateUser(User user);
	
	public User getUserByUsername(String username);


}
