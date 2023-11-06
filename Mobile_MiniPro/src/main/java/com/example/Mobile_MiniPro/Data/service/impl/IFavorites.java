package com.example.Mobile_MiniPro.Data.service.impl;

import java.util.List;

import com.example.Mobile_MiniPro.Data.model.Favorites;

public interface IFavorites {

	List<Favorites> getAllFavorite();
	Favorites findById(long id);
	Favorites findByUsersId(long id);
	Favorites findByDatasId(long id);
	Favorites save(Favorites data);
	void deleteById(long id);
	
}