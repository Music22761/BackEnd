package com.example.Mobile_MiniPro.Data.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mobile_MiniPro.Data.business.CreatorsBusiness;
import com.example.Mobile_MiniPro.Data.json.CreatorsListJson;
import com.example.Mobile_MiniPro.Data.model.Creators;
import com.example.Mobile_MiniPro.Data.payload.CreatorsPayload;
import com.example.Mobile_MiniPro.Data.service.CreatorsService;
import com.example.Mobile_MiniPro.exception.BaseException;

@RestController
@RequestMapping("/api")

@Service
public class CreatorsController {
	
	//Service
	@Autowired
	CreatorsService creatorService;
	
	
	
	//Business
	@Autowired
	CreatorsBusiness creatorBusiness;
	
	
	
	
	public CreatorsController() {
    }
	
	public CreatorsController(CreatorsService creatorService) {
		this.creatorService = creatorService;
	}
	
	
	
	
	
	//Insert Data
	@PostMapping(value = "/creators")
	public ResponseEntity<Void> saveCreator(@RequestBody CreatorsPayload payload) throws BaseException{
		creatorBusiness.saveCreator(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	//get All method
	@GetMapping(value = "/creators")
	public ResponseEntity<List<CreatorsListJson>> getAllCreator() throws BaseException{
		return ResponseEntity.ok(creatorBusiness.getListCreator());
	}
	
	
	//get ID method

	@GetMapping(value = "/creators/{id}")
	public ResponseEntity<CreatorsListJson> getCreatorById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(creatorBusiness.getCreatorId(id));
	}
	
	//Update Data by Id
	
	@PutMapping("/creators/update/{id}")
	public ResponseEntity<CreatorsListJson> updateCreator(@PathVariable("id") long id,@RequestBody CreatorsPayload payload) throws BaseException{
		Optional<Creators> data = creatorService.findOptionalById(id);
		if (data.isPresent()) {
			creatorBusiness.updateCreator(data.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	//Delete table by ID
	@DeleteMapping("/creators/{id}")
	public ResponseEntity<HttpStatus> deleteCreator(@PathVariable("id") long id){
		try {
			creatorBusiness.deleteCreator(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
