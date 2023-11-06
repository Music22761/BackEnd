package com.example.Mobile_MiniPro.Data.json;

import java.util.ArrayList;
import java.util.List;
import com.example.Mobile_MiniPro.Data.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class UsersListJson {

	private long id;
	private String name;
	private String email;
	private String password;
	private String image;
	
	public static UsersListJson packJson(Users user) {
		UsersListJson ulj = new UsersListJson();
		ulj.setId(user.getId());
		ulj.setName(user.getName());
		ulj.setEmail(user.getEmail());
		ulj.setPassword(user.getPassword());
		ulj.setImage(user.getImage());
		return ulj;
	}
	
	public static List<UsersListJson> pacJsons(List<Users> users){
		
		List<UsersListJson> userListJsons = new ArrayList<UsersListJson>();
		for (Users user : users) {
			userListJsons.add(packJson(user));
		}
		return userListJsons;
	}
	
}
