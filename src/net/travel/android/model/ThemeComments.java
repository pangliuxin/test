/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:AdvertList.java
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


/**
 * 
 * 

                
              
 *
 */
public class ThemeComments {
		public static class Attr{
			public static final String MEMBER_NAME = "member_name";
			public static final String REPLY_CONTENT = "reply_content";

		
		
		}
		// 
		//会员名
		private String member_name;
		//回复内容
		private String reply_content;








		
	
		
		@Override
		public String toString() {
			return "ThemeComments [member_name=" + member_name
					+ ", reply_content=" + reply_content + "]";
		}












		public ThemeComments(String member_name, String reply_content) {
			super();
			this.member_name = member_name;
			this.reply_content = reply_content;
		}












		public ThemeComments() {
		}

		










		public String getMember_name() {
			return member_name;
		}












		public void setMember_name(String member_name) {
			this.member_name = member_name;
		}












		public String getReply_content() {
			return reply_content;
		}












		public void setReply_content(String reply_content) {
			this.reply_content = reply_content;
		}












		public static ArrayList<ThemeComments> newInstanceList(String jsonDatas){
			ArrayList<ThemeComments> AdvertDatas = new ArrayList<ThemeComments>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					
					// 
				     String member_name = obj.optString(Attr.MEMBER_NAME);
					 String reply_content = obj.optString(Attr.REPLY_CONTENT);
		
		
				

					AdvertDatas.add(new ThemeComments( member_name,  reply_content
							));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}









	



		

	

}
