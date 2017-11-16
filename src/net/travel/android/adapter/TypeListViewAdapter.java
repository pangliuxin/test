/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.adapter
 * FileNmae:HomeGridViewAdapter.java
 */
package net.travel.android.adapter;

import java.util.ArrayList;

import net.cangshengwang.android.mobile2.R;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyBackAsynaTask;
import net.travel.android.model.Type;
import net.travel.android.model.TypeList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author KingKong·HE
 * @Time 2014-1-6 下午12:06:09
 */
public class TypeListViewAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<TypeList> typeList;

	public TypeListViewAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return typeList == null ? 0 : typeList.size();
	}

	@Override
	public Object getItem(int position) {
		return typeList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public ArrayList<TypeList> getTypeList() {
		return typeList;
	}

	public void setTypeList(ArrayList<TypeList> typeList) {
		this.typeList = typeList;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_type_item, null);
			holder = new ViewHolder();
			holder.textName = (TextView) convertView
					.findViewById(R.id.textName);
			holder.texttype = (TextView) convertView
					.findViewById(R.id.texttype);
			holder.texttime = (TextView) convertView
					.findViewById(R.id.texttime);
			holder.imagePic = (ImageView) convertView
					.findViewById(R.id.imagePic);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		TypeList bean = typeList.get(position);
		holder.textName.setText("商品:"+bean.getName());
		holder.texttype.setText("商品类型:"+bean.getProduct_type());
		holder.texttime.setText("收藏时间:"+bean.getUpdatetime());
		String imagename = bean.getImage_url().split("\\\\")[1];
		MyBackAsynaTask asynaTask = new MyBackAsynaTask(HttpUtil.URL_BASEUPLOAD+imagename, holder.imagePic);
		asynaTask.execute();

		return convertView;
	}

	class ViewHolder {
		TextView textName;
		TextView texttype;
		TextView texttime;
		ImageView imagePic;
	}
}
