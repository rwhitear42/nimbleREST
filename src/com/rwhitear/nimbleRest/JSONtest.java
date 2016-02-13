package com.rwhitear.nimbleRest;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class JSONtest {

	public String strnum = "10";
	
	public int foo = Integer.parseInt(strnum);
	
	
	
	
	public void test() {
		
		HashMap<String, String> myMap = new HashMap<>();
		
		myMap.put("username","admin");
		myMap.put("password","C1sco123");
		
		Map<String,HashMap<String,String>> wrapper = new HashMap<>(); 
		
		wrapper.put("data", myMap);
		
		Gson gson = new Gson();
		
		System.out.println(gson.toJson(wrapper));
		
		System.out.println("foo: " + (foo * 1024));
	}
	
	public static void main(String[] args){
		
		new JSONtest().test();
		
	}
}



