/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:GoodsDetails.java
 */
package net.travel.android.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class GoodsDetails {
		public static class Attr{
			public static final String GOODS_NAME = "goods_name";
			public static final String GOODS_JINGLE = "goods_jingle";
			public static final String SPEC_NAME = "spec_name";
			public static final String SPEC_VALUE = "spec_value";
			public static final String GOODS_ATTR = "goods_attr";
			public static final String GOODS_SPECNAME = "goods_specname";
			public static final String GOODS_PRICE = "goods_price";
			public static final String GOODS_MARKETPRICE = "goods_marketprice";
			public static final String GOODS_COSTPRICE = "goods_costprice";
			public static final String GOODS_DISCOUNT = "goods_discount";
			public static final String GOODS_SERIAL = "goods_serial";
			public static final String TRANSPORT_ID = "transport_id";
			public static final String TRANSPORT_TITLE = "transport_title";
			public static final String GOODS_FREIGHT = "goods_freight";
			public static final String GOODS_VAT = "goods_vat";
			public static final String AREAID_1 = "areaid_1";
			public static final String AREAID_2 = "areaid_2";
			public static final String GOODS_STCIDS = "goods_stcids";
			public static final String PLATEID_TOP = "plateid_top";
			public static final String PLATEID_BOTTOM = "plateid_bottom";
			public static final String GOODS_ID = "goods_id";
			public static final String GOODS_CLICK = "goods_click";
			public static final String GOODS_COLLECT = "goods_collect";
			public static final String GOODS_SALENUM = "goods_salenum";
			public static final String GOODS_SPEC = "goods_spec";
			public static final String GOODS_STORAGE = "goods_storage";
			public static final String COLOR_ID = "color_id";
			public static final String EVALUATION_GOOD_STAR = "evaluation_good_star";
			public static final String EVALUATION_COUNT = "evaluation_count";
			public static final String PROMOTION_TYPE="promotion_type"; //促销类型 groupbuy-团购 xianshi-限时折扣
			public static final String PROMOTION_PRICE="promotion_price"; //促销价格
			public static final String UPPER_LIMIT="upper_limit"; // 最多购买数 goods_isBuy
			public static final String GOODS_DEFAULT_BUYNUM="goods_default_buynum";
			public static final String GOODS_ISBUY="goods_isBuy";
			public static final String GOODS_PTS_CART="goods_pts_cart";
			public static String getGoodsPtsCart() {
				return GOODS_PTS_CART;
			}
			
		}
		
		private String goods_name;
		private String goods_jingle;
		private String spec_name;
		private String spec_value;
		private String goods_attr ;
		private String goods_specname ;
		private String goods_price ;
		private String goods_marketprice ;
		private String goods_costprice ;
		private String goods_discount ;
		private String goods_serial ;
		private String transport_id ;
		private String transport_title ;
		private String goods_freight ;
		private String goods_vat ;
		private String areaid_1 ;
		private String areaid_2 ;
		private String goods_stcids ;
		private String plateid_top ;
		private String plateid_bottom ;
		private String goods_id ;
		private String goods_click ;
		private String goods_collect ;
		private String goods_salenum ;
		private String goods_spec ;
		private String goods_storage ;
		private String color_id ;
		private String evaluation_good_star ;
		private String evaluation_count ;
		private String promotion_type;
		private String promotion_price; //促销价格
		private String upper_limit; // 最多购买数
		private String goods_default_buynum;
		private String goods_isBuy;
		private String goods_pts_cart;
		


		public String getGoods_pts_cart() {
			return goods_pts_cart;
		}





		public void setGoods_pts_cart(String goods_pts_cart) {
			this.goods_pts_cart = goods_pts_cart;
		}





		public GoodsDetails() {
		}
		









		public GoodsDetails(String goods_name, String goods_jingle,
				String spec_name, String spec_value, String goods_attr,
				String goods_specname, String goods_price,
				String goods_marketprice, String goods_costprice,
				String goods_discount, String goods_serial,
				String transport_id, String transport_title,
				String goods_freight, String goods_vat, String areaid_1,
				String areaid_2, String goods_stcids, String plateid_top,
				String plateid_bottom, String goods_id, String goods_click,
				String goods_collect, String goods_salenum, String goods_spec,
				String goods_storage, String color_id,
				String evaluation_good_star, String evaluation_count,
				String promotion_type, String promotion_price,
				String upper_limit, String goods_default_buynum,
				String goods_isBuy, String goods_pts_cart) {
			super();
			this.goods_name = goods_name;
			this.goods_jingle = goods_jingle;
			this.spec_name = spec_name;
			this.spec_value = spec_value;
			this.goods_attr = goods_attr;
			this.goods_specname = goods_specname;
			this.goods_price = goods_price;
			this.goods_marketprice = goods_marketprice;
			this.goods_costprice = goods_costprice;
			this.goods_discount = goods_discount;
			this.goods_serial = goods_serial;
			this.transport_id = transport_id;
			this.transport_title = transport_title;
			this.goods_freight = goods_freight;
			this.goods_vat = goods_vat;
			this.areaid_1 = areaid_1;
			this.areaid_2 = areaid_2;
			this.goods_stcids = goods_stcids;
			this.plateid_top = plateid_top;
			this.plateid_bottom = plateid_bottom;
			this.goods_id = goods_id;
			this.goods_click = goods_click;
			this.goods_collect = goods_collect;
			this.goods_salenum = goods_salenum;
			this.goods_spec = goods_spec;
			this.goods_storage = goods_storage;
			this.color_id = color_id;
			this.evaluation_good_star = evaluation_good_star;
			this.evaluation_count = evaluation_count;
			this.promotion_type = promotion_type;
			this.promotion_price = promotion_price;
			this.upper_limit = upper_limit;
			this.goods_default_buynum = goods_default_buynum;
			this.goods_isBuy = goods_isBuy;
			this.goods_pts_cart = goods_pts_cart;
		}





		public static GoodsDetails  newInstanceList(String json){
			GoodsDetails bean = null;
			try {
				JSONObject obj = new JSONObject(json);
				if(obj.length()> 0){
					 String goods_name = obj.optString(Attr.GOODS_NAME);
					 String goods_jingle = obj.optString(Attr.GOODS_JINGLE);
					 String spec_name = obj.optString(Attr.SPEC_NAME);
					 String spec_value = obj.optString(Attr.SPEC_VALUE);
					 String goods_attr  = obj.optString(Attr.GOODS_ATTR);
					 String goods_specname  = obj.optString(Attr.GOODS_SPECNAME);
					 String goods_price  = obj.optString(Attr.GOODS_PRICE);
					 String goods_marketprice  = obj.optString(Attr.GOODS_MARKETPRICE);
					 String goods_costprice  = obj.optString(Attr.GOODS_COSTPRICE);
					 String goods_discount  = obj.optString(Attr.GOODS_DISCOUNT);
					 String goods_serial  = obj.optString(Attr.GOODS_SERIAL);
					 String transport_id  = obj.optString(Attr.TRANSPORT_ID);
					 String transport_title  = obj.optString(Attr.TRANSPORT_TITLE);
					 String goods_freight  = obj.optString(Attr.GOODS_FREIGHT);
					 String goods_vat  = obj.optString(Attr.GOODS_VAT);
					 String areaid_1  = obj.optString(Attr.AREAID_1);
					 String areaid_2  = obj.optString(Attr.AREAID_2);
					 String goods_stcids  = obj.optString(Attr.GOODS_STCIDS);
					 String plateid_top  = obj.optString(Attr.PLATEID_TOP);
					 String plateid_bottom  = obj.optString(Attr.PLATEID_BOTTOM);
					 String goods_id  = obj.optString(Attr.GOODS_ID);
					 String goods_click  = obj.optString(Attr.GOODS_CLICK);
					 String goods_collect  = obj.optString(Attr.GOODS_COLLECT);
					 String goods_salenum  = obj.optString(Attr.GOODS_SALENUM);
					 String goods_spec  = obj.optString(Attr.GOODS_SPEC);
					 String goods_storage  = obj.optString(Attr.GOODS_STORAGE);
					 String color_id  = obj.optString(Attr.COLOR_ID);
					 String evaluation_good_star  = obj.optString(Attr.EVALUATION_GOOD_STAR);
					 String evaluation_count  = obj.optString(Attr.EVALUATION_COUNT);
					 String promotion_type  = obj.optString(Attr.PROMOTION_TYPE);;
					 String promotion_price  = obj.optString(Attr.PROMOTION_PRICE);; //促销价格
					 String upper_limit  = obj.optString(Attr.UPPER_LIMIT);; // 最多购买数
					 String goods_default_buynum = obj.optString(Attr.GOODS_DEFAULT_BUYNUM);
					 String goods_isBuy = obj.optString(Attr.GOODS_ISBUY);
					 String goods_pts_cart = obj.optString(Attr.GOODS_PTS_CART);
					 bean = new GoodsDetails(goods_name, goods_jingle, spec_name, spec_value, goods_attr, goods_specname, goods_price, goods_marketprice, goods_costprice, goods_discount, goods_serial, transport_id, transport_title, goods_freight, goods_vat, areaid_1, areaid_2, goods_stcids, plateid_top, plateid_bottom, goods_id, goods_click, goods_collect, goods_salenum, goods_spec, goods_storage, color_id, evaluation_good_star, evaluation_count, promotion_type, promotion_price, upper_limit, goods_default_buynum,goods_isBuy,goods_pts_cart);
					 //System.out.println("bean-->"+bean.toString());
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return bean;
		}



		public String getPromotion_type() {
			return promotion_type;
		}


		public void setPromotion_type(String promotion_type) {
			this.promotion_type = promotion_type;
		}


		public String getPromotion_price() {
			return promotion_price;
		}
		public String getGoods_isBuy() {
			return goods_isBuy;
		}


		public void setGoods_isBuy(String goods_isBuy) {
			this.goods_isBuy = goods_isBuy;
		}


		public void setPromotion_price(String promotion_price) {
			this.promotion_price = promotion_price;
		}


		public String getUpper_limit() {
			return upper_limit;
		}


		public void setUpper_limit(String upper_limit) {
			this.upper_limit = upper_limit;
		}
		
		public String getGoods_default_buynum() {
		    return goods_default_buynum;
		}
		
		public void setGoods_default_buynum(String goods_default_buynum) {
		    this.goods_default_buynum = goods_default_buynum;
		}


		public String getGoods_name() {
			return goods_name;
		}


		public void setGoods_name(String goods_name) {
			this.goods_name = goods_name;
		}


		public String getGoods_jingle() {
			return goods_jingle;
		}


		public void setGoods_jingle(String goods_jingle) {
			this.goods_jingle = goods_jingle;
		}


		public String getSpec_name() {
			return spec_name;
		}


		public void setSpec_name(String spec_name) {
			this.spec_name = spec_name;
		}


		public String getSpec_value() {
			return spec_value;
		}


		public void setSpec_value(String spec_value) {
			this.spec_value = spec_value;
		}


		public String getGoods_attr() {
			return goods_attr;
		}


		public void setGoods_attr(String goods_attr) {
			this.goods_attr = goods_attr;
		}


		public String getGoods_specname() {
			return goods_specname;
		}


		public void setGoods_specname(String goods_specname) {
			this.goods_specname = goods_specname;
		}


		public String getGoods_price() {
			return goods_price;
		}


		public void setGoods_price(String goods_price) {
			this.goods_price = goods_price;
		}


		public String getGoods_marketprice() {
			return goods_marketprice;
		}


		public void setGoods_marketprice(String goods_marketprice) {
			this.goods_marketprice = goods_marketprice;
		}


		public String getGoods_costprice() {
			return goods_costprice;
		}


		public void setGoods_costprice(String goods_costprice) {
			this.goods_costprice = goods_costprice;
		}


		public String getGoods_discount() {
			return goods_discount;
		}


		public void setGoods_discount(String goods_discount) {
			this.goods_discount = goods_discount;
		}


		public String getGoods_serial() {
			return goods_serial;
		}


		public void setGoods_serial(String goods_serial) {
			this.goods_serial = goods_serial;
		}


		public String getTransport_id() {
			return transport_id;
		}


		public void setTransport_id(String transport_id) {
			this.transport_id = transport_id;
		}


		public String getTransport_title() {
			return transport_title;
		}


		public void setTransport_title(String transport_title) {
			this.transport_title = transport_title;
		}

		public String getGoods_freight() {
			return goods_freight;
		}


		public void setGoods_freight(String goods_freight) {
			this.goods_freight = goods_freight;
		}


		public String getGoods_vat() {
			return goods_vat;
		}


		public void setGoods_vat(String goods_vat) {
			this.goods_vat = goods_vat;
		}


		public String getAreaid_1() {
			return areaid_1;
		}


		public void setAreaid_1(String areaid_1) {
			this.areaid_1 = areaid_1;
		}


		public String getAreaid_2() {
			return areaid_2;
		}


		public void setAreaid_2(String areaid_2) {
			this.areaid_2 = areaid_2;
		}


		public String getGoods_stcids() {
			return goods_stcids;
		}


		public void setGoods_stcids(String goods_stcids) {
			this.goods_stcids = goods_stcids;
		}


		public String getPlateid_top() {
			return plateid_top;
		}


		public void setPlateid_top(String plateid_top) {
			this.plateid_top = plateid_top;
		}


		public String getPlateid_bottom() {
			return plateid_bottom;
		}


		public void setPlateid_bottom(String plateid_bottom) {
			this.plateid_bottom = plateid_bottom;
		}


		public String getGoods_id() {
			return goods_id;
		}


		public void setGoods_id(String goods_id) {
			this.goods_id = goods_id;
		}


		public String getGoods_click() {
			return goods_click;
		}


		public void setGoods_click(String goods_click) {
			this.goods_click = goods_click;
		}


		public String getGoods_collect() {
			return goods_collect;
		}


		public void setGoods_collect(String goods_collect) {
			this.goods_collect = goods_collect;
		}


		public String getGoods_salenum() {
			return goods_salenum;
		}


		public void setGoods_salenum(String goods_salenum) {
			this.goods_salenum = goods_salenum;
		}


		public String getGoods_spec() {
			return goods_spec;
		}


		public void setGoods_spec(String goods_spec) {
			this.goods_spec = goods_spec;
		}


		public String getGoods_storage() {
			return goods_storage;
		}


		public void setGoods_storage(String goods_storage) {
			this.goods_storage = goods_storage;
		}


		public String getColor_id() {
			return color_id;
		}


		public void setColor_id(String color_id) {
			this.color_id = color_id;
		}


		public String getEvaluation_good_star() {
			return evaluation_good_star;
		}


		public void setEvaluation_good_star(String evaluation_good_star) {
			this.evaluation_good_star = evaluation_good_star;
		}


		public String getEvaluation_count() {
			return evaluation_count;
		}


		public void setEvaluation_count(String evaluation_count) {
			this.evaluation_count = evaluation_count;
		}


		@Override
		public String toString() {
			return "GoodsDetails [goods_name=" + goods_name + ", goods_jingle="
					+ goods_jingle + ", spec_name=" + spec_name
					+ ", spec_value=" + spec_value + ", goods_attr="
					+ goods_attr + ", goods_specname=" + goods_specname
					+ ", goods_price=" + goods_price + ", goods_marketprice="
					+ goods_marketprice + ", goods_costprice="
					+ goods_costprice + ", goods_discount=" + goods_discount
					+ ", goods_serial=" + goods_serial + ", transport_id="
					+ transport_id + ", transport_title=" + transport_title
					+ ", goods_freight=" + goods_freight + ", goods_vat="
					+ goods_vat + ", areaid_1=" + areaid_1 + ", areaid_2="
					+ areaid_2 + ", goods_stcids=" + goods_stcids
					+ ", plateid_top=" + plateid_top + ", plateid_bottom="
					+ plateid_bottom + ", goods_id=" + goods_id
					+ ", goods_click=" + goods_click + ", goods_collect="
					+ goods_collect + ", goods_salenum=" + goods_salenum
					+ ", goods_spec=" + goods_spec + ", goods_storage="
					+ goods_storage + ", color_id=" + color_id
					+ ", evaluation_good_star=" + evaluation_good_star
					+ ", evaluation_count=" + evaluation_count
					+ ", promotion_type=" + promotion_type
					+ ", promotion_price=" + promotion_price + ", upper_limit="
					+ upper_limit + ", goods_default_buynum=" + goods_default_buynum
					+ ", goods_isBuy=" + goods_isBuy
					+ "]";
		}

}
