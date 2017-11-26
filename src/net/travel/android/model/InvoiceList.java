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
public class InvoiceList {
		public static class Attr{
			public static final String INV_ID = "inv_id";
			public static final String INV_TITLE = "inv_title";
			public static final String INV_CONTENT = "inv_content";
		}
		private String inv_id;
		private String inv_title;
		private String inv_content;
		
		public InvoiceList() {
		}

		public InvoiceList(String inv_id, String inv_title, String inv_content) {
			super();
			this.inv_id = inv_id;
			this.inv_title = inv_title;
			this.inv_content = inv_content;
		}

		public static ArrayList<InvoiceList> newInstanceList(String jsonDatas){
			ArrayList<InvoiceList> AdvertDatas = new ArrayList<InvoiceList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String inv_id = obj.optString(Attr.INV_ID);
					String inv_title = obj.optString(Attr.INV_TITLE);
					String inv_content = obj.optString(Attr.INV_CONTENT);
					AdvertDatas.add(new InvoiceList(inv_id, inv_title, inv_content));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}

		public String getInv_id() {
			return inv_id;
		}

		public void setInv_id(String inv_id) {
			this.inv_id = inv_id;
		}

		public String getInv_title() {
			return inv_title;
		}

		public void setInv_title(String inv_title) {
			this.inv_title = inv_title;
		}

		public String getInv_content() {
			return inv_content;
		}

		public void setInv_content(String inv_content) {
			this.inv_content = inv_content;
		}

		@Override
		public String toString() {
			return "InvoiceList [inv_id=" + inv_id + ", inv_title=" + inv_title
					+ ", inv_content=" + inv_content + "]";
		}

}
