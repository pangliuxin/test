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
import net.travel.android.model.MeetBookList;
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
public class MeetBookListViewAdapter2 extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<MeetBookList> goodsLists;
	public MeetBookListViewAdapter2(Context context) {
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

	
	public ArrayList<MeetBookList> getGoodsLists() {
		return goodsLists;
	}
	
	public void setGoodsLists(ArrayList<MeetBookList> goodsLists) {
		this.goodsLists = goodsLists;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		MeetBookList bean= goodsLists.get(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_health_item, null);
			holder = new ViewHolder();
			holder.textName = (TextView) convertView.findViewById(R.id.textName);
			holder.textStart = (TextView) convertView.findViewById(R.id.textStart);
			holder.textEnd = (TextView) convertView.findViewById(R.id.textEnd);
			holder.textStatus = (TextView) convertView.findViewById(R.id.textStatus);
//  		holder.textEvaluationCount = (TextView) convertView.findViewById(R.id.textEvaluationCount);
	/*		holder.imageGroupPricePromotionType = (ImageView) convertView.findViewById(R.id.imageGroupPricePromotionType);
			holder.imageXianShiPricePromotionType = (ImageView) convertView.findViewById(R.id.imageXianShiPricePromotionType);*/
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		
		holder.textName.setText("书籍名称:"+bean.getRoomname()+"\n预定用户:"+bean.getUsername());
		holder.textStart.setText("预定开始时间:"+bean.getStarttimestr());
		holder.textEnd.setText("预定结束时间:"+bean.getEndtimestr());
		if(bean.getStatus().equals("1")){
			holder.textStatus.setText("审核通过");
		}else{
			holder.textStatus.setText("未通过审核");
		}
	
//		holder.textEvaluationCount.setText("("+bean.getEvaluation_count()+"人)");
		
		/*	holder.imageGroupPricePromotionType.setBackgroundResource(R.drawable.product_price_tuan);
			holder.imageXianShiPricePromotionType.setBackgroundResource(R.drawable.product_price_jiang);*/
		
		return convertView;
	}
	class ViewHolder {
		TextView textName;
		TextView textStart;
		TextView textEnd;
		TextView textStatus;
	}
}
