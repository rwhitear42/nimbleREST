package com.rwhitear.nimbleRest;

import com.rwhitear.nimbleRest.httpErrorHandling.ProcessErrorResponse;

public class ErrorHandlingTest {

	public static void main(String[] args) {
		
		String json = "{\"messages\":[{\"code\": \"SM_http_conflict\",\"text\": \"The request could not be completed due to a conflict.\"},{\"code\": \"SM_incompatible_initiator_access_protocol\",\"text\": \"Incompatible access protocol between initiator and initiator group.\"}]}";

		new ProcessErrorResponse().parse(json);
		
	}

}
