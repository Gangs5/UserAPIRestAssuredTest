package userEndpoints;

public class Routes {
	
	public static String base_url= "https://userapi-8877aadaae71.herokuapp.com/uap/";
	public static String post_url = base_url + "createusers";
	public static String get_url = base_url + "users";
	public static String getid_url = base_url + "user/{userId}";
	public static String getname_url = base_url + "users/username/{userFirstName}";
	public static String put_url = base_url + "updateuser/{userId}";
	public static String deletebyname_url = base_url +"deleteuser/username/{userfirstname}";
	public static String deleteid_url = base_url +"deleteuser/{userId}";
	
	

}
