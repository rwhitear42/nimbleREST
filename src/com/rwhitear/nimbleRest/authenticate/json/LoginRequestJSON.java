package com.rwhitear.nimbleRest.authenticate.json;


import com.google.gson.Gson;


public class LoginRequestJSON {

	private String username = "";
	
	private String password = "";
	
	public LoginRequestJSON() {
		
	}
	
	public LoginRequestJSON(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	
	public String convertToJSON() {
		
		UserCredentials userCredentialsMap = new UserCredentials();
		
		userCredentialsMap.setUsername(this.username);
		userCredentialsMap.setPassword(this.password);
		
		JsonWrapper dataWrapper = new JsonWrapper();
		
		dataWrapper.setUserCredentials(userCredentialsMap);	
		
		Gson gson = new Gson();
		
		return gson.toJson(dataWrapper);		
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

class JsonWrapper {
	
	private UserCredentials data;

	public UserCredentials getUserCredentials() {
		return data;
	}

	public void setUserCredentials(UserCredentials data) {
		this.data = data;
	}

}

class UserCredentials {
	
	private String username;
	private String password;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}