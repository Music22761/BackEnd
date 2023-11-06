package com.example.Mobile_MiniPro.Data.json;

import java.util.ArrayList;
import java.util.List;

import com.example.Mobile_MiniPro.Data.model.Datas;
import com.example.Mobile_MiniPro.Data.model.Favorites;
import com.example.Mobile_MiniPro.Data.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class FavoritesListJson {

	private long id;
	private Datas datasId;
	private Users usersId;
	
	public static FavoritesListJson packJson(Favorites favorite) {
		FavoritesListJson flj = new FavoritesListJson();
		flj.setId(favorite.getId());
		flj.setDatasId(favorite.getDatas());
		flj.setUsersId(favorite.getUsers());
		
		return flj;
	}
	
	public static List<FavoritesListJson> pacJsons(List<Favorites> favorites){
		
		List<FavoritesListJson> favoriteListJsons = new ArrayList<FavoritesListJson>();
		for (Favorites favorite : favorites) {
			favoriteListJsons.add(packJson(favorite));
		}
		return favoriteListJsons;
	}
	
}
