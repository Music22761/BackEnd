package com.example.Mobile_MiniPro.Data.service.impl;

import java.util.List;

import com.example.Mobile_MiniPro.Data.model.Types;

public interface ITypes {

	List<Types> getAllTypes();
	Types findById(long id);
	Types save(Types data);
	void deleteById(long id);
	
}