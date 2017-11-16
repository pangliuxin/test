/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.adapter
 * FileNmae:GoodsListViewAdapter.java
 */
package net.travel.android.adapter;

import java.util.ArrayList;

import net.cangshengwang.android.mobile2.R;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyBackAsynaTask;
import net.travel.android.model.EmployeeList;
import net.travel.android.model.GoodsList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author KingKong·HE
 * @Time 2014-1-6 下午12:06:09
 */
public class EmployeeListViewAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<EmployeeList> goodsLists;
	public EmployeeListViewAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return goodsLists == null ? 0 : goodsLists.size();
	}

	@Override
	public Object getItem(int position) {
		return goodsLists.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}

	
	public ArrayList<EmployeeList> getGoodsLists() {
		return goodsLists;
	}
	
	public void setGoodsLists(ArrayList<EmployeeList> goodsLists) {
		this.goodsLists = goodsLists;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		EmployeeList bean= goodsLists.get(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_event_item, null);
			holder = new ViewHolder();
			holder.textName = (TextView) convertView.findViewById(R.id.textName);
			holder.textTel = (TextView) convertView.findViewById(R.id.textTel);
			holder.textMail = (TextView) convertView.findViewById(R.id.textMail);
			holder.textJob = (TextView) convertView.findViewById(R.id.textJob);
			holder.textDept = (TextView) convertView.findViewById(R.id.textDept);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		
		holder.textName.setText("姓名:"+bean.getName());
		holder.textTel.setText("电话:"+bean.getTel());
		holder.textMail.setText("邮箱:"+bean.getMail());
		holder.textJob.setText("岗位:"+bean.getJob());
		holder.textDept.setText("年龄:"+bean.getDept());
		
		return convertView;
	}
	class ViewHolder {
		TextView textName;
		TextView textTel;
		TextView textMail;
		TextView textJob;
		TextView textDept;
	}
}
