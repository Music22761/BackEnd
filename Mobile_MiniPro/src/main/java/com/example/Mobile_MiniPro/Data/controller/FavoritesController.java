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
import com.example.Mobile_MiniPro.Data.business.FavoritesBusiness;
import com.example.Mobile_MiniPro.Data.json.DatasListJson;
import com.example.Mobile_MiniPro.Data.json.FavoritesListJson;
import com.example.Mobile_MiniPro.Data.model.Datas;
import com.example.Mobile_MiniPro.Data.model.Favorites;
import com.example.Mobile_MiniPro.Data.payload.DatasPayload;
import com.example.Mobile_MiniPro.Data.payload.FavoritesPayload;
import com.example.Mobile_MiniPro.Data.service.DatasService;
import com.example.Mobile_MiniPro.Data.service.FavoritesService;
import com.example.Mobile_MiniPro.exception.BaseException;

@RestController
@RequestMapping("/api")

public class FavoritesController {
	
	//Service
	@Autowired
	FavoritesService favService;
	
	
	
	//Business
	@Autowired
	FavoritesBusiness favBusiness;
	
	
	
	
	public FavoritesController() {
    }
	
	public FavoritesController(FavoritesService favService) {
		this.favService = favService;
	}
	
	
	
	
	
	//Insert Data
	@PostMapping(value = "/favorites")
	public ResponseEntity<Void> saveFav(@RequestBody FavoritesPayload payload) throws BaseException{
		favBusiness.saveFavorite(payload);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	
	
	
	
	
	//get All method
	@GetMapping(value = "/favorites")
	public ResponseEntity<List<FavoritesListJson>> getAllFav() throws BaseException{
		return ResponseEntity.ok(favBusiness.getListFavorite());
	}
	
	
	//get ID method

	@GetMapping(value = "/favorites/user/{id}")
	public ResponseEntity<FavoritesListJson> getUserById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(favBusiness.getUserId(id));
	}
	
	@GetMapping(value = "/favorites/data/{id}")
	public ResponseEntity<FavoritesListJson> getDataById(@PathVariable("id") long id) throws BaseException{
		return ResponseEntity.ok(favBusiness.getUserId(id));
	}
	
	
	
	//Update Data by Id
	
	@PutMapping("/favorites/{id}")
	public ResponseEntity<FavoritesListJson> updateFav(@PathVariable("id") long id,@RequestBody FavoritesPayload payload) throws BaseException{
		Optional<Favorites> data = favService.findOptionalById(id);
		if (data.isPresent()) {
			favBusiness.updateFavorite(data.get().getId(), payload);
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	//Delete table by ID
	@DeleteMapping("/favorites/{id}")
	public ResponseEntity<HttpStatus> deleteFav(@PathVariable("id") long id){
		try {
			favBusiness.deleteFavorite(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
}
