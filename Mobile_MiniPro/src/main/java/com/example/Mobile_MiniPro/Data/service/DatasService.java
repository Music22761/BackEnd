package com.example.Mobile_MiniPro.Data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.model.Datas;
import com.example.Mobile_MiniPro.Data.repository.DatasRepository;
import com.example.Mobile_MiniPro.Data.service.impl.IDatas;

@Service
public class DatasService implements IDatas {

	DatasRepository datasRepository;

	
	
	public DatasService(DatasRepository datasRepository) {
		this.datasRepository = datasRepository;
		// TODO Auto-generated constructor stub
	}

	
	
	public Optional<Datas> findOptionalById(long id){
		return datasRepository.findOptionalById(id);
	}



	@Override
	public List<Datas> getAllDatas() {
		// TODO Auto-generated method stub
		return datasRepository.findAll();
	}



	@Override
	public Datas findById(long id) {
		// TODO Auto-generated method stub
		return datasRepository.findById(id);
	}



	@Override
	public Datas findByCreatorId(long id) {
		// TODO Auto-generated method stub
		return datasRepository.findById(id);
	}



	@Override
	public Datas findByTypeId(long id) {
		// TODO Auto-generated method stub
		return datasRepository.findById(id);
	}



	@Override
	public Datas save(Datas data) {
		// TODO Auto-generated method stub
		return datasRepository.save(data);
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		datasRepository.deleteById(id);
	}
	
}
