package com.example.sessiontest;

import java.util.HashMap;
import java.util.Set;

public class FavoriteInfoDao {
	private HashMap<String, String> favoriteList = null;
	
	public FavoriteInfoDao() {
		favoriteList = new HashMap<String, String>();
	}
	
	public void setFavoriteItem(String key, String value) {
		favoriteList.put(key, value);
	}
	
	public String getFavoriteItem(String key) {
		return favoriteList.get(key);
	}
	
	public Set<String> getFavoriteItemNames() {
		return favoriteList.keySet();
	}
}
