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
public class AdvertList {
		public static class Attr{
			public static final String IMAGE = "image";
			public static final String KEYWORD = "keyword";
		}
		private String image;
		private String keyword;
		
		public AdvertList() {
		}
		
		public AdvertList(String image, String keyword) {
			super();
			this.image = image;
			this.keyword = keyword;
		}

		public static ArrayList<AdvertList> newInstanceList(String jsonDatas){
			ArrayList<AdvertList> AdvertDatas = new ArrayList<AdvertList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String image = obj.optString(Attr.IMAGE);
					String keyword = obj.optString(Attr.KEYWORD);
					AdvertDatas.add(new AdvertList(image, keyword));
					//System.out.println("image="+image+",class_id="+keyword);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}


		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		@Override
		public String toString() {
			return "AdvertList [image=" + image + ", keyword=" + keyword + "]";
		}

}
