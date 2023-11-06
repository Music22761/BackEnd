package com.example.Mobile_MiniPro.Data.payload;

import com.example.Mobile_MiniPro.Data.model.Datas;
import com.example.Mobile_MiniPro.Data.model.Users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FavoritesPayload {

	private Users user;
	private Datas data;
}
