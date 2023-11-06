package com.example.Mobile_MiniPro.Data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.json.CreatorsListJson;
import com.example.Mobile_MiniPro.Data.model.Creators;
import com.example.Mobile_MiniPro.Data.payload.CreatorsPayload;
import com.example.Mobile_MiniPro.Data.payload.UsersPayload;
import com.example.Mobile_MiniPro.Data.service.CreatorsService;

@Service
public class CreatorsBusiness {

	@Autowired
	CreatorsService creatorService;
	
	public List<CreatorsListJson> getListCreator(){
		return CreatorsListJson.pacJsons(creatorService.getAllCreator());
	}

	public CreatorsListJson getCreatorId(long id) {
		return CreatorsListJson.packJson(creatorService.findById(id));
	}
	
	public void saveCreator(CreatorsPayload usr) {
		Creators user = new Creators(usr.getName());
		creatorService.save(user);
	}
	
	public void updateCreator(long id, CreatorsPayload payload) {
		Creators data = creatorService.findById(id);
		data.setName(payload.getName());
		creatorService.save(data);
	}
	
	public void deleteCreator(long id) {
		creatorService.deleteById(id);
	}
	
	
	
	
}
