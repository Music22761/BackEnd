package com.example.Mobile_MiniPro.Data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.model.Types;
import com.example.Mobile_MiniPro.Data.repository.TypesRepository;
import com.example.Mobile_MiniPro.Data.service.impl.ITypes;

@Service
public class TypesService implements ITypes {

	TypesRepository typeRepository;

	
	
	public TypesService(TypesRepository typeRepository) {
		this.typeRepository = typeRepository;
		// TODO Auto-generated constructor stub
	}

	
	
	public Optional<Types> findOptionalById(long id){
		return typeRepository.findOptionalById(id);
	}



	@Override
	public List<Types> getAllTypes() {
		// TODO Auto-generated method stub
		return typeRepository.findAll();
	}



	@Override
	public Types findById(long id) {
		// TODO Auto-generated method stub
		return typeRepository.findById(id);
	}



	@Override
	public Types save(Types data) {
		// TODO Auto-generated method stub
		return typeRepository.save(data);
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		typeRepository.deleteById(id);
	}






	


	
}
