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
public class GoodsList {
		public static class Attr{
			public static final String GOODS_ID = "id";
			public static final String GOODS_NAME = "nickname";
			public static final String GOODS_NUMBER = "phonenum";
		}
		private String id;
		private String nickname;
		private String phonenum;
		

		public GoodsList(String id, String nickname, String phonenum) {
			super();
			this.id = id;
			this.nickname = nickname;
			this.phonenum = phonenum;
		}







//		public Attr(String id, String nickname, String phonenum) {
		public static ArrayList<GoodsList> newInstanceList(String jsonDatas){
			ArrayList<GoodsList> AdvertDatas = new ArrayList<GoodsList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String id = obj.optString(Attr.GOODS_ID);
					String nickname = obj.optString(Attr.GOODS_NAME);
					String phonenum = obj.optString(Attr.GOODS_NUMBER);
					GoodsList bean =new GoodsList(id, nickname, phonenum);
					//System.out.println("goodlist-->" + bean.toString());
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}







		public String getId() {
			return id;
		}







		public void setId(String id) {
			this.id = id;
		}







		public String getNickname() {
			return nickname;
		}







		public void setNickname(String nickname) {
			this.nickname = nickname;
		}







		public String getPhonenum() {
			return phonenum;
		}







		public void setPhonenum(String phonenum) {
			this.phonenum = phonenum;
		}


		

}
