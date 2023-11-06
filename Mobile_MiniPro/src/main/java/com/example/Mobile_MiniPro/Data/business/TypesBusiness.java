package com.example.Mobile_MiniPro.Data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.json.TypesListJson;
import com.example.Mobile_MiniPro.Data.model.Types;
import com.example.Mobile_MiniPro.Data.payload.TypesPayload;
import com.example.Mobile_MiniPro.Data.service.TypesService;
@Service
public class TypesBusiness {

	@Autowired
	TypesService typeService;
	
	public List<TypesListJson> getListType(){
		return TypesListJson.pacJsons(typeService.getAllTypes());
	}

	public TypesListJson getTypeId(long id) {
		return TypesListJson.packJson(typeService.findById(id));
	}
	
	public void saveType(TypesPayload usr) {
		Types type = new Types(usr.getName());
		typeService.save(type);
	}
	
	public void updateType(long id, TypesPayload payload) {
		Types data = typeService.findById(id);
		data.setName(payload.getName());
		typeService.save(data);
	}
	
	public void deleteType(long id) {
		typeService.deleteById(id);
	}
	
	
	
	
}
