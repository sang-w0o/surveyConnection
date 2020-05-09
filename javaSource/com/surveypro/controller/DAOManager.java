package com.surveypro.controller;

import java.util.HashMap;

public class DAOManager {
	private static HashMap<String, Object> daos;
	
	private DAOManager() {}
	
	static {
		daos = new HashMap<>();
	}

	public static void addDAO(String key, Object obj) {
		daos.put(key, obj);
	}
	
	public static Object getDAO(String key) {
		return daos.get(key);
	}
}
