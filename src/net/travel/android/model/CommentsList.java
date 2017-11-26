/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:GoodsList.java
 */
package net.travel.android.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class CommentsList {
		public static class Attr{
			public static final String COMMENT_ID = "id";
			public static final String COMMENT_USERNAME = "username";
			public static final String COMMENT_START = "content";
			public static final String COMMENT_END = "commitdate";
		
		}
		private String id;
		private String username;
		private String starttimestr;
		private String endtimestr;
		
		public CommentsList() {
		}
		




























		public CommentsList(String id, String username, String starttimestr,
				String endtimestr) {
			super();
			this.id = id;
			this.username = username;
			this.starttimestr = starttimestr;
			this.endtimestr = endtimestr;
		}





























		public static ArrayList<CommentsList> newInstanceList(String jsonDatas){
			ArrayList<CommentsList> AdvertDatas = new ArrayList<CommentsList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				System.out.println("jsonDatas-->" + jsonDatas);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String id = obj.optString(Attr.COMMENT_ID);
					String name = obj.optString(Attr.COMMENT_USERNAME);
					String start = obj.optString(Attr.COMMENT_START);
					String end = obj.optString(Attr.COMMENT_END);
					CommentsList bean =new CommentsList(id,name,start,end);
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}















		public String getUsername() {
			return username;
		}















		public void setUsername(String username) {
			this.username = username;
		}





























		public String getId() {
			return id;
		}





























		public void setId(String id) {
			this.id = id;
		}





























		public String getStarttimestr() {
			return starttimestr;
		}





























		public void setStarttimestr(String starttimestr) {
			this.starttimestr = starttimestr;
		}





























		public String getEndtimestr() {
			return endtimestr;
		}





























		public void setEndtimestr(String endtimestr) {
			this.endtimestr = endtimestr;
		}























		

}
