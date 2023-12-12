package stepDefinitions;

import org.testng.Assert;

import api.request.CreateOrderRequest;
import api.request.CreateShipment;
import api.request.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CallCenterAPI_ScenarioStepDef {
	Response response;
	Login lg;

	// Login

	@When("User send the post login request for getting user token")
	public void user_send_the_post_login_request_for_getting_user_token() throws InterruptedException {
		String userToken = lg.token();
		System.out.println("userToken " + userToken);
	}

	// Scenario-2 - CreateOrder

	@When("User calls createorderAPI with Post http request")
	public void user_calls_createorder_api_with_post_http_request() {
		try {
			CreateOrderRequest.order();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("The API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		System.out.println("Status Code");
	}

	// Scenario-3 create shipment

	@When("User calls createshipmentAPI with Post http request")
	public void user_calls_createshipment_api_with_post_http_request() {
		try {
			CreateShipment.shipment();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
