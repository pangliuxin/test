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
import net.travel.android.model.MeetRoomList;
import net.travel.android.model.Type;
import net.travel.android.model.TypeList;
import net.travel.android.ui.type.MeetRoomDetailsActivity;
import net.travel.android.ui.type.MeetRoomListViewActivity;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author KingKong·HE
 * @Time 2014-1-6 下午12:06:09
 */
public class MeetRoomListViewAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<MeetRoomList> typeList;

	public MeetRoomListViewAdapter(Context context) {
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

	public ArrayList<MeetRoomList> getTypeList() {
		return typeList;
	}

	public void setTypeList(ArrayList<MeetRoomList> typeList) {
		this.typeList = typeList;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_type1_item, null);
			holder = new ViewHolder();
			holder.textName = (TextView) convertView
					.findViewById(R.id.textName);
			holder.textDevice = (TextView) convertView
					.findViewById(R.id.textDevice);
			holder.textCapability = (TextView) convertView
					.findViewById(R.id.textCapability);
			holder.textDesc = (TextView) convertView
					.findViewById(R.id.textDesc);
			holder.textStatus = (TextView) convertView
					.findViewById(R.id.textStatus);

		/*	holder.imagePic = (ImageView) convertView
					.findViewById(R.id.imagePic);*/

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		final MeetRoomList bean = typeList.get(position);
		holder.textName.setText("书籍名称:"+bean.getName());
		holder.textDevice.setText("作者:"+bean.getDescription());
		holder.textCapability.setText("版本号:"+bean.getDevice());
		holder.textDesc.setText("出版社:"+bean.getCapability());
		Resources resource = (Resources) context.getResources();  
		ColorStateList csl1 = (ColorStateList) resource.getColorStateList(R.color.green);
		ColorStateList csl2 = (ColorStateList) resource.getColorStateList(R.color.blue1);
		ColorStateList csl3 = (ColorStateList) resource.getColorStateList(R.color.red);
		if(bean.getStatus().equals("0")){
			holder.textStatus.setText("状态:空闲中");
			holder.textStatus.setTextColor(csl1);
		}else if(bean.getStatus().equals("1")){
			holder.textStatus.setText("状态:借阅中");
			holder.textStatus.setTextColor(csl2);
		}else if(bean.getStatus().equals("2")){
			holder.textStatus.setText("状态:挂失中");
			holder.textStatus.setTextColor(csl3);
		}
		
		

		return convertView;
	}

	class ViewHolder {
		TextView textName;
		TextView textDevice;
		TextView textCapability;
		TextView textStatus;
		TextView textDesc;
	}
}
