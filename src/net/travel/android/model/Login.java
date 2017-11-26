/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:Login.java
 */
package net.travel.android.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class Login {
		public static class Attr{
			public static final String KEY = "key";
			public static final String USERNAME = "username";
			public static final String ROLE = "role";
		}
		
		private String key;
		private String username;
		private String role;
		
		public Login() {
		}


		public Login(String key, String username,String role) {
			super();
			this.key = key;
			this.username = username;
			this.role = role;
		}


		public static Login  newInstanceList(String json){
			Login bean = null;
			try {
				JSONObject obj = new JSONObject(json);
				String userstr = obj.optString("jsonString");
				JSONObject user = new JSONObject(userstr);
				
				
//				System.out.println(obj.optString("username"));
				if(obj.length()> 0){
					String username = user.optString("username");
					String key = user.optString("id");
					String role = user.optString("role");
					 bean = new Login(key, username,role);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return bean;
		}


		public String getKey() {
			return key;
		}


		public void setKey(String key) {
			this.key = key;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}


		@Override
		public String toString() {
			return "Login [key=" + key + ", username=" + username + "]";
		}
		
}
