package com.example.Mobile_MiniPro.Data.json;

import java.util.ArrayList;
import java.util.List;
import com.example.Mobile_MiniPro.Data.model.Types;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class TypesListJson {

	private long id;
	private String name;
	
	public static TypesListJson packJson(Types type) {
		TypesListJson tlj = new TypesListJson();
		tlj.setId(type.getId());
		tlj.setName(type.getName());
		
		return tlj;
	}
	
	public static List<TypesListJson> pacJsons(List<Types> types){
		
		List<TypesListJson> typeListJsons = new ArrayList<TypesListJson>();
		for (Types type : types) {
			typeListJsons.add(packJson(type));
		}
		return typeListJsons;
	}
	
}
