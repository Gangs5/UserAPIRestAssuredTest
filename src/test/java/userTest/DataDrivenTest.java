package userTest;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.authentication.BasicAuthScheme;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.baseClass;
import io.restassured.response.Response;
import userEndpoints.Endpoints;
import userEndpoints.Routes;
import userPayload.Userpojo;
import org.json.JSONObject;
import userUtilities.DataProviders;

public class DataDrivenTest extends baseClass {
	
	Userpojo userPayload;

	private int user_id = -1;
	
	@BeforeTest()
	
	public void datadriven() {
		userPayload = new Userpojo();
		String baseURL= Routes.base_url;

		RestAssured.baseURI=baseURL;



		// Set up basic authentication

		AuthenticationScheme authScheme = new BasicAuthScheme();

		((BasicAuthScheme) authScheme).setUserName("Numpy@gmail.com");

		((BasicAuthScheme) authScheme).setPassword("tim123");

		RestAssured.authentication = authScheme;
	}

	@Test(priority = 2, dataProvider = "userData", dataProviderClass = DataProviders.class)
	public void testCreateUser(String firstName, String lastName, String contactNumber, String email, String[] userAddress) {
		// Construct user payload
		Userpojo userPayload = new Userpojo();
		userPayload.setUser_first_name(firstName);
		userPayload.setUser_last_name(lastName);
		userPayload.setUser_contact_number(contactNumber);
		userPayload.setUser_email_id(email);

		// Additional data handling if needed
		userPayload.setUserAddress(userAddress);

		String x = userPayload.toString();

		// Create user
		Response response = Endpoints.createuser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 201);

		// Extract user_id from response
		String responseBody = response.getBody().asString();
		JSONObject rbody = new JSONObject(responseBody);
		if (rbody.has("user_id")) {
			user_id = rbody.getInt("user_id");
		}

		// Update userPayload with user_id
		userPayload.setId(user_id);
	}

	@AfterMethod
	public void deleteUser() {
		if (user_id != -1) {
			Response response = Endpoints.deleteUsersByID(user_id);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
		}
	}

	@Test(priority=1)
	public void testGetAllUsers() {

		Response response = Endpoints.readAllUsers();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}


//@Test(priority=3)
//public void testGetUsersid() {
//	
//	Response response = Endpoints.readUsersbyid(this.userPayload.getId());
//	response.then().log().all();
//	Assert.assertEquals(response.getStatusCode(), 201);
//}
//@Test(priority = 3)
public void testUsername() {
	Response response = Endpoints.readUsersbyname(this.userPayload.getUser_first_name());
	response.then().log().all();
	
}

}
