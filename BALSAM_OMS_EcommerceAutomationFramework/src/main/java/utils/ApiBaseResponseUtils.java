package utils;

import java.io.File;

//import apis.response.Response;

import java.io.File;

import constants.Constants;


import io.restassured.response.Response;

public class ApiBaseResponseUtils {
	Response response;

    public ApiBaseResponseUtils(Response response){
        this.response = response;
    }
    
    /**
   	* Name of the method: statusCode
   	* Description: Returns a status code from the response
   	* To do:NA
   	*/
    public int statusCode(){
        return response.getStatusCode();
    }
    
    /**
   	* Name of the method: prettyPrint
   	* Description:Returns a response in the JSON format from the response
   	* To do:NA
   	*/
    public void prettyPrint(){
        response.prettyPrint();
    }

    /**
   	* Name of the method: bodyString
   	* Description:Returns a response in the string format from the response
   	* To do:NA
   	*/
    public String bodyString(){
       return response.getBody().toString();
    } 
    
    /**
   	* Name of the method: validateSchema
   	* Description: validates schema of the response json with given schema file
   	* To do: NA
   	*/
//    public void validateSchema(String schemaFileName)
//	{
//    	File responseJsonFile = new File(Constants.getGlobalSchemasPath()+schemaFileName).exists()
//				?new File(Constants.getGlobalSchemasPath()+schemaFileName)
//				:new File(Constants.getLocaleSchemasPath()+schemaFileName);
//    	
//		response.then().body(JsonSchemaValidator.matchesJsonSchema(responseJsonFile));
//	}
}
