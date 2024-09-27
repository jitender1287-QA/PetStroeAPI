package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.userEndspoint;
import api.endpoint.userendpoint2;
import api.payload.User;
import io.restassured.response.Response;

public class userTestnew {
	Faker faker;
	User userpaylod;
public	Logger logger;
	
	@BeforeClass
	public  void setupdata() {
		faker= new Faker();
userpaylod= new User();


userpaylod.setId(faker.idNumber().hashCode());
userpaylod.setUsername(faker.name().username());
userpaylod.setFirstName(faker.name().firstName());
userpaylod.setLastName(faker.name().lastName());
userpaylod.setEmail(faker.internet().safeEmailAddress());
userpaylod.setPassword(faker.internet().password(5,10));
userpaylod.setPhone(faker.phoneNumber().cellPhone());



//logs 
logger= LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void  Testpostuser(){
		
		logger.info("--------------create user-----");
		Response response= userendpoint2.createuser(userpaylod);
		response.then().log().all();
		logger.info("--------------user is create -----");
	Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=2)
	public void testgetuserbyname() {
		logger.info("--------------reading user info-----");
	Response response=userendpoint2.readuser(this.userpaylod.getUsername());
		response.then().log().all();
	Assert.assertEquals(response.getStatusCode(),200);
	logger.info("--------------display info user-----");
	}
	
	
	@Test(priority=3)
	public void Testupdateuserbyname() {
		//update data using payload
		logger.info("--------------updateding user-----");
		userpaylod.setUsername(faker.name().username());
		userpaylod.setFirstName(faker.name().firstName());
		userpaylod.setLastName(faker.name().lastName());
		Response response=userendpoint2.updateuser(this.userpaylod.getUsername(),userpaylod);
		response.then().log().all();
	Assert.assertEquals(response.getStatusCode(),200);
		//checking after update 
	
	Response responseafterupdate=userendpoint2.readuser(this.userpaylod.getUsername());
	response.then().log().all();

	Assert.assertEquals(responseafterupdate.getStatusCode(),200);
	}
	
	@Test(priority=4)
	
	public void TestdeleteUser() {
		logger.info("--------------create user deletet-----");
		Response response=userendpoint2.deleteuser(this.userpaylod.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("--------------delete user-----");
	}
}

