package com.example.Mobile_MiniPro.Data.json;

import java.util.ArrayList;
import java.util.List;

import com.example.Mobile_MiniPro.Data.model.Creators;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class CreatorsListJson {

	private long id;
	private String name;
	private String email;
	private String password;
	
	public static CreatorsListJson packJson(Creators creator) {
		CreatorsListJson clj = new CreatorsListJson();
		clj.setId(creator.getId());
		clj.setName(creator.getName());
		
		return clj;
	}
	
	public static List<CreatorsListJson> pacJsons(List<Creators> creators){
		
		List<CreatorsListJson> creatorListJsons = new ArrayList<CreatorsListJson>();
		for (Creators creator : creators) {
			creatorListJsons.add(packJson(creator));
		}
		return creatorListJsons;
	}
	
}
