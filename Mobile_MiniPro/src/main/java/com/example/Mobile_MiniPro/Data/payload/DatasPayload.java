package com.example.Mobile_MiniPro.Data.payload;

import com.example.Mobile_MiniPro.Data.model.Creators;
import com.example.Mobile_MiniPro.Data.model.Favorites;
import com.example.Mobile_MiniPro.Data.model.Types;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class DatasPayload {

	private String name;
	private String detail;
	private Creators cid;
	private Types tid;
}
