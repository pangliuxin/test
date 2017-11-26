/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:AddressDetails.java
 */
package net.travel.android.model;

import net.travel.android.model.AddressList.Attr;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class OrderGroupList {
		public static class Attr{
			public static final String ORDER_LIST = "order_list";
			public static final String PAY_AMOUNT = "pay_amount";
			public static final String ADD_TIME = "add_time";
		}
		
		private String order_list;
		private String pay_amount;
		private String add_time;
		
		public OrderGroupList() {
		}

		
		public OrderGroupList(String order_list, String pay_amount,
				String add_time) {
			super();
			this.order_list = order_list;
			this.pay_amount = pay_amount;
			this.add_time = add_time;
		}


		public static OrderGroupList  newInstanceList(String json){
			OrderGroupList bean = null;
			try {
				JSONObject obj = new JSONObject(json);
				if(obj.length()> 0){
					String order_list = obj.optString(Attr.ORDER_LIST);
					String pay_amount = obj.optString(Attr.PAY_AMOUNT);
					String add_time = obj.optString(Attr.ADD_TIME);
					 bean = new OrderGroupList(order_list, pay_amount, add_time);
					System.out.println("bean-->"+bean.toString());
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return bean;
		}

		public String getOrder_list() {
			return order_list;
		}

		public void setOrder_list(String order_list) {
			this.order_list = order_list;
		}

		public String getPay_amount() {
			return pay_amount;
		}

		public void setPay_amount(String pay_amount) {
			this.pay_amount = pay_amount;
		}

		public String getAdd_time() {
			return add_time;
		}

		public void setAdd_time(String add_time) {
			this.add_time = add_time;
		}

		@Override
		public String toString() {
			return "OrderGroupList [order_list=" + order_list + ", pay_amount="
					+ pay_amount + ", add_time=" + add_time + "]";
		}

}
