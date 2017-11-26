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
 * 
 * 
 *  
 */
public class OrderInfo {
		public static class Attr{
			public static final String DELAY_TIME = "delay_time";
			public static final String REFUND_STATE = "refund_state";
			public static final String ORDER_STATE = "order_state";
			public static final String SHIPPING_CODE = "shipping_code";
			public static final String PAY_SN = "pay_sn";
			public static final String ORDER_ID = "order_id";
			public static final String PAYMENT_TIME = "payment_time";
			public static final String PAYMENT_CODE = "payment_code";
			public static final String GOODS_AMOUNT = "goods_amount";
			public static final String STATE_DESC = "state_desc";
			public static final String ORDER_AMOUNT = "order_amount";
			public static final String BUYER_EMAIL = "buyer_email";
			public static final String EVALUATION_STATE = "evaluation_state";
			public static final String REFUND_AMOUNT = "refund_amount";
			public static final String ORDER_FROM = "order_from";
			public static final String STORE_NAME = "store_name";
			public static final String BUYER_ID = "buyer_id";
			public static final String GOODS_TRANSPORT = "goods_transport";
			public static final String ORDER_AMOUNT_EDIT = "order_amount_edit";
			public static final String STORE_ID = "store_id";
			public static final String BUYER_NAME = "buyer_name";
			public static final String LOCK_STATE = "lock_state";
			public static final String EVALUATE_ABLE = "evaluate_able";
			public static final String SHIPPING_FEE = "shipping_fee";
			public static final String PD_AMOUNT = "pd_amount";
			public static final String PAYMENT_NAME = "payment_name";
			public static final String ORDER_SN = "order_sn";
			public static final String ADD_TIME = "add_time";
			public static final String FINNSHED_TIME = "finnshed_time";
	
		}
		
		private String delay_time;
		public String getDelay_time() {
			return delay_time;
		}





		public void setDelay_time(String delay_time) {
			this.delay_time = delay_time;
		}





		public String getRefund_state() {
			return refund_state;
		}





		public OrderInfo(String delay_time, String refund_state,
				String order_state, String shipping_code, String pay_sn,
				String order_id, String payment_time, String payment_code,
				String goods_amount, String state_desc, String order_amount,
				String buyer_email, String evaluation_state,
				String refund_amount, String order_from, String store_name,
				String buyer_id, String goods_transport,
				String order_amount_edit, String store_id, String buyer_name,
				String lock_state, String evaluate_able, String shipping_fee,
				String pd_amount, String payment_name, String order_sn,
				String add_time, String finnshed_time) {
			super();
			this.delay_time = delay_time;
			this.refund_state = refund_state;
			this.order_state = order_state;
			this.shipping_code = shipping_code;
			this.pay_sn = pay_sn;
			this.order_id = order_id;
			this.payment_time = payment_time;
			this.payment_code = payment_code;
			this.goods_amount = goods_amount;
			this.state_desc = state_desc;
			this.order_amount = order_amount;
			this.buyer_email = buyer_email;
			this.evaluation_state = evaluation_state;
			this.refund_amount = refund_amount;
			this.order_from = order_from;
			this.store_name = store_name;
			this.buyer_id = buyer_id;
			this.goods_transport = goods_transport;
			this.order_amount_edit = order_amount_edit;
			this.store_id = store_id;
			this.buyer_name = buyer_name;
			this.lock_state = lock_state;
			this.evaluate_able = evaluate_able;
			this.shipping_fee = shipping_fee;
			this.pd_amount = pd_amount;
			this.payment_name = payment_name;
			this.order_sn = order_sn;
			this.add_time = add_time;
			this.finnshed_time = finnshed_time;
		}





		public void setRefund_state(String refund_state) {
			this.refund_state = refund_state;
		}





		public String getOrder_state() {
			return order_state;
		}





		public void setOrder_state(String order_state) {
			this.order_state = order_state;
		}





		public String getShipping_code() {
			return shipping_code;
		}





		public void setShipping_code(String shipping_code) {
			this.shipping_code = shipping_code;
		}





