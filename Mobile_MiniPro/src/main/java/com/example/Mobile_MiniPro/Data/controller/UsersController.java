package com.example.Mobile_MiniPro.Data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mobile_MiniPro.Data.business.UsersBusiness;
import com.example.Mobile_MiniPro.Data.json.UsersListJson;
import com.example.Mobile_MiniPro.Data.model.Users;
import com.example.Mobile_MiniPro.Data.payload.UsersPayload;
import com.example.Mobile_MiniPro.Data.service.UsersService;
import com.example.Mobile_MiniPro.exception.BaseException;

@RestController
@RequestMapping("/api")

@Service
public class UsersController {
	
	//Service
	@Autowired
	UsersService userService;
	
	
	
	//Business
	@Autowired
	UsersBusiness userBusiness;
	
	
	
	
	public UsersController() {
    }
	
	public UsersController(UsersService userService) {
		this.userService = userService;
	}
	
	
	
	
	
	//Insert Data
	@PostMapping(value = "/users")
	public ResponseEntity<Void> saveUser(@RequestBody UsersPayload payload) throws BaseException{
		userBusiness.saveUser(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	//get All method
	@GetMapping(value = "/users")
	public ResponseEntity<List<UsersListJson>> getAllUser() throws BaseException{
		return ResponseEntity.ok(userBusiness.getListUser());
	}
	
	
	//get ID method

	@GetMapping(value = "/users/{id}")
	public ResponseEntity<UsersListJson> getUserById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(userBusiness.getUserId(id));
	}
	
	@GetMapping(value = "/users/email/{email}")
	public ResponseEntity<UsersListJson> getUserByEmail(@PathVariable("email") String email) throws BaseException{
		return ResponseEntity.ok(userBusiness.getUserByEmail(email));
	}
	
	
	//Update Data by Id
	
	@PutMapping("/users/update/{id}")
	public ResponseEntity<UsersListJson> updateUser(@PathVariable("id") long id,@RequestBody UsersPayload payload) throws BaseException{
		Optional<Users> data = userService.findOptionalById(id);
		if (data.isPresent()) {
			userBusiness.updateUser(data.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	//Delete table by ID
	@DeleteMapping("/users/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id){
		try {
			userBusiness.deleteUser(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
