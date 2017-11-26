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


public class WishReplyList {
	
	/**
	private int id;    //id
	private int userid;    //发布用户id
	private String pubdate;  //发布日期
	private String wishtype;  //心愿类型
	private String wishtitle;   //心愿标题  
	private String content;   //心愿内容
	private int isfinished;    //是否已完成
	private int isevaluated;   //是否已评价
	 *
	 */
		public static class Attr{
			public static final String WISH_NAME  = "wishname";
			public static final String WISH_FINISHDATE = "wishfinisheddate";
			public static final String WISH_COMMENT = "wishcomment";
			@Override
			public String toString() {
				return "Attr [getClass()=" + getClass() + ", hashCode()="
						+ hashCode() + ", toString()=" + super.toString() + "]";
			}

		}
		private String wishname;
		private String wishfinisheddate;
		private String wishcomment;
		
		
	
		






		















		public String getWishname() {
			return wishname;
		}







		public void setWishname(String wishname) {
			this.wishname = wishname;
		}







		public String getWishfinisheddate() {
			return wishfinisheddate;
		}







		public void setWishfinisheddate(String wishfinisheddate) {
			this.wishfinisheddate = wishfinisheddate;
		}







		public String getWishcomment() {
			return wishcomment;
		}







		public void setWishcomment(String wishcomment) {
			this.wishcomment = wishcomment;
		}







		public WishReplyList(String wishname, String wishfinisheddate,
				String wishcomment) {
			super();
			this.wishname = wishname;
			this.wishfinisheddate = wishfinisheddate;
			this.wishcomment = wishcomment;
		}







		public WishReplyList() {
		}
		

	




/**
		private int id;    //id
		private int userid;    //发布用户id
		private String pubdate;  //发布日期
		private String wishtype;  //心愿类型
		private String wishtitle;   //心愿标题  
		private String content;   //心愿内容
		private int isfinished;    //是否已完成
		private int isevaluated;   //是否已评价
			theme_id,theme_name,theme_content,theme_likecount,theme_commentcount,member_id,member_name,member_avatar
			
			
			
			public static final String WISH_ID  = "id";
			public static final String WISH_USERID = "userid";
			public static final String WISH_PUBDATE = "pubdate";
			public static final String WISH_TYPE = "wishtype";
			public static final String WISH_TITLE = "wishtitle";
			public static final String  WISH_CONTENT= "content";
			public static final String  WISH_ISFINISHED= "isfinished";
			public static final String  WISH_ISEVALUTATED= "isevaluated";
 * @param jsonDatas
 * @return
 */

		public static ArrayList<WishReplyList> newInstanceList(String jsonDatas){
			ArrayList<WishReplyList> AdvertDatas = new ArrayList<WishReplyList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String wish_name = obj.optString(Attr.WISH_NAME);
					String wish_finishdate = obj.optString(Attr.WISH_FINISHDATE);
					String wish_comment= obj.optString(Attr.WISH_COMMENT);
			
				
					WishReplyList bean =new WishReplyList(wish_name,wish_finishdate,wish_comment);
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}
		
		
		






		

}
