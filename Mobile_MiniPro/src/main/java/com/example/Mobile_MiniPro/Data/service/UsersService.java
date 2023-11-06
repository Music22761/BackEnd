package com.example.Mobile_MiniPro.Data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.model.Users;
import com.example.Mobile_MiniPro.Data.repository.UsersRepository;
import com.example.Mobile_MiniPro.Data.service.impl.IUsers;

@Service
public class UsersService implements IUsers {

	UsersRepository usersRepository;

	
	
	public UsersService(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
		// TODO Auto-generated constructor stub
	}

	
	
	public Optional<Users> findOptionalById(long id){
		return usersRepository.findOptionalById(id);
	}



	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return usersRepository.findAll();
	}



	@Override
	public Users findById(long id) {
		// TODO Auto-generated method stub
		return usersRepository.findById(id);
	}



	@Override
	public Users findByEmail(String email) {
		// TODO Auto-generated method stub
		return usersRepository.findByEmail(email);
	}



	@Override
	public Users save(Users data) {
		// TODO Auto-generated method stub
		return usersRepository.save(data);
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		usersRepository.deleteById(id);
	}



	


	
}