		public String getPay_sn() {
			return pay_sn;
		}





		public void setPay_sn(String pay_sn) {
			this.pay_sn = pay_sn;
		}





		public String getOrder_id() {
			return order_id;
		}





		public void setOrder_id(String order_id) {
			this.order_id = order_id;
		}





		public String getPayment_time() {
			return payment_time;
		}





		public void setPayment_time(String payment_time) {
			this.payment_time = payment_time;
		}





		public String getPayment_code() {
			return payment_code;
		}





		public void setPayment_code(String payment_code) {
			this.payment_code = payment_code;
		}





		public String getGoods_amount() {
			return goods_amount;
		}





		public void setGoods_amount(String goods_amount) {
			this.goods_amount = goods_amount;
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





		public String getBuyer_email() {
			return buyer_email;
		}





		public void setBuyer_email(String buyer_email) {
			this.buyer_email = buyer_email;
		}





		public String getEvaluation_state() {
			return evaluation_state;
		}





		public void setEvaluation_state(String evaluation_state) {
			this.evaluation_state = evaluation_state;
		}





		public String getRefund_amount() {
			return refund_amount;
		}





		public void setRefund_amount(String refund_amount) {
			this.refund_amount = refund_amount;
		}





		public String getOrder_from() {
			return order_from;
		}





		public void setOrder_from(String order_from) {
			this.order_from = order_from;
		}





		public String getStore_name() {
			return store_name;
		}





		public void setStore_name(String store_name) {
			this.store_name = store_name;
		}





		public String getBuyer_id() {
			return buyer_id;
		}





		public void setBuyer_id(String buyer_id) {
			this.buyer_id = buyer_id;
		}





		public String getGoods_transport() {
			return goods_transport;
		}





		public void setGoods_transport(String goods_transport) {
			this.goods_transport = goods_transport;
		}





		public String getOrder_amount_edit() {
			return order_amount_edit;
		}





		public void setOrder_amount_edit(String order_amount_edit) {
			this.order_amount_edit = order_amount_edit;
		}





		public String getStore_id() {
			return store_id;
		}





		public void setStore_id(String store_id) {
			this.store_id = store_id;
		}





		public String getBuyer_name() {
			return buyer_name;
		}





		public void setBuyer_name(String buyer_name) {
			this.buyer_name = buyer_name;
		}





		public String getLock_state() {
			return lock_state;
		}





		public void setLock_state(String lock_state) {
			this.lock_state = lock_state;
		}





		public String getEvaluate_able() {
			return evaluate_able;
		}





		public void setEvaluate_able(String evaluate_able) {
			this.evaluate_able = evaluate_able;
		}





		public String getShipping_fee() {
			return shipping_fee;
		}





		public void setShipping_fee(String shipping_fee) {
			this.shipping_fee = shipping_fee;
		}





		public String getPd_amount() {
			return pd_amount;
		}





		public void setPd_amount(String pd_amount) {
			this.pd_amount = pd_amount;
		}





		public String getPayment_name() {
			return payment_name;
		}





		public void setPayment_name(String payment_name) {
			this.payment_name = payment_name;
		}





		public String getOrder_sn() {
			return order_sn;
		}





		public void setOrder_sn(String order_sn) {
			this.order_sn = order_sn;
		}





		public String getAdd_time() {
			return add_time;
		}





		public void setAdd_time(String add_time) {
			this.add_time = add_time;
		}





		public String getFinnshed_time() {
			return finnshed_time;
		}





		public void setFinnshed_time(String finnshed_time) {
			this.finnshed_time = finnshed_time;
		}



		private String refund_state;
		private String order_state;
		private String shipping_code;
		private String pay_sn;
		private String order_id;
		private String payment_time;
		private String payment_code;
		private String goods_amount;
		private String state_desc;
		private String order_amount;
		private String buyer_email;
		private String evaluation_state;
		private String refund_amount;
		private String order_from;
		private String store_name;
		private String buyer_id;
		private String goods_transport;
		private String order_amount_edit;
		private String store_id;
		private String buyer_name;
		private String lock_state;
		private String evaluate_able;
		private String shipping_fee;
		private String pd_amount;
		private String payment_name;
		private String order_sn;
		private String add_time;
		private String finnshed_time;

		public OrderInfo() {
		}


	


		public static OrderInfo newInstanceList(String jsonDatas){
			
			OrderInfo order = new OrderInfo();
			try {
				
				JSONObject obj = new JSONObject(jsonDatas);
				order.setAdd_time(obj.optString(Attr.ADD_TIME));
				order.setBuyer_email(obj.optString(Attr.BUYER_EMAIL));
				order.setBuyer_id(obj.optString(Attr.BUYER_ID));
				order.setBuyer_name(obj.optString(Attr.BUYER_NAME));
				order.setDelay_time(obj.optString(Attr.DELAY_TIME));
				order.setEvaluate_able(obj.optString(Attr.EVALUATE_ABLE));
				order.setEvaluation_state(obj.optString(Attr.EVALUATION_STATE));
				order.setFinnshed_time(obj.optString(Attr.FINNSHED_TIME));
				order.setGoods_amount(obj.optString(Attr.GOODS_AMOUNT));
				order.setGoods_transport(obj.optString(Attr.GOODS_TRANSPORT));
				order.setLock_state(obj.optString(Attr.LOCK_STATE));
				order.setOrder_amount(obj.optString(Attr.ORDER_AMOUNT));
				order.setOrder_amount_edit(obj.optString(Attr.ORDER_AMOUNT_EDIT));
				order.setOrder_from(obj.optString(Attr.ORDER_FROM));
				order.setOrder_id(obj.optString(Attr.ORDER_ID));
				order.setOrder_sn(obj.optString(Attr.ORDER_SN));
				order.setOrder_state(obj.optString(Attr.ORDER_STATE));
				order.setPay_sn(obj.optString(Attr.PAY_SN));
				order.setPayment_code(obj.optString(Attr.PAYMENT_CODE));
				order.setPayment_name(obj.optString(Attr.PAYMENT_NAME));
				order.setPayment_time(obj.optString(Attr.PAYMENT_TIME));
				order.setPd_amount(obj.optString(Attr.PD_AMOUNT));
				order.setRefund_amount(obj.optString(Attr.REFUND_AMOUNT));
				order.setRefund_state(obj.optString(Attr.REFUND_STATE));
				order.setShipping_code(obj.optString(Attr.SHIPPING_CODE));
				order.setShipping_fee(obj.optString(Attr.SHIPPING_FEE));
				order.setState_desc(obj.optString(Attr.STATE_DESC));
				order.setStore_id(obj.optString(Attr.STORE_ID));
				order.setStore_name(obj.optString(Attr.STORE_NAME));

				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return order;
		}





		@Override
		public String toString() {
			return "OrderInfo [delay_time=" + delay_time + ", refund_state="
					+ refund_state + ", order_state=" + order_state
					+ ", shipping_code=" + shipping_code + ", pay_sn=" + pay_sn
					+ ", order_id=" + order_id + ", payment_time="
					+ payment_time + ", payment_code=" + payment_code
					+ ", goods_amount=" + goods_amount + ", state_desc="
					+ state_desc + ", order_amount=" + order_amount
					+ ", buyer_email=" + buyer_email + ", evaluation_state="
					+ evaluation_state + ", refund_amount=" + refund_amount
					+ ", order_from=" + order_from + ", store_name="
					+ store_name + ", buyer_id=" + buyer_id
					+ ", goods_transport=" + goods_transport
					+ ", order_amount_edit=" + order_amount_edit
					+ ", store_id=" + store_id + ", buyer_name=" + buyer_name
					+ ", lock_state=" + lock_state + ", evaluate_able="
					+ evaluate_able + ", shipping_fee=" + shipping_fee
					+ ", pd_amount=" + pd_amount + ", payment_name="
					+ payment_name + ", order_sn=" + order_sn + ", add_time="
					+ add_time + ", finnshed_time=" + finnshed_time + "]";
		}

	


}
