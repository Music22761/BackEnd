package com.example.Mobile_MiniPro.Data.service.impl;

import java.util.List;
import com.example.Mobile_MiniPro.Data.model.Users;

public interface IUsers {

	List<Users> getAllUsers();
	Users findById(long id);
	Users findByEmail(String email);
	Users save(Users data);
	void deleteById(long id);
	
}