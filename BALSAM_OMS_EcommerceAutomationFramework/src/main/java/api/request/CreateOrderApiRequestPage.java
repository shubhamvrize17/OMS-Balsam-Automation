package api.request;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateOrderApiRequestPage {

	LoginApiRequestPage lgn = new LoginApiRequestPage();

	public static String generateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	// Step 1: Read XML payload from a file
	public static String readOrderPayload() throws IOException {
		return generateStringFromResource(
				"C:\\Shubham\\OMS-Balsam-Automation\\BALSAM_OMS_EcommerceAutomationFramework\\src\\test\\resources\\testData\\payload\\multiItemsCreteOrder.xml");
	}

	// Step 2: Configure RestAssured for HTTPS and content encoding
	public static void configureRestAssured() {
		RestAssured.useRelaxedHTTPSValidation();
		RestAssured.config = RestAssured.config().encoderConfig(io.restassured.config.EncoderConfig.encoderConfig()
				.appendDefaultContentCharsetToContentTypeIfUndefined(false));
	}

	
	
	
	
	// Step 3: Set up API endpoint and base URL
	public static String buildApiUrl() {
		String endpoint = "/invoke/createOrder";
		return Constants.getAPIBASEURL() + endpoint;
	}

	// Step 4: Get authentication token
	public static String getAuthToken() {
		return LoginApiRequestPage.getToken();
	}

	// Step 5: Set headers and login parameters
	public static Map<String, String> buildRequestHeaders(String token) {
		return Map.of("Content-Type", "application/xml");
	}

	public static Map<String, String> buildLoginParams(String token) {
		return Map.of("_loginid", "admin", "_token", token);
	}

	// Step 6: Send a POST request to create an order
	public static Response createOrderRequest(String url, Map<String, String> headers, Map<String, String> loginParams,
			String payload) {
		return RestAssured.given().headers(headers).queryParams(loginParams).body(payload).post(url);
	}

	
	
	
	
	// Step 7: Log the response details
	public static void logResponseDetails(Response response) {
		System.out.println("Response logs: " + response.then().log().all());
		System.out.println("Status Code: " + response.getStatusCode());
	}

	// Step 8: Validate that the status code
	public static boolean isResponseStatusOK(Response response) {
        return response.getStatusCode() == 200;
    }

	// Step 9: Extract and print the order number from the response
	public static String extractOrderNumber(Response response) {
		return response.jsonPath().getString("OrderNo");
	}

	// Step 10: Handle non-OK status codes
	public static void handleNonOKStatus(Response response) {
		System.out.println("Failed to create order. Status Code: " + response.getStatusCode());
	}

	public static void handleException(Exception e) {
		e.printStackTrace();
	}

	// Step 11: Return the order number
	public static String getOrderNumber(Response response) {
		return response.jsonPath().getString("OrderNo");
	}

}
