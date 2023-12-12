package api.request;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;
import static io.restassured.config.EncoderConfig.encoderConfig;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

import org.testng.Assert;

import constants.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ApiBaseRequestUtils;

public class CreateOrderRequest {


	public static String generateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	public static String order() throws InterruptedException {
		String orderNo = "";
		try {
			String myRequest = generateStringFromResource(
					"C:\\Users\\ShubhamMalviya\\OneDrive - VRIZE INDIA PRIVATE LIMITED\\Pictures\\UI_Scenario_Framework_Done\\EcommerceAutomationFramework\\src\\test\\resources\\testData\\payload\\Ordercreate.xml");
			String endpoint = "/invoke/createOrder";
			useRelaxedHTTPSValidation();
			RestAssured.config = RestAssured.config()
					.encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

			String apiBaseUrl = Constants.getAPIBASEURL();
			String url = apiBaseUrl + endpoint;

			Login lg = new Login();
			String token = Login.token();

			Map<String, String> headers = Map.of("Content-Type", "application/xml");
			Map<String, String> loginParams = Map.of("_loginid", "admin", "_token", token);

			Response response = given().headers(headers).queryParams(loginParams).body(myRequest).post(url);

			// log Response
			System.out.println("logs " + response.then().log().all());
			System.out.println("Status Code  " + response.getStatusCode());

			// Validation
			Assert.assertEquals(response.getStatusCode(), 200);

			orderNo = response.jsonPath().getString("OrderNo");
			System.out.println("orderNo " + orderNo);

			// Fetching order number from response

		} catch (Exception e) {
			e.printStackTrace();
		}

		return orderNo;
	}

//	public static void main(String[] args) throws InterruptedException {
//
//		CreateOrderRequest.order();
//
//		String OrderNO=order();
//	}
}
