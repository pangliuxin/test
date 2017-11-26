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
public class WishComments {
		public static class Attr{
			public static final String COMMENT_DATE = "commentdate";
			public static final String COMMENT_REPLY = "comment";
			public static final String COMMENT_ID = "id";

		
		
		}
		// 
		//会员名
		private String commentdate;
		//回复内容
		private String comment;
		private int id;








		
	
		
	























		public int getId() {
			return id;
		}












		public void setId(int id) {
			this.id = id;
		}












		@Override
		public String toString() {
			return "WishComments [commentdate=" + commentdate + ", comment="
					+ comment + "]";
		}












		public WishComments(String commentdate, String comment,int id) {
			super();
			this.commentdate = commentdate;
			this.comment = comment;
			this.id = id;
		}












		public WishComments() {
		}

		



















		public String getCommentdate() {
			return commentdate;
		}












		public void setCommentdate(String commentdate) {
			this.commentdate = commentdate;
		}












		public String getComment() {
			return comment;
		}












		public void setComment(String comment) {
			this.comment = comment;
		}







/**
 * 		// 
		//会员名
		private String commentdate;
		//回复内容
		private String comment;
 * @param jsonDatas
 * @return
 */




		public static ArrayList<WishComments> newInstanceList(String jsonDatas){
			ArrayList<WishComments> AdvertDatas = new ArrayList<WishComments>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					
					// 
				     String commentdate = obj.optString(Attr.COMMENT_DATE);
					 String comment = obj.optString(Attr.COMMENT_REPLY);
					 int id = obj.optInt(Attr.COMMENT_ID);
		
		
				

					AdvertDatas.add(new WishComments( commentdate,  comment,id
							));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}









	



		

	

}
