package com.example.test09;

import java.util.Properties;

import com.google.gson.Gson;

public class PinfoDao {
	private Properties pInfoTable = null;
	
	public PinfoDao(Properties dbTable) {
		pInfoTable = dbTable;
	}
		
	public String savePseronalInfo(PersonalInfo pInfo) {
		// convert pInfo object to string
		Gson gson = new Gson();
		String pInfoStr = gson.toJson(pInfo);
		
		// save json string to properties object
		pInfoTable.put(pInfo.getId(), pInfoStr);
		
		return pInfoStr;
	}
}
