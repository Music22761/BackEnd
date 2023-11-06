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

import com.example.Mobile_MiniPro.Data.business.TypesBusiness;
import com.example.Mobile_MiniPro.Data.json.TypesListJson;
import com.example.Mobile_MiniPro.Data.model.Types;
import com.example.Mobile_MiniPro.Data.payload.TypesPayload;
import com.example.Mobile_MiniPro.Data.service.TypesService;
import com.example.Mobile_MiniPro.exception.BaseException;

@RestController
@RequestMapping("/api")

@Service
public class TypesController {
	
	//Service
	@Autowired
	TypesService typeService;
	
	
	
	//Business
	@Autowired
	TypesBusiness typeBusiness;
	
	
	
	
	public TypesController() {
    }
	
	public TypesController(TypesService typeService) {
		this.typeService = typeService;
	}
	
	
	
	
	
	//Insert Data
	@PostMapping(value = "/types")
	public ResponseEntity<Void> saveType(@RequestBody TypesPayload payload) throws BaseException{
		typeBusiness.saveType(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	//get All method
	@GetMapping(value = "/types")
	public ResponseEntity<List<TypesListJson>> getAllType() throws BaseException{
		return ResponseEntity.ok(typeBusiness.getListType());
	}
	
	
	//get ID method

	@GetMapping(value = "/types/{id}")
	public ResponseEntity<TypesListJson> getTypeById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(typeBusiness.getTypeId(id));
	}
	
	
	//Update Data by Id
	
	@PutMapping("/types/update/{id}")
	public ResponseEntity<TypesListJson> updateType(@PathVariable("id") long id,@RequestBody TypesPayload payload) throws BaseException{
		Optional<Types> data = typeService.findOptionalById(id);
		if (data.isPresent()) {
			typeBusiness.updateType(data.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	//Delete table by ID
	@DeleteMapping("/types/{id}")
	public ResponseEntity<HttpStatus> deleteType(@PathVariable("id") long id){
		try {
			typeBusiness.deleteType(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
