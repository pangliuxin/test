/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:CommendList.java
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
public class CommendList {
		public static class Attr{
			public static final String GOODS_ID = "goods_id";
			public static final String GOODS_NAME = "goods_name";
			public static final String GOODS_PRICE = "goods_price";
			public static final String GOODS_IMAGE_URL = "goods_image_url";
		}
		private String goods_id;
		private String goods_name;
		private String goods_price;
		private String goods_image_url;
		
		public CommendList() {
		}
		
		public CommendList(String goods_id, String goods_name,
				String goods_price, String goods_image_url) {
			super();
			this.goods_id = goods_id;
			this.goods_name = goods_name;
			this.goods_price = goods_price;
			this.goods_image_url = goods_image_url;
		}

		public static ArrayList<CommendList> newInstanceList(String jsonDatas){
			ArrayList<CommendList> commendlist = new ArrayList<CommendList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String goods_id = obj.optString(Attr.GOODS_ID);
					String goods_name = obj.optString(Attr.GOODS_NAME);
					String goods_price = obj.optString(Attr.GOODS_PRICE);
					String goods_image_url = obj.optString(Attr.GOODS_IMAGE_URL);
					CommendList bean =new CommendList(goods_id, goods_name, goods_price, goods_image_url);
					commendlist.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return commendlist;
		}

		public String getGoods_id() {
			return goods_id;
		}

		public void setGoods_id(String goods_id) {
			this.goods_id = goods_id;
		}

		public String getGoods_name() {
			return goods_name;
		}

		public void setGoods_name(String goods_name) {
			this.goods_name = goods_name;
		}

		public String getGoods_price() {
			return goods_price;
		}

		public void setGoods_price(String goods_price) {
			this.goods_price = goods_price;
		}

		public String getGoods_image_url() {
			return goods_image_url;
		}

		public void setGoods_image_url(String goods_image_url) {
			this.goods_image_url = goods_image_url;
		}

		@Override
		public String toString() {
			return "CommendList [goods_id=" + goods_id + ", goods_name="
					+ goods_name + ", goods_price=" + goods_price
					+ ", goods_image_url=" + goods_image_url + "]";
		}
}
