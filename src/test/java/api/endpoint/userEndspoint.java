package api.endpoint;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.response.Response;
import io.restassured.http.ContentType;

//userendpoint 
//create for perfrom curd opration read,delete update 
public class userEndspoint {

	public static Response createuser(User payload) {
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
	}
	public static Response readuser(String userName) {
		Response response=given()
		.pathParam("username", userName)
		.when()
		.get(Routes.get_url);
		return response;
	}
	public static Response updateuser(String userName,User payload) {
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		.when()
		.put(Routes.update_url);
		return response;
	}
	public static Response deleteuser(String userName) {
		Response response=given()
		.pathParam("username", userName)
		.when()
		.delete(Routes.delete_url);
		return response;
	}
	
}
