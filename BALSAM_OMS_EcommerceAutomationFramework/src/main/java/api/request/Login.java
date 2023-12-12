/*
 * package API; import io.restassured.response.Response; import static
 * io.restassured.RestAssured.given; import io.restassured.http.ContentType;
 * 
 * public class Login { public static void token() throws InterruptedException {
 * String requestBody = "{\r\n" + "    \"LoginID\" : \"admin\",\r\n" +
 * "    \"Password\" : \"password\"\r\n" + "}"; String baseUrl =
 * "http://sterling-oms-qa.z.balsamhill.com:9080/smcfs/restapi"; Response
 * response = given().baseUri(baseUrl) .contentType("application/json")
 * .accept(ContentType.JSON) .body(requestBody) .when() .post("/invoke/login");
 * System.out.println(response.asString()); } public static void main(String[]
 * args) throws InterruptedException { token(); }
 * 
 * }
 */


package api.request;
 
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
 
public class Login {
    public static String token() throws InterruptedException {
        String requestBody = "{\r\n"
                + "    \"LoginID\" : \"admin\",\r\n"
                + "    \"Password\" : \"password\"\r\n"
                + "}";
        String baseUrl = "http://sterling-oms-qa.z.balsamhill.com:9080/smcfs/restapi";
        Response response = given().baseUri(baseUrl)
                .contentType("application/json")
                .accept(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/invoke/login");
 
        String userToken = response.jsonPath().getString("UserToken");
 
        System.out.println(userToken);
        return userToken;
    }
 
    public static void main(String[] args) throws InterruptedException {
        String userToken = token();
    }
}
