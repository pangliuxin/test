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
public class OrderList {
		public static class Attr{
			public static final String ORDER_ID = "order_id";
			public static final String ORDER_SN = "order_sn";
			public static final String ORDER_STATE = "order_state";
			public static final String STORE_NAME = "store_name";//店铺名称
			public static final String STATE_DESC = "state_desc";
			public static final String ORDER_AMOUNT = "order_amount"; //订单总价
			public static final String EXTEND_ORDER_GOODS = "extend_order_goods";
			public static final String PAYMENT_NAME = "payment_name";
			public static final String SHIPPING_FEE = "shipping_fee";
			public static final String IF_CANCEL = "if_cancel";
			public static final String IF_RECEIVE = "if_receive";
			public static final String IF_LOCK = "if_lock";
			public static final String IF_DELIVER = "if_deliver";
			public static final String IF_EVALUATION = "if_evaluation";//是否评价
		}
		private String order_id;
		private String order_sn;
		private String order_state;
		private String store_name;
		private String state_desc;
		private String order_amount;
		private String extend_order_goods;
		private String payment_name;
		private String shipping_fee;
		private String if_cancel;
		private String if_receive;
		private String if_lock;
		private String if_deliver;
		private String if_evaluation;
		
	


		public OrderList() {
		}


		public OrderList(String order_id, String order_sn, String order_state,
				String store_name, String state_desc, String order_amount,
				String extend_order_goods, String payment_name,
				String shipping_fee, String if_cancel, String if_receive,
				String if_lock, String if_deliver,String if_evaluation) {
			super();
			this.order_id = order_id;
			this.order_sn = order_sn;
			this.order_state = order_state;
			this.store_name = store_name;
			this.state_desc = state_desc;
			this.order_amount = order_amount;
			this.extend_order_goods = extend_order_goods;
			this.payment_name = payment_name;
			this.shipping_fee = shipping_fee;
			this.if_cancel = if_cancel;
			this.if_receive = if_receive;
			this.if_lock = if_lock;
			this.if_deliver = if_deliver;
			this.if_evaluation = if_evaluation;
		}


		public static ArrayList<OrderList> newInstanceList(String jsonDatas){
			ArrayList<OrderList> AdvertDatas = new ArrayList<OrderList>();
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					 String order_id=obj.optString(Attr.ORDER_ID);
					 String order_sn=obj.optString(Attr.ORDER_SN);
					 String order_state=obj.optString(Attr.ORDER_STATE);
					 String store_name=obj.optString(Attr.STORE_NAME);
					 String state_desc=obj.optString(Attr.STATE_DESC);
					 String order_amount=obj.optString(Attr.ORDER_AMOUNT);
					 String extend_order_goods=obj.optString(Attr.EXTEND_ORDER_GOODS);
					 String payment_name=obj.optString(Attr.PAYMENT_NAME);
					 String shipping_fee=obj.optString(Attr.SHIPPING_FEE);
					 String if_cancel=obj.optString(Attr.IF_CANCEL);
					 String if_receive=obj.optString(Attr.IF_RECEIVE);
					 String if_lock=obj.optString(Attr.IF_LOCK);
					 String if_deliver=obj.optString(Attr.IF_DELIVER);
					 String if_evaluation = obj.optString(Attr.IF_EVALUATION);
					AdvertDatas.add(new OrderList(order_id, order_sn, order_state, store_name, state_desc, order_amount, extend_order_goods,
							payment_name, shipping_fee, if_cancel, if_receive, if_lock, if_deliver,if_evaluation));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}

		public String getOrder_id() {
			return order_id;
		}

		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}

		public String getOrder_sn() {
			return order_sn;
		}

		public void setOrder_sn(String order_sn) {
			this.order_sn = order_sn;
		}

		public String getOrder_state() {
			return order_state;
		}

		public void setOrder_state(String order_state) {
			this.order_state = order_state;
		}

		public String getStore_name() {
			return store_name;
		}

		public void setStore_name(String store_name) {
			this.store_name = store_name;
		}

		public String getState_desc() {
			return state_desc;
		}

		public void setState_desc(String state_desc) {
			this.state_desc = state_desc;
		}

		public String getOrder_amount() {
			return order_amount;
		}

		public void setOrder_amount(String order_amount) {
			this.order_amount = order_amount;
		}

		public String getExtend_order_goods() {
			return extend_order_goods;
		}

		public void setExtend_order_goods(String extend_order_goods) {
			this.extend_order_goods = extend_order_goods;
		}

		public String getPayment_name() {
			return payment_name;
		}

		public void setPayment_name(String payment_name) {
			this.payment_name = payment_name;
		}

		public String getShipping_fee() {
			return shipping_fee;
		}

		public void setShipping_fee(String shipping_fee) {
			this.shipping_fee = shipping_fee;
		}

		public String getIf_cancel() {
			return if_cancel;
		}

		public void setIf_cancel(String if_cancel) {
			this.if_cancel = if_cancel;
		}

		public String getIf_receive() {
			return if_receive;
		}

		public void setIf_receive(String if_receive) {
			this.if_receive = if_receive;
		}

		public String getIf_lock() {
			return if_lock;
		}

		public void setIf_lock(String if_lock) {
			this.if_lock = if_lock;
		}

		public String getIf_deliver() {
			return if_deliver;
		}

		public void setIf_deliver(String if_deliver) {
			this.if_deliver = if_deliver;
		}
		
		public String getIf_evaluation() {
			return if_evaluation;
		}


		public void setIf_evaluation(String if_evaluation) {
			this.if_evaluation = if_evaluation;
		}

		@Override
		public String toString() {
			return "OrderList [order_id=" + order_id + ", order_sn=" + order_sn
					+ ", order_state=" + order_state + ", store_name="
					+ store_name + ", state_desc=" + state_desc
					+ ", order_amount=" + order_amount
					+ ", extend_order_goods=" + extend_order_goods
					+ ", payment_name=" + payment_name + ", shipping_fee="
					+ shipping_fee + ", if_cancel=" + if_cancel
					+ ", if_receive=" + if_receive + ", if_lock=" + if_lock
					+ ", if_deliver=" + if_deliver 
					+ ", if_evaluation=" + if_evaluation 
					+ "]";
		}
}
