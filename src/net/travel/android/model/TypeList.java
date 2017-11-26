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
public class TypeList {
	public static class Attr {
		public static final String TYPE_ID = "id";
		public static final String TYPE_NAME = "name";
		public static final String TYPE_TYPE = "product_type";
		public static final String TYPE_IMAGE = "image_url";
		public static final String TYPE_TIME = "updatetime";

	}

	private String id;
	private String name;
	private String product_type;
	private String image_url;
	private String updatetime;

	public TypeList() {
	}

	public TypeList(String id, String name, String product_type,
			String image_url, String updatetime) {
		super();
		this.id = id;
		this.name = name;
		this.product_type = product_type;
		this.image_url = image_url;
		this.updatetime = updatetime;
	}

	/**
	 * TypeList(String id, String name, String product_type, String image_url,
	 * String updatetime)
	 * 
	 * @param jsonDatas
	 * @return
	 */

	public static ArrayList<TypeList> newInstanceList(String jsonDatas) {
		ArrayList<TypeList> AdvertDatas = new ArrayList<TypeList>();

		try {
			JSONArray arr = new JSONArray(jsonDatas);
			int size = null == arr ? 0 : arr.length();
			System.out.println("size-->" + size);
			for (int i = 0; i < size; i++) {
				JSONObject obj = arr.getJSONObject(i);
				String id_ = obj.optString(Attr.TYPE_ID);
				String name_ = obj.optString(Attr.TYPE_NAME);
				String product_type = obj.optString(Attr.TYPE_TYPE);
				String type_image = obj.optString(Attr.TYPE_IMAGE);
				String updatetime = obj.optString(Attr.TYPE_TIME);
				TypeList bean = new TypeList(id_, name_, product_type,
						type_image, updatetime);
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

	public String getProduct_type() {
		return product_type;
	}

	public void setProduct_type(String product_type) {
		this.product_type = product_type;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

}
