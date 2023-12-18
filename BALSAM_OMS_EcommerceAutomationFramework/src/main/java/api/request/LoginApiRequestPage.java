package api.request;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import constants.Constants;

public class LoginApiRequestPage {

	// Method to perform the login and return the user token
	public static String getToken() {
		String requestBody = buildLoginRequestBody();
		String baseUrl = buildApiUrl();
		Response response = sendLoginRequest(baseUrl, requestBody);
		String userToken = extractUserToken(response);
		System.out.println(userToken);
		return userToken;
	}

	// Method to build the JSON request body for login
	public static String buildLoginRequestBody() {
		return "{\r\n" + "    \"LoginID\" : \"admin\",\r\n" + "    \"Password\" : \"password\"\r\n" + "}";
	}

	// Method to send the login request and return the response
	public static Response sendLoginRequest(String baseUrl, String requestBody) {
		return

		given().baseUri(baseUrl).contentType("application/json").accept(ContentType.JSON).body(requestBody).when()
				.post("/invoke/login");
	}
	
	
	
	

	// Method to extract the user token from the response
	public static String extractUserToken(Response response) {
		return response.jsonPath().getString("UserToken");
	}

	public static String buildApiUrl() {
		return Constants.getAPIBASEURL();
	}

	
	
	
//	public static void main(String[] args) throws InterruptedException {
//		String requestBody = buildLoginRequestBody();
//		String baseUrl = buildApiUrl();
//		Response response = sendLoginRequest(baseUrl, requestBody);
//		String userToken = extractUserToken(response);
//		System.out.println("userToken : " + userToken);
//    }

}
