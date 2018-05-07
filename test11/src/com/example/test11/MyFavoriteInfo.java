package com.example.test11;

import java.util.HashMap;
import java.util.Set;

public class MyFavoriteInfo {
	private HashMap<String, String> favoriteList = null;
	
	public MyFavoriteInfo() {
		favoriteList = new HashMap<String, String>();
	}
	
	public void setFavoriteItem(String name, String value) {
		favoriteList.put(name, value);
	}
	
	public String getFavoriteItem(String name) {
		return favoriteList.get(name);
	}
	
	public Set<String> getFavoriteItemNames() {
		return favoriteList.keySet();
	}
}
