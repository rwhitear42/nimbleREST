package com.rwhitear.nimbleRest;

import java.util.HashMap;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		HashMap<String,String> testMap = new HashMap<>();
		
		testMap.put("default"		,"Default");
		testMap.put("windows2012"	,"Windows2012");
		testMap.put("Another"		,"Test");
		
		HashMaps hm = new HashMaps();
		
		hm.setPmap(testMap);
		
		hm.printMap();
		
	}

}
