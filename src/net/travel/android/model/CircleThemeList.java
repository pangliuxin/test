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
public class CircleThemeList {
	
	/**
	 * theme_id, theme_name,theme_content,  theme_likecount,  theme_commentcount
		帖子id，   帖子标题，      帖子内容，                     点赞数量，                    回复数量 
	 * @author Administrator
	 * 
	 * 
	 * theme_id,theme_name,theme_content,theme_likecount,theme_commentcount,member_id,member_name,member_avatar
	 *
	 */
		public static class Attr{
			public static final String THEME_ID  = "theme_id";
			public static final String THEME_NAME = "theme_name";
			public static final String THEME_CONTENT = "theme_content";
			public static final String THEME_LIKECOUNT = "theme_likecount";
			public static final String THEME_COMMENTCOUNT = "theme_commentcount";
			public static final String  MEMBER_ID= "member_id";
			public static final String  MEMBER_NAME= "member_name";
			public static final String  MEMBER_AVATAR= "member_avatar";
			public static final String  CIRCLE_ID= "circle_id";
			@Override
			public String toString() {
				return "Attr [getClass()=" + getClass() + ", hashCode()="
						+ hashCode() + ", toString()=" + super.toString() + "]";
			}

		}
		private String theme_id;
		private String theme_name;
		private String theme_content;
		private String theme_likecount;
		private String theme_commentcount;
		private String member_id;
		private String member_name;
		private String member_avatar;
		private String circle_id;
		
		
	
		






		public String getCircle_id() {
			return circle_id;
		}





		public void setCircle_id(String circle_id) {
			this.circle_id = circle_id;
		}





		public String getMember_id() {
			return member_id;
		}





		public void setMember_id(String member_id) {
			this.member_id = member_id;
		}





		public String getMember_name() {
			return member_name;
		}





		public void setMember_name(String member_name) {
			this.member_name = member_name;
		}





		public String getMember_avatar() {
			return member_avatar;
		}





		public void setMember_avatar(String member_avatar) {
			this.member_avatar = member_avatar;
		}











		public CircleThemeList(String theme_id, String theme_name,
				String theme_content, String theme_likecount,
				String theme_commentcount, String member_id,
				String member_name, String member_avatar, String circle_id) {
			super();
			this.theme_id = theme_id;
			this.theme_name = theme_name;
			this.theme_content = theme_content;
			this.theme_likecount = theme_likecount;
			this.theme_commentcount = theme_commentcount;
			this.member_id = member_id;
			this.member_name = member_name;
			this.member_avatar = member_avatar;
			this.circle_id = circle_id;
		}





		public CircleThemeList() {
		}
		

	


		public String getTheme_id() {
			return theme_id;
		}





		public void setTheme_id(String theme_id) {
			this.theme_id = theme_id;
		}





		public String getTheme_name() {
			return theme_name;
		}





		public void setTheme_name(String theme_name) {
			this.theme_name = theme_name;
		}





		public String getTheme_content() {
			return theme_content;
		}





		public void setTheme_content(String theme_content) {
			this.theme_content = theme_content;
		}





		public String getTheme_likecount() {
			return theme_likecount;
		}





		public void setTheme_likecount(String theme_likecount) {
			this.theme_likecount = theme_likecount;
		}





		public String getTheme_commentcount() {
			return theme_commentcount;
		}





		public void setTheme_commentcount(String theme_commentcount) {
			this.theme_commentcount = theme_commentcount;
		}



/**
 * 			public static final String THEME_ID  = "theme_id";
			public static final String THEME_NAME = "theme_name";
			public static final String THEME_CONTENT = "theme_content";
			public static final String THEME_LIKECOUNT = "theme_likecount";
			public static final String THEME_COMMENTCOUNT = "theme_commentcount";
			
			
			theme_id,theme_name,theme_content,theme_likecount,theme_commentcount,member_id,member_name,member_avatar
 * @param jsonDatas
 * @return
 */

		public static ArrayList<CircleThemeList> newInstanceList(String jsonDatas){
			ArrayList<CircleThemeList> AdvertDatas = new ArrayList<CircleThemeList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String theme_id = obj.optString(Attr.THEME_ID);
					String theme_name = obj.optString(Attr.THEME_NAME);
					String theme_content = obj.optString(Attr.THEME_CONTENT);
					String theme_likecount = obj.optString(Attr.THEME_LIKECOUNT);
					String theme_commentcount = obj.optString(Attr.THEME_COMMENTCOUNT);
					String member_id = obj.optString(Attr.MEMBER_ID);
					String member_name = obj.optString(Attr.MEMBER_NAME);
					String member_avatar = obj.optString(Attr.MEMBER_AVATAR);
					String circle_id = obj.optString(Attr.CIRCLE_ID);
				
					CircleThemeList bean =new CircleThemeList(theme_id, theme_name, theme_content, theme_likecount, theme_commentcount,member_id,member_name,member_avatar,circle_id);
					//System.out.println("goodlist-->" + bean.toString());
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}



		

}
