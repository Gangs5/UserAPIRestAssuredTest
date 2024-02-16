package userTest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import base.baseClass;
import io.restassured.response.Response;
import userEndpoints.Endpoints;
import userPayload.Userpojo;


public class UserTest extends baseClass {
	
	Faker faker;
	Userpojo userPayload;
	
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		Userpojo userPayload = new Userpojo();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUser_first_name(faker.name().firstName());
		userPayload.setUser_last_name(faker.name().lastName());
		userPayload.setUser_contact_number(faker.phoneNumber().cellPhone());
		userPayload.setUser_email_id(faker.internet().safeEmailAddress());
		
		}
		
	 @Test(priority = 1)
	public void testPostUser() {
		
	Response response = Endpoints.createuser(userPayload);
	response.then().log().all();
	Assert.assertEquals(response.getStatusCode(), 201);
		
		} 
	/*@Test(priority=2)
	public void testGetusers() {
		
		Response response = Endpoints.readAllUsers(this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}*/
	@Test(priority=3)
	public void testGetUsersid() {
		
		Response response = Endpoints.readUsersbyid(this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);
	}
	@Test(priority = 3)
	public void testUsername() {
		Response response = Endpoints.readUsersbyname(this.userPayload.getUser_first_name());
		response.then().log().all();
		
	}
	
	
	
	
	

}
