package com.rwhitear.nimbleRest.httpErrorHandling;



//import com.cloupia.service.cIM.inframgr.customactions.CustomActionLogger;
import com.google.gson.Gson;
import com.rwhitear.nimbleRest.httpErrorHandling.json.ErrorResponseObject;


public class ProcessErrorResponse {
	
	public ErrorResponseObject parse(String errorResponseJson ) {
	
		Gson gson = new Gson();
	
		ErrorResponseObject ero = gson.fromJson( errorResponseJson, ErrorResponseObject.class );
		
		return ero;
		
	}
	
}
