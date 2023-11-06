package com.example.Mobile_MiniPro.Data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.model.Creators;
import com.example.Mobile_MiniPro.Data.repository.CreatorsRepository;
import com.example.Mobile_MiniPro.Data.service.impl.ICreators;

@Service
public class CreatorsService implements ICreators {

	CreatorsRepository creatorRepository;

	
	
	public CreatorsService(CreatorsRepository creatorRepository) {
		this.creatorRepository = creatorRepository;
		// TODO Auto-generated constructor stub
	}

	
	
	public Optional<Creators> findOptionalById(long id){
		return creatorRepository.findOptionalById(id);
	}



	@Override
	public List<Creators> getAllCreator() {
		// TODO Auto-generated method stub
		return creatorRepository.findAll();
	}



	@Override
	public Creators findById(long id) {
		// TODO Auto-generated method stub
		return creatorRepository.findById(id);
	}


	@Override
	public Creators save(Creators data) {
		// TODO Auto-generated method stub
		return creatorRepository.save(data);
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		creatorRepository.deleteById(id);
	}






	


	
}
