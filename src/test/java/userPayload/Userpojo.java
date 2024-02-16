package userPayload;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


	
	public class Userpojo {
		
		
		private int id;
		private String user_last_name;
	    private String user_contact_number;
	    private String user_email_id;
	    private List<String> userAddress;
	    
	    public Userpojo() {
	    	userAddress = new ArrayList<>(5);
	    	userAddress.add("a-32");
	    	userAddress.add("");
	    	userAddress.add("");
	    	userAddress.add("");
	    	userAddress.add("");
	    }
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
		private String user_first_name;
	    public String getUser_first_name() {
			return user_first_name;
		}
		public void setUser_first_name(String user_first_name) {
			this.user_first_name = user_first_name;
		}
		public String getUser_last_name() {
			return user_last_name;
		}
		public void setUser_last_name(String user_last_name) {
			this.user_last_name = user_last_name;
		}
		public String getUser_contact_number() {
			return user_contact_number;
		}
		public void setUser_contact_number(String user_contact_number) {
			this.user_contact_number = user_contact_number;
		}
		public String getUser_email_id() {
			return user_email_id;
		}
		public void setUser_email_id(String user_email_id) {
			this.user_email_id = user_email_id;
		}
		public List<String> getUserAddress() {
			return userAddress;
		}
		public void setUserAddress(String[] userAddress) {
			this.userAddress = Arrays.asList(userAddress);
		}
	
		@Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("{\n");
			sb.append("\"user_first_name\": \"").append(user_first_name).append("\",\n");
			sb.append("\"user_last_name\": \"").append(user_last_name).append("\",\n");
			sb.append("\"user_contact_number\": ").append(user_contact_number).append(",\n");
			sb.append("\"user_email_id\": \"").append(user_email_id).append("\",\n");
			sb.append("\"userAddress\": {\n");
//	        sb.append("\"addressId\": ").append(id).append(",\n");
	        // Assuming "userAddress" is a List of Strings
	        sb.append("\"plotNumber\": \"").append(userAddress.get(0)).append("\",\n");
	        sb.append("\"street\": \"").append(userAddress.get(1)).append("\",\n");
	        sb.append("\"state\": \"").append(userAddress.get(2)).append("\",\n");
	        sb.append("\"country\": \"").append(userAddress.get(3)).append("\",\n");
	        // Assuming "zipCode" is stored as a String
	        sb.append("\"zipCode\": \"").append(userAddress.get(4)).append("\"\n");
	        sb.append("}\n");
//	        sb.append("\"user_id\": ").append(id).append(",\n");

	        sb.append("}");
	        return sb.toString();
	    }
	    
		
	   
	}



