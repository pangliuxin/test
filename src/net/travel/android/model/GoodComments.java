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


/**
 * 
 * 

                
              
 *
 */
public class GoodComments {
		public static class Attr{
			public static final String GEVAL_ID = "geval_id";
			public static final String GEVAL_ORDERID = "geval_orderid";
			public static final String GEVAL_ORDERNO= "geval_orderno";
			public static final String GEVAL_ORDERGOODSID= "geval_ordergoodsid";
			public static final String GEVAL_GOODSID= "geval_goodsid";
			public static final String GEVAL_GOODSNAME= "geval_goodsname";
			public static final String GEVAL_GOODSPRICE= "geval_goodsprice";
			public static final String GEVAL_SCORES= "geval_scores";
			public static final String GEVAL_CONTENT= "geval_content";
			public static final String GEVAL_ISANONYMOUS= "geval_isanonymous";
			public static final String GEVAL_ADDTIME= "geval_addtime";
			public static final String GEVAL_STOREID= "geval_storeid";
			public static final String GEVAL_STORENAME= "geval_storename";
			public static final String GEVAL_FROMMEMBERID= "geval_frommemberid";
			public static final String GEVAL_FROMMEMBERNAME= "geval_frommembername";
			public static final String GEVAL_STATE= "geval_state";
			public static final String GEVAL_REMARK= "geval_remark";
			public static final String GEVAL_EXPLAIN= "geval_explain";
			public static final String GEVAL_IMAGE= "geval_image";
		
		
		}
		// 
		//订单id
		private String geval_orderid;
		//订单编号
		private String geval_orderno;
		//订单商品表编号
		private String geval_ordergoodsid;
		//商品表编号
		private String geval_goodsid;
		//商品名称
		private String geval_goodsname;
		//商品价格
		private String geval_goodsprice;
		//评分数值
		private String geval_scores;
		//评分内容
		private String geval_content;
		//是否匿名
		private String geval_isanonymous;
		//添加时间
		private String geval_addtime;
		//店铺id
		private String geval_storeid;
		//店铺名称
		private String geval_storename;
		//
		private String geval_frommemberid;
		//会员名称
		private String geval_frommembername;
		//评价状态
		private String geval_state;
		public String getGeval_orderid() {
			return geval_orderid;
		}







		public void setGeval_orderid(String geval_orderid) {
			this.geval_orderid = geval_orderid;
		}







		public String getGeval_orderno() {
			return geval_orderno;
		}







		public void setGeval_orderno(String geval_orderno) {
			this.geval_orderno = geval_orderno;
		}







		public String getGeval_ordergoodsid() {
			return geval_ordergoodsid;
		}







		public void setGeval_ordergoodsid(String geval_ordergoodsid) {
			this.geval_ordergoodsid = geval_ordergoodsid;
		}







		public String getGeval_goodsid() {
			return geval_goodsid;
		}







		public void setGeval_goodsid(String geval_goodsid) {
			this.geval_goodsid = geval_goodsid;
		}







		public String getGeval_goodsname() {
			return geval_goodsname;
		}







		public void setGeval_goodsname(String geval_goodsname) {
			this.geval_goodsname = geval_goodsname;
		}







		public String getGeval_goodsprice() {
			return geval_goodsprice;
		}







		public void setGeval_goodsprice(String geval_goodsprice) {
			this.geval_goodsprice = geval_goodsprice;
		}







		public String getGeval_scores() {
			return geval_scores;
		}







		public void setGeval_scores(String geval_scores) {
			this.geval_scores = geval_scores;
		}







		public String getGeval_content() {
			return geval_content;
		}







		public void setGeval_content(String geval_content) {
			this.geval_content = geval_content;
		}







		public String getGeval_isanonymous() {
			return geval_isanonymous;
		}







		public void setGeval_isanonymous(String geval_isanonymous) {
			this.geval_isanonymous = geval_isanonymous;
		}







		public String getGeval_addtime() {
			return geval_addtime;
		}







		public void setGeval_addtime(String geval_addtime) {
			this.geval_addtime = geval_addtime;
		}







		public String getGeval_storeid() {
			return geval_storeid;
		}







		public void setGeval_storeid(String geval_storeid) {
			this.geval_storeid = geval_storeid;
		}







		public String getGeval_storename() {
			return geval_storename;
		}







		public void setGeval_storename(String geval_storename) {
			this.geval_storename = geval_storename;
		}







		public String getGeval_frommemberid() {
			return geval_frommemberid;
		}







		public void setGeval_frommemberid(String geval_frommemberid) {
			this.geval_frommemberid = geval_frommemberid;
		}







		public String getGeval_frommembername() {
			return geval_frommembername;
		}







		public void setGeval_frommembername(String geval_frommembername) {
			this.geval_frommembername = geval_frommembername;
		}







		public String getGeval_state() {
			return geval_state;
		}







		public void setGeval_state(String geval_state) {
			this.geval_state = geval_state;
		}







		public String getGeval_remark() {
			return geval_remark;
		}







		public void setGeval_remark(String geval_remark) {
			this.geval_remark = geval_remark;
		}







		public String getGeval_explain() {
			return geval_explain;
		}







		public void setGeval_explain(String geval_explain) {
			this.geval_explain = geval_explain;
		}







		public String getGeval_image() {
			return geval_image;
		}







		public void setGeval_image(String geval_image) {
			this.geval_image = geval_image;
		}









