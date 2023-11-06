package com.example.Mobile_MiniPro.Data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.model.Favorites;
import com.example.Mobile_MiniPro.Data.model.Types;
import com.example.Mobile_MiniPro.Data.repository.FavoritesRepository;
import com.example.Mobile_MiniPro.Data.repository.TypesRepository;
import com.example.Mobile_MiniPro.Data.service.impl.IFavorites;
import com.example.Mobile_MiniPro.Data.service.impl.ITypes;

@Service
public class FavoritesService implements IFavorites {

	FavoritesRepository favoriteRepository;

	
	
	public FavoritesService(FavoritesRepository favoriteRepository) {
		this.favoriteRepository = favoriteRepository;
		// TODO Auto-generated constructor stub
	}

	
	
	public Optional<Favorites> findOptionalById(long id){
		return favoriteRepository.findOptionalById(id);
	}



	@Override
	public List<Favorites> getAllFavorite() {
		// TODO Auto-generated method stub
		return favoriteRepository.findAll();
	}



	@Override
	public Favorites findById(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findById(id);
	}



	@Override
	public Favorites findByUsersId(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findByUsersId(id);
	}



	@Override
	public Favorites findByDatasId(long id) {
		// TODO Auto-generated method stub
		return favoriteRepository.findByDatasId(id);
	}



	@Override
	public Favorites save(Favorites data) {
		// TODO Auto-generated method stub
		return favoriteRepository.save(data);
	}



	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		favoriteRepository.deleteById(id);
	}








	


	
}
