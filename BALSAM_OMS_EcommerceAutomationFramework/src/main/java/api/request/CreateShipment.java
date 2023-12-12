package api.request;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.testng.Assert.assertEquals;

public class CreateShipment extends Login {
	public static String generateStringFromResource(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}

	public static void shipment() throws InterruptedException {

		try {
			String myRequest = generateStringFromResource(
					"C:\\Users\\ShubhamMalviya\\OneDrive - VRIZE INDIA PRIVATE LIMITED\\Pictures\\UI_Scenario_Framework_Done\\EcommerceAutomationFramework\\src\\test\\resources\\testData\\payload\\create shipment.xml");
			String endpoint = "/executeFlow/BHManageShipment";
			useRelaxedHTTPSValidation();
			RestAssured.config = RestAssured.config()
					.encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false));

			//Login lg = new Login();
			//String token = Login.token();
			
			Response response = given().contentType("application/xml").body(myRequest).queryParam("_loginid", "admin")
					.queryParam("_token", token()).when()
					.post("http://sterling-oms-qa.z.balsamhill.com:9080/smcfs/restapi/executeFlow/BHManageShipment")
					.then().extract().response();
			// Log Request
			System.out.println("Request: ");
			System.out.println("Endpoint: " + endpoint);
			System.out.println("Method: POST");
			System.out.println("Headers: " + response.getHeaders().toString());
			System.out.println("Body: " + myRequest);

			// Log Response
			System.out.println("\nResponse: ");
			System.out.println("Status Code: " + response.getStatusCode());
			System.out.println("Headers: " + response.getHeaders().toString());
			System.out.println("Body: " + response.getBody().asString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