		//
		private String geval_remark;
		//
		private String geval_explain;
		//
		private String geval_image;
		
	
		
		public GoodComments() {
		}

		
		
	
		public GoodComments(String geval_orderid, String geval_orderno,
				String geval_ordergoodsid, String geval_goodsid,
				String geval_goodsname, String geval_goodsprice,
				String geval_scores, String geval_content,
				String geval_isanonymous, String geval_addtime,
				String geval_storeid, String geval_storename,
				String geval_frommemberid, String geval_frommembername,
				String geval_state, String geval_remark, String geval_explain,
				String geval_image) {
			super();
			this.geval_orderid = geval_orderid;
			this.geval_orderno = geval_orderno;
			this.geval_ordergoodsid = geval_ordergoodsid;
			this.geval_goodsid = geval_goodsid;
			this.geval_goodsname = geval_goodsname;
			this.geval_goodsprice = geval_goodsprice;
			this.geval_scores = geval_scores;
			this.geval_content = geval_content;
			this.geval_isanonymous = geval_isanonymous;
			this.geval_addtime = geval_addtime;
			this.geval_storeid = geval_storeid;
			this.geval_storename = geval_storename;
			this.geval_frommemberid = geval_frommemberid;
			this.geval_frommembername = geval_frommembername;
			this.geval_state = geval_state;
			this.geval_remark = geval_remark;
			this.geval_explain = geval_explain;
			this.geval_image = geval_image;
		}







		/**
		 * 
		 * 
		        "geval_id": "597",
                "geval_orderid": "4406",
                "geval_orderno": "6000000000448701",
                "geval_ordergoodsid": "6902",
                "geval_goodsid": "4343",
                "geval_goodsname": "蜜桔 新鲜水果 桔子 斤 散装",
                "geval_goodsprice": "1.28",
                "geval_scores": "5",
                "geval_content": "不错哦",
                "geval_isanonymous": "1",
                "geval_addtime": "1417516093",
                "geval_storeid": "16",
                "geval_storename": "网上菜篮子",
                "geval_frommemberid": "18849",
                "geval_frommembername": "zsg",
                "geval_state": "0",
                "geval_remark": null,
                "geval_explain": null,
                "geval_image": null
		
		 */


		public static ArrayList<GoodComments> newInstanceList(String jsonDatas){
			ArrayList<GoodComments> AdvertDatas = new ArrayList<GoodComments>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					
					// 
				     String geval_orderid = obj.optString(Attr.GEVAL_ORDERID);
					 String geval_orderno = obj.optString(Attr.GEVAL_ORDERNO);
					 String geval_ordergoodsid = obj.optString(Attr.GEVAL_ORDERGOODSID);
					 String geval_goodsid = obj.optString(Attr.GEVAL_GOODSID);
					 String geval_goodsname = obj.optString(Attr.GEVAL_GOODSNAME);
					 String geval_goodsprice = obj.optString(Attr.GEVAL_GOODSPRICE);
					 String geval_scores = obj.optString(Attr.GEVAL_SCORES);
					 String geval_content = obj.optString(Attr.GEVAL_CONTENT);
					 String geval_isanonymous = obj.optString(Attr.GEVAL_ISANONYMOUS);
					 String geval_addtime = obj.optString(Attr.GEVAL_ADDTIME);
					 String geval_storeid = obj.optString(Attr.GEVAL_STOREID);
					 String geval_storename = obj.optString(Attr.GEVAL_STORENAME);
					 String geval_frommemberid = obj.optString(Attr.GEVAL_FROMMEMBERID);
					 String geval_frommembername = obj.optString(Attr.GEVAL_FROMMEMBERNAME);
					 String geval_state = obj.optString(Attr.GEVAL_STATE);
					 String geval_remark = obj.optString(Attr.GEVAL_REMARK);
					 String geval_explain = obj.optString(Attr.GEVAL_EXPLAIN);
					 String geval_image = obj.optString(Attr.GEVAL_IMAGE);
				

					AdvertDatas.add(new GoodComments( geval_orderid,  geval_orderno,
							 geval_ordergoodsid,  geval_goodsid,
							 geval_goodsname,  geval_goodsprice,
							 geval_scores,  geval_content,
							 geval_isanonymous,  geval_addtime,
							 geval_storeid,  geval_storename,
							 geval_frommemberid,  geval_frommembername,
							 geval_state,  geval_remark,  geval_explain,
							 geval_image));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}







		@Override
		public String toString() {
			return "GoodComments [geval_orderid=" + geval_orderid
					+ ", geval_orderno=" + geval_orderno
					+ ", geval_ordergoodsid=" + geval_ordergoodsid
					+ ", geval_goodsid=" + geval_goodsid + ", geval_goodsname="
					+ geval_goodsname + ", geval_goodsprice="
					+ geval_goodsprice + ", geval_scores=" + geval_scores
					+ ", geval_content=" + geval_content
					+ ", geval_isanonymous=" + geval_isanonymous
					+ ", geval_addtime=" + geval_addtime + ", geval_storeid="
					+ geval_storeid + ", geval_storename=" + geval_storename
					+ ", geval_frommemberid=" + geval_frommemberid
					+ ", geval_frommembername=" + geval_frommembername
					+ ", geval_state=" + geval_state + ", geval_remark="
					+ geval_remark + ", geval_explain=" + geval_explain
					+ ", geval_image=" + geval_image + "]";
		}



	



		

	

}
