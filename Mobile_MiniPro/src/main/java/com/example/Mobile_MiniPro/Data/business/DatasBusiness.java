package com.example.Mobile_MiniPro.Data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.json.DatasListJson;
import com.example.Mobile_MiniPro.Data.model.Datas;
import com.example.Mobile_MiniPro.Data.payload.DatasPayload;
import com.example.Mobile_MiniPro.Data.service.DatasService;

@Service
public class DatasBusiness {

	@Autowired
	DatasService datasService;
	
	public List<DatasListJson> getListData(){
		return DatasListJson.pacJsons(datasService.getAllDatas());
	}

	public DatasListJson getDataId(long id) {
		return DatasListJson.packJson(datasService.findById(id));
	}
	
//	public DatasListJson getStudentByEmail(String email) {
//		return DatasListJson.packJson(datasService.findByEmail(email));
//	}
	
	public void saveData(DatasPayload d) {
		Datas data = new Datas(d.getName(),d.getDetail(),d.getCid(),d.getTid());
		datasService.save(data);
	}
	
	public void updateData(long id, DatasPayload payload) {
		Datas data = datasService.findById(id);
		data.setName(payload.getName());
		data.setDetail(payload.getDetail());
		data.setCreatorsId(payload.getCid());
		data.setTypesId(payload.getTid());
		datasService.save(data);
	}
	
	public void deleteData(long id) {
		datasService.deleteById(id);
	}
	
	
	
	
}
