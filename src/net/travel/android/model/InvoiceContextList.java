/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:AdvertList.java
 */
package net.travel.android.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class InvoiceContextList {
		public static class Attr{
			public static final String INVOICE_CONTENT_LIST = "invoice_content_list";
		}
		private String invoice_content_list;
		
		public InvoiceContextList() {
		}
		
		public InvoiceContextList(String invoice_content_list) {
			super();
			this.invoice_content_list = invoice_content_list;
		}
		

		public static ArrayList<InvoiceContextList> newInstanceList(String jsonDatas){
			ArrayList<InvoiceContextList> AdvertDatas = new ArrayList<InvoiceContextList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					String invoice_content_list = arr.get(i).toString();
					AdvertDatas.add(new InvoiceContextList(invoice_content_list));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}


		public String getInvoice_content_list() {
			return invoice_content_list;
		}

		public void setInvoice_content_list(String invoice_content_list) {
			this.invoice_content_list = invoice_content_list;
		}

		@Override
		public String toString() {
			return "InvoiceContextList [invoice_content_list="
					+ invoice_content_list + "]";
		}


}
