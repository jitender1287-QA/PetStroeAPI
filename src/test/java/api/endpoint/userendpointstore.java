package api.endpoint;

import static io.restassured.RestAssured.given;


import api.payload.User1;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
public class userendpointstore {
	public static Response creatOrder(User1 payload1) {
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload1)
		.when()
		.post(Routes.post1_url);
		return response;
	}
	public static Response getOrder(String orderId) {
		Response response=given()
		.pathParam("orderId", orderId)
		.when()
		.get(Routes.get1_url);
		return response;
	}
	
	public static Response deletOrderc(String orderId) {
		Response response=given()
		.pathParam("orderId", orderId)
		.when()
		.delete(Routes.delete1_url);
		return response;
	}
	
}
