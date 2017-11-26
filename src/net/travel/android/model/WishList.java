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


public class WishList {
	
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
			public static final String WISH_ID  = "id";
			public static final String WISH_USERID = "userid";
			public static final String WISH_PUBDATE = "pubdate";
			public static final String WISH_TYPE = "wishtype";
			public static final String WISH_TITLE = "wishtitle";
			public static final String  WISH_CONTENT= "content";
			public static final String  WISH_ISFINISHED= "isfinished";
			public static final String  WISH_ISEVALUTATED= "isevaluated";
			@Override
			public String toString() {
				return "Attr [getClass()=" + getClass() + ", hashCode()="
						+ hashCode() + ", toString()=" + super.toString() + "]";
			}

		}
		private int id;    //id
		private int userid;    //发布用户id
		private String pubdate;  //发布日期
		private String wishtype;  //心愿类型
		private String wishtitle;   //心愿标题  
		private String content;   //心愿内容
		private int isfinished;    //是否已完成
		private int isevaluated;   //是否已评价
		
		
	
		






		









		public WishList(int id, int userid, String pubdate, String wishtype,
				String wishtitle, String content, int isfinished,
				int isevaluated) {
			super();
			this.id = id;
			this.userid = userid;
			this.pubdate = pubdate;
			this.wishtype = wishtype;
			this.wishtitle = wishtitle;
			this.content = content;
			this.isfinished = isfinished;
			this.isevaluated = isevaluated;
		}







		public WishList() {
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

		public static ArrayList<WishList> newInstanceList(String jsonDatas){
			ArrayList<WishList> AdvertDatas = new ArrayList<WishList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					int wish_id = obj.optInt(Attr.WISH_ID);
					int wish_userid = obj.optInt(Attr.WISH_USERID);
					String wish_pubdate = obj.optString(Attr.WISH_PUBDATE);
					String wish_wishtype = obj.optString(Attr.WISH_TYPE);
					String wish_wishtitle = obj.optString(Attr.WISH_TITLE);
					String wish_content = obj.optString(Attr.WISH_CONTENT);
					int wish_isfinished = obj.optInt(Attr.WISH_ISFINISHED);
					int wish_isevaluated = obj.optInt(Attr.WISH_ISEVALUTATED);
				
					WishList bean =new WishList(wish_id, wish_userid, wish_pubdate, wish_wishtype, wish_wishtitle,wish_content,wish_isfinished,wish_isevaluated);
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}
		
		
		
		public int getId() {
			return id;
		}





		public void setId(int id) {
			this.id = id;
		}





		public int getUserid() {
			return userid;
		}





		public void setUserid(int userid) {
			this.userid = userid;
		}





		public String getPubdate() {
			return pubdate;
		}





		public void setPubdate(String pubdate) {
			this.pubdate = pubdate;
		}





		public String getWishtype() {
			return wishtype;
		}





		public void setWishtype(String wishtype) {
			this.wishtype = wishtype;
		}





		public String getWishtitle() {
			return wishtitle;
		}





		public void setWishtitle(String wishtitle) {
			this.wishtitle = wishtitle;
		}





		public String getContent() {
			return content;
		}





		public void setContent(String content) {
			this.content = content;
		}





		public int getIsfinished() {
			return isfinished;
		}





		public void setIsfinished(int isfinished) {
			this.isfinished = isfinished;
		}





		public int getIsevaluated() {
			return isevaluated;
		}





		public void setIsevaluated(int isevaluated) {
			this.isevaluated = isevaluated;
		}






		

}
