/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:GoodsList.java
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
public class HistoryList {
	public static class Attr {
		public static final String HISTORY_ID = "id";
		public static final String HISTORY_NAME = "name";
		public static final String HISTORY_TIME = "updatetime";

	}

	private String id;
	private String name;
	private String updatetime;

	public HistoryList() {
	}

	public HistoryList(String id, String name, String updatetime) {
		super();
		this.id = id;
		this.name = name;
		this.updatetime = updatetime;
	}

	// (String id, String name, String updatetime)

	public static ArrayList<HistoryList> newInstanceList(String jsonDatas) {
		ArrayList<HistoryList> AdvertDatas = new ArrayList<HistoryList>();

		try {
			JSONArray arr = new JSONArray(jsonDatas);
			int size = null == arr ? 0 : arr.length();
			System.out.println("size-->" + size);
			for (int i = 0; i < size; i++) {
				JSONObject obj = arr.getJSONObject(i);
				String id = obj.optString(Attr.HISTORY_ID);
				String name_ = obj.optString(Attr.HISTORY_NAME);
				String time_ = obj.optString(Attr.HISTORY_TIME);
				HistoryList bean = new HistoryList(id, name_, time_);
				// System.out.println("goodlist-->" + bean.toString());
				AdvertDatas.add(bean);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return AdvertDatas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}
