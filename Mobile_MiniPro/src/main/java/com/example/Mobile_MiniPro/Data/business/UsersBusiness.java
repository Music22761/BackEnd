package com.example.Mobile_MiniPro.Data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.json.UsersListJson;
import com.example.Mobile_MiniPro.Data.model.Users;
import com.example.Mobile_MiniPro.Data.payload.UsersPayload;
import com.example.Mobile_MiniPro.Data.service.UsersService;

@Service
public class UsersBusiness {

	@Autowired
	UsersService usersService;
	
	public List<UsersListJson> getListUser(){
		return UsersListJson.pacJsons(usersService.getAllUsers());
	}

	public UsersListJson getUserId(long id) {
		return UsersListJson.packJson(usersService.findById(id));
	}
	
	public UsersListJson getUserByEmail(String email) {
		return UsersListJson.packJson(usersService.findByEmail(email));
	}
	
	public void saveUser(UsersPayload usr) {
		Users user = new Users(usr.getName(),usr.getEmail(),usr.getPassword(),usr.getImg());
		usersService.save(user);
	}
	
	public void updateUser(long id, UsersPayload payload) {
		Users data = usersService.findById(id);
		data.setName(payload.getName());
		data.setEmail(payload.getEmail());
		data.setPassword(payload.getPassword());
		data.setImage(payload.getImg());
		usersService.save(data);
	}
	
	public void deleteUser(long id) {
		usersService.deleteById(id);
	}
	
	
	
	
}
