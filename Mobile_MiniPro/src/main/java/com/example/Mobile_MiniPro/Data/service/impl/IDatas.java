package com.example.Mobile_MiniPro.Data.service.impl;

import java.util.List;

import com.example.Mobile_MiniPro.Data.model.Datas;

public interface IDatas {

	List<Datas> getAllDatas();
	Datas findById(long id);
	Datas findByCreatorId(long id);
	Datas findByTypeId(long id);
	Datas save(Datas std);
	void deleteById(long id);
	
}
