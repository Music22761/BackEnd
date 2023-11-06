package com.example.Mobile_MiniPro.Data.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mobile_MiniPro.Data.json.FavoritesListJson;
import com.example.Mobile_MiniPro.Data.json.TypesListJson;
import com.example.Mobile_MiniPro.Data.model.Favorites;
import com.example.Mobile_MiniPro.Data.model.Types;
import com.example.Mobile_MiniPro.Data.payload.FavoritesPayload;
import com.example.Mobile_MiniPro.Data.payload.TypesPayload;
import com.example.Mobile_MiniPro.Data.service.FavoritesService;
import com.example.Mobile_MiniPro.Data.service.TypesService;
@Service
public class FavoritesBusiness {

	@Autowired
	FavoritesService favService;
	
	public List<FavoritesListJson> getListFavorite(){
		return FavoritesListJson.pacJsons(favService.getAllFavorite());
	}

	public FavoritesListJson getTypeId(long id) {
		return FavoritesListJson.packJson(favService.findById(id));
	}
	
	public FavoritesListJson getUserId(long id) {
		return FavoritesListJson.packJson(favService.findByUsersId(id));
	}
	
	public FavoritesListJson getDataId(long id) {
		return FavoritesListJson.packJson(favService.findByDatasId(id));
	}
	
	public void saveFavorite(FavoritesPayload payload) {
		Favorites fav = new Favorites(payload.getData(),payload.getUser());
		favService.save(fav);
	}
	
	public void updateFavorite(long id, FavoritesPayload payload) {
		Favorites data = favService.findById(id);
		data.setUsers(payload.getUser());
		data.setDatas(payload.getData());
		favService.save(data);
	}
	
	public void deleteFavorite(long id) {
		favService.deleteById(id);
	}
	
	
	
	
}
