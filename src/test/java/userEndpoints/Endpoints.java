package userEndpoints;


import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import userPayload.Userpojo;

public class Endpoints {
	
	public static Response createuser(Userpojo payload) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload.toString())
				.when().post(Routes.post_url);
				return response;
		}
	
	public static Response readAllUsers() {
		
		Response response = given()
				.when().get(Routes.get_url);
		return response;
	}
	

	public static Response readUsersbyid(int userId) {
		
		Response response = given().pathParam("user", userId)
				.when().get(Routes.getid_url);
		return response;
	}
	
public static Response readUsersbyname(String userFirstName) {
		
		Response response = given()
				.pathParam( "username",  userFirstName)
				.when().get(Routes.getname_url);
		return response;
	}
	
public static Response updateuser(String userId, Userpojo payload) {
	
	Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload.toString())
			.pathParam("updateuser", userId)
			.when().put(Routes.put_url);
			return response;
	
	
}
public static Response deleteUsersByID(int userId) {
	
	Response response = given().pathParam("userId", userId)
			.when().delete(Routes.deleteid_url);
	return response;
}



}
	

