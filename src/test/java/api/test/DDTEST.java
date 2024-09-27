package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoint.userEndspoint;
import api.payload.User;
import api.utlities.DataProvider1;
import io.restassured.response.Response;

public class DDTEST {

	@Test(priority=1,dataProvider="Data", dataProviderClass=DataProvider1.class)
	public void testpostuser(String UserID,String UserName,String FirstName,String Email,String Password,String Phone ) {
		User userPayload= new User();
		
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(UserName);
		userPayload.setFirstName(FirstName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		Response response=userEndspoint.createuser(userPayload);
		Assert.assertEquals(response.getStatusCode(),200);
	
}
	@Test(priority=2,dataProvider="UserNames", dataProviderClass=DataProvider1.class)
	public void Testdelete(String userName) {
		Response response=userEndspoint.deleteuser(userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
}