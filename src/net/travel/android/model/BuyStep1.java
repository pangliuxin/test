/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:BuyStep1.java
 */
package net.travel.android.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年2月14日 下午5:09:16
 */
public class BuyStep1 {
	public static class Attr{
		public static final String STORE_CART_LIST = "store_cart_list";
		public static final String FREIGHT_HASH = "freight_hash";
		public static final String ADDRESS_INFO = "address_info";
		public static final String IFSHOW_OFFPAY = "ifshow_offpay";
		public static final String VAT_HASH = "vat_hash";
		public static final String INV_INFO = "inv_info";
		public static final String AVAILABLE_PREDEPOSIT = "available_predeposit";
	}
	
	private String store_cart_list;
	private String freight_hash;
	private String address_info;
	private String ifshow_offpay;
	private String vat_hash;
	private String inv_info;
	private String available_predeposit;
	
	public BuyStep1() {
	}

	public BuyStep1(String store_cart_list, String freight_hash,
			String address_info, String ifshow_offpay, String vat_hash,
			String inv_info, String available_predeposit) {
		super();
		this.store_cart_list = store_cart_list;
		this.freight_hash = freight_hash;
		this.address_info = address_info;
		this.ifshow_offpay = ifshow_offpay;
		this.vat_hash = vat_hash;
		this.inv_info = inv_info;
		this.available_predeposit = available_predeposit;
	}

	public static BuyStep1  newInstanceList(String json){
		BuyStep1 bean = null;
		try {
			JSONObject obj = new JSONObject(json);
			if(obj.length()> 0){
				String store_cart_list = obj.optString(Attr.STORE_CART_LIST);
				String freight_hash = obj.optString(Attr.FREIGHT_HASH);
				String address_info = obj.optString(Attr.ADDRESS_INFO);
				String ifshow_offpay = obj.optString(Attr.IFSHOW_OFFPAY);
				String vat_hash = obj.optString(Attr.VAT_HASH);
				String inv_info = obj.optString(Attr.INV_INFO);
				String available_predeposit = obj.optString(Attr.AVAILABLE_PREDEPOSIT);
				 bean = new BuyStep1(store_cart_list, freight_hash, address_info, ifshow_offpay, 
						 vat_hash, inv_info, available_predeposit);
				System.out.println("bean-->"+bean.toString());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return bean;
	}

	public String getStore_cart_list() {
		return store_cart_list;
	}

	public void setStore_cart_list(String store_cart_list) {
		this.store_cart_list = store_cart_list;
	}

	public String getFreight_hash() {
		return freight_hash;
	}

	public void setFreight_hash(String freight_hash) {
		this.freight_hash = freight_hash;
	}

	public String getAddress_info() {
		return address_info;
	}

	public void setAddress_info(String address_info) {
		this.address_info = address_info;
	}

	public String getIfshow_offpay() {
		return ifshow_offpay;
	}

	public void setIfshow_offpay(String ifshow_offpay) {
		this.ifshow_offpay = ifshow_offpay;
	}

	public String getVat_hash() {
		return vat_hash;
	}

	public void setVat_hash(String vat_hash) {
		this.vat_hash = vat_hash;
	}

	public String getInv_info() {
		return inv_info;
	}

	public void setInv_info(String inv_info) {
		this.inv_info = inv_info;
	}

	public String getAvailable_predeposit() {
		return available_predeposit;
	}

	public void setAvailable_predeposit(String available_predeposit) {
		this.available_predeposit = available_predeposit;
	}

	@Override
	public String toString() {
		return "BuyStep1 [store_cart_list=" + store_cart_list
				+ ", freight_hash=" + freight_hash + ", address_info="
				+ address_info + ", ifshow_offpay=" + ifshow_offpay
				+ ", vat_hash=" + vat_hash + ", inv_info=" + inv_info
				+ ", available_predeposit=" + available_predeposit + "]";
	}
}
