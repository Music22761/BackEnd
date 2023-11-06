package com.example.Mobile_MiniPro.Data.service.impl;

import java.util.List;

import com.example.Mobile_MiniPro.Data.model.Creators;

public interface ICreators {

	List<Creators> getAllCreator();
	Creators findById(long id);
	Creators save(Creators data);
	void deleteById(long id);
	
}