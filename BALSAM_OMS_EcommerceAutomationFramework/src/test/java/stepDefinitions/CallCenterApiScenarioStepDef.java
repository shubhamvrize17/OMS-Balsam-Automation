package stepDefinitions;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;

import api.request.CreateOrderApiRequestPage;
import api.request.CreateShipmentApiRequestPage;
import api.request.LoginApiRequestPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CallCenterApiScenarioStepDef {
	static LoginApiRequestPage loginPg;
	static CreateOrderApiRequestPage orderPg;
	static CreateShipmentApiRequestPage shipmentPg;

	private String url;
	private String requestBody;
	private Response response;
	private String userToken;
	private String myRequest;
	private String orderNo = "";

	// Scenario -1
	@Given("the user provides valid login credentials")
	public void the_user_provides_valid_login_credentials() {
		url = loginPg.buildApiUrl();
		requestBody = loginPg.buildLoginRequestBody();
	}

	@When("the user sends a login request to the API")
	public void the_user_sends_a_login_request_to_the_api() {
		response = loginPg.sendLoginRequest(url, requestBody);
	}

	@Then("the user should receive a valid token")
	public void the_user_should_receive_a_valid_token() {
		userToken = loginPg.extractUserToken(response);
		Assert.assertNotNull("User token should not be null", userToken);
		System.out.println("User Token: " + userToken);
	}

	// Scenario-2
	@Given("the user provide valid order creation payload in the file")
	public void the_user_provide_valid_order_creation_payload_in_the_file() {
		try {
			myRequest = orderPg.readOrderPayload();
			orderPg.configureRestAssured();
			url = orderPg.buildApiUrl();
			userToken = orderPg.getAuthToken();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@When("the user sends a create order API request")
	public void the_user_sends_a_create_order_api_request() {

		Map<String, String> headers = orderPg.buildRequestHeaders(userToken);
		Map<String, String> loginParams = orderPg.buildLoginParams(userToken);

		response = orderPg.createOrderRequest(url, headers, loginParams, myRequest);

	}

	@Then("the order should be created successfully with a valid order number")
	public void the_order_should_be_created_successfully_with_a_valid_order_number() {
		if (orderPg.isResponseStatusOK(response)) {
			orderNo = orderPg.extractOrderNumber(response);
			System.out.println("Order Number: " + orderNo);
		} else {
			orderPg.handleNonOKStatus(response);
		}

		orderPg.getOrderNumber(response);

	}

	// Scenario : 3

	@Given("the user provide valid shipment creation payload in the file")
	public void the_user_provide_valid_shipment_creation_payload_in_the_file() {
		try {
			myRequest = shipmentPg.readOrderPayload();
			shipmentPg.configureRestAssured();
			url = shipmentPg.buildApiUrl();
			userToken = shipmentPg.getAuthToken();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("the user sends a shipment order API request")
	public void the_user_sends_a_shipment_order_api_request() {
		Map<String, String> headers = shipmentPg.buildRequestHeaders(userToken);
		Map<String, String> loginParams = shipmentPg.buildLoginParams(userToken);

		response = shipmentPg.createOrderRequest(url, headers, loginParams, myRequest);
	}

	@Then("the API should respond with a successful status code")
	public void the_api_should_respond_with_a_successful_status_code() {
		if (shipmentPg.isResponseStatusOK(response)) {
		} else {
			shipmentPg.handleNonOKStatus(response);
		}
	}

	@Then("the response should contain the shipment details")
	public void the_response_should_contain_the_shipment_details() {
		shipmentPg.logResponseDetails(response);
	}
}
