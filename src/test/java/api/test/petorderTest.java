package api.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.userEndspoint;
import api.endpoint.userendpointstore;
import api.payload.User1;
import io.restassured.response.Response;

public class petorderTest {
	Faker faker1;
	User1 userpaylod1;
	
	@BeforeClass
	public  void setupdata1() {
		faker1= new Faker();
userpaylod1= new User1();


userpaylod1.setId(faker1.idNumber().hashCode());
userpaylod1.setPetId(faker1.idNumber().hashCode());
userpaylod1.setQuantity(faker1.idNumber().hashCode());
userpaylod1.setShipDate(faker1.date().toString());

}
	
	@Test(priority=1)
	public void testpostuser1() {
		Response response= userendpointstore.creatOrder(userpaylod1);
		response.then().log().all();

	}
}