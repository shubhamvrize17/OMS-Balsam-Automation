package utils;

import java.nio.charset.Charset;
import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.filter.log.UrlDecoder;

import io.restassured.response.Response;

public class ApiBaseRequestUtils {

	/**
	 * Name of the method: getRequest
	 * Description:Sending a request to the endpoint with the get() method and getting the response
	 * Parameters:URL of the endpoint,map of headers and map of params
	 * To do:NA
	 */
	public static Response getRequest(String url, Map headers, Map params) {
		Response response = RestAssured.given().log().all().headers(headers).queryParams(params).get(url);
		return response;
	}

	/**
	 * Name of the method: postRequest
	 * Description:Sending a request to the endpoint with the post() method and getting the response
	 * Parameters:URL of the endpoint,map of obj,map of headers and map of params
	 * To do:NA
	 */
	public static Response postRequest(String url,Object obj, Map headers, Map params) {
		Response response = RestAssured.given().log().all().headers(headers).queryParams(params).body(obj).post(url);
		return response;
	} 
	
	/**
	* Name of the method: postRequest
	* Description:Sending a request to the endpoint with post() and getting the response
	* Parameters:URL of the endpoint,map of obj and map of headers 
	* To do: NA
	*/
	public static Response postRequest(String url,Object obj, Map headers) {
		Response response = RestAssured.given().log().all().body(obj).headers(headers).post(url);
		return response;
	}

	/**
	 * Name of the method: postRequest
	 * Description:Sending a request to the endpoint with the post() method and getting the response
	 * Parameters:URL of the endpoint and map of headers 
	 * To do:NA
	 */
	public static Response postRequest(String url, Map headers) {
		Response response = RestAssured.given().log().all().formParams(headers).post(url);    	

		return response;
	}

	/**
	 * Name of the method:  putRequest
	 * Description:Sending a request to the endpoint with the put() method and getting the response
	 * Parameters:URL of the endpoint,map of obj,map of headers and map of params
	 * To do:NA
	 */
	public static Response putRequest(String url,Object obj, Map headers, Map params) {
		Response response = RestAssured.given().log().all().body(obj).headers(headers).params(params).put(url);
		return response;
	}


	/**
	 * Name of the method: deleteRequest
	 * Description:Sending a request to the endpoint with the delete() method and getting the response
	 * Parameters:URL of the endpoint,map of headers and map of params
	 * To do:NA
	 */
	public static Response deleteRequest(String url, Map headers, Map params) {
		Response response = RestAssured.given().log().all().headers(headers).params(params).delete(url);
		return response;
	}

	/**
	* Name of the method: deleteRequest
	* Description:Sending a request to the endpoint with delete() and getting the response
	* Parameters:URL of the endpoint,map of obj and map of headers 
	* To do: NA
	*/
	public static Response deleteRequest(String url,Object obj, Map headers) {
		Response response = RestAssured.given().log().all().body(obj).headers(headers).delete(url);
		return response;
	}

	/**
	 * Name of the method: fileUploadPostRequest
	 * Description:Sending a request to the endpoint with the fileuploadpost() method and getting the response
	 * Parameters:URL of the endpoint,map of data,map of headers and map of params
	 * To do:NA
	 */
	public static Response fileUploadPostRequest(String url, Map data, Map headers, Map params) {
		Response response = RestAssured.given().log().all().headers(headers).params(params).post(url);
		return response;
	}

    /**
   	* Name of the method:getTheResponseFromRestAsssured
   	* Description:Returns a response in the string format from the response
   	* To do:url to get the response
   	*/
    public Response getTheResponseFromRestAsssured(String url) {
      	 String downloadURL=UrlDecoder.urlDecode(url, Charset.defaultCharset(), false);
      		final Response responseOfResAssured = RestAssured.given().
      				when().
      				get(downloadURL).
      				andReturn();
   			return responseOfResAssured;	
      }
}
	
