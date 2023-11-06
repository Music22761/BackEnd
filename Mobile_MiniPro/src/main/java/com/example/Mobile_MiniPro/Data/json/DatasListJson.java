package com.example.Mobile_MiniPro.Data.json;

import java.util.ArrayList;
import java.util.List;

import com.example.Mobile_MiniPro.Data.model.Creators;
import com.example.Mobile_MiniPro.Data.model.Datas;
import com.example.Mobile_MiniPro.Data.model.Types;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class DatasListJson {

	private long id;
	private String name;
	private String detail;
	private Creators creatorsId;
	private Types typesId;
	
	public static DatasListJson packJson(Datas data) {
		DatasListJson dlj = new DatasListJson();
		dlj.setId(data.getId());
		dlj.setName(data.getName());
		dlj.setDetail(data.getDetail());
		dlj.setCreatorsId(data.getCreatorsId());
		dlj.setTypesId(data.getTypesId());
		
		return dlj;
	}
	
	public static List<DatasListJson> pacJsons(List<Datas> datas){
		
		List<DatasListJson> dataListJsons = new ArrayList<DatasListJson>();
		for (Datas data : datas) {
			dataListJsons.add(packJson(data));
		}
		return dataListJsons;
	}
	
}
