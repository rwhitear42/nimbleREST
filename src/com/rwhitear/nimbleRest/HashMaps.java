package com.rwhitear.nimbleRest;

import java.util.HashMap;

public class HashMaps {

	private HashMap<String,String> pmap = new HashMap<>();
	
	public void printMap() {
	
		for( String key: pmap.keySet() ) {
			
			System.out.println("Key: [" + key + "], value: [" + pmap.get(key) + "]." );
			
		}
	}
	

	public HashMap<String, String> getPmap() {
		return pmap;
	}

	public void setPmap(HashMap<String, String> pmap) {
		this.pmap = pmap;
	}
	
	
}
