/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:AddressList.java
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
public class AddressList {
		public static class Attr{
			public static final String AREA_INFO = "area_info";
			public static final String ADDRESS = "address";
			public static final String TEL_PHONE = "tel_phone";
			public static final String MOB_PHONE = "mob_phone";
			public static final String AREA_ID = "area_id";
			public static final String CITY_ID = "city_id";
			public static final String ADDRESS_ID = "address_id";
			public static final String MEMBER_ID = "member_id";
			public static final String TRUE_NAME = "true_name";
		}
		private String area_info;
		private String address;
		private String tel_phone;
		private String mob_phone;
		private String area_id;
		private String city_id;
		private String address_id;
		private String member_id;
		private String true_name;
		
		public AddressList() {
		}
		

		public AddressList(String area_info, String address, String tel_phone,
				String mob_phone, String area_id, String city_id,
				String address_id, String member_id, String true_name) {
			super();
			this.area_info = area_info;
			this.address = address;
			this.tel_phone = tel_phone;
			this.mob_phone = mob_phone;
			this.area_id = area_id;
			this.city_id = city_id;
			this.address_id = address_id;
			this.member_id = member_id;
			this.true_name = true_name;
		}


		public static ArrayList<AddressList> newInstanceList(String jsonDatas){
			ArrayList<AddressList> AdvertDatas = new ArrayList<AddressList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String area_info = obj.optString(Attr.AREA_INFO);
					String address = obj.optString(Attr.ADDRESS);
					String tel_phone = obj.optString(Attr.TEL_PHONE);
					String mob_phone = obj.optString(Attr.MOB_PHONE);
					String area_id = obj.optString(Attr.AREA_ID);
					String city_id = obj.optString(Attr.CITY_ID);
					String address_id = obj.optString(Attr.ADDRESS_ID);
					String member_id = obj.optString(Attr.MEMBER_ID);
					String true_name = obj.optString(Attr.TRUE_NAME);
					AdvertDatas.add(new AddressList(area_info, address, tel_phone, mob_phone, area_id, 
							city_id, address_id, member_id,true_name));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}

		public String getArea_info() {
			return area_info;
		}

		public void setArea_info(String area_info) {
			this.area_info = area_info;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getTel_phone() {
			return tel_phone;
		}

		public void setTel_phone(String tel_phone) {
			this.tel_phone = tel_phone;
		}

		public String getMob_phone() {
			return mob_phone;
		}

		public void setMob_phone(String mob_phone) {
			this.mob_phone = mob_phone;
		}

		public String getArea_id() {
			return area_id;
		}

		public void setArea_id(String area_id) {
			this.area_id = area_id;
		}

		public String getCity_id() {
			return city_id;
		}

		public void setCity_id(String city_id) {
			this.city_id = city_id;
		}

		public String getAddress_id() {
			return address_id;
		}

		public void setAddress_id(String address_id) {
			this.address_id = address_id;
		}

		public String getMember_id() {
			return member_id;
		}

		public void setMember_id(String member_id) {
			this.member_id = member_id;
		}

		
		public String getTrue_name() {
			return true_name;
		}


		public void setTrue_name(String true_name) {
			this.true_name = true_name;
		}

		@Override
		public String toString() {
			return "AddressList [area_info=" + area_info + ", address="
					+ address + ", tel_phone=" + tel_phone + ", mob_phone="
					+ mob_phone + ", area_id=" + area_id + ", city_id="
					+ city_id + ", address_id=" + address_id + ", member_id="
					+ member_id + ", true_name=" + true_name + "]";
		}

}
