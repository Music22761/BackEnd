package com.example.Mobile_MiniPro.Data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mobile_MiniPro.Data.business.DatasBusiness;
import com.example.Mobile_MiniPro.Data.json.DatasListJson;
import com.example.Mobile_MiniPro.Data.model.Datas;
import com.example.Mobile_MiniPro.Data.payload.DatasPayload;
import com.example.Mobile_MiniPro.Data.service.DatasService;
import com.example.Mobile_MiniPro.exception.BaseException;

@RestController
@RequestMapping("/api")

public class DatasController {
	
	//Service
	@Autowired
	DatasService dataService;
	
	
	
	//Business
	@Autowired
	DatasBusiness dataBusiness;
	
	
	
	
	public DatasController() {
    }
	
	public DatasController(DatasService dataService) {
		this.dataService = dataService;
	}
	
	
	
	
	
	//Insert Data
	@PostMapping(value = "/datas")
	public ResponseEntity<Void> saveData(@RequestBody DatasPayload payload) throws BaseException{
		dataBusiness.saveData(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	//get All method
	@GetMapping(value = "/datas")
	public ResponseEntity<List<DatasListJson>> getAllData() throws BaseException{
		return ResponseEntity.ok(dataBusiness.getListData());
	}
	
	
	//get ID method

	@GetMapping(value = "/datas/{id}")
	public ResponseEntity<DatasListJson> getDataById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(dataBusiness.getDataId(id));
	}
	
	
	
	//Update Data by Id
	
	@PutMapping("/datas/update/{id}")
	public ResponseEntity<DatasListJson> updateData(@PathVariable("id") long id,@RequestBody DatasPayload payload) throws BaseException{
		Optional<Datas> data = dataService.findOptionalById(id);
		if (data.isPresent()) {
			dataBusiness.updateData(data.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	//Delete table by ID
	@DeleteMapping("/datas/{id}")
	public ResponseEntity<HttpStatus> deleteData(@PathVariable("id") long id){
		try {
			dataBusiness.deleteData(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
