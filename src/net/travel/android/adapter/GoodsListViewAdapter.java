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
public class GoodsListViewAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<GoodsList> goodsLists;
	public GoodsListViewAdapter(Context context) {
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

	
	public ArrayList<GoodsList> getGoodsLists() {
		return goodsLists;
	}
	
	public void setGoodsLists(ArrayList<GoodsList> goodsLists) {
		this.goodsLists = goodsLists;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		GoodsList bean= goodsLists.get(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_goods_item, null);
			holder = new ViewHolder();
			holder.textName = (TextView) convertView.findViewById(R.id.textName);
			holder.textNum = (TextView) convertView.findViewById(R.id.textNum);
//  		holder.textEvaluationCount = (TextView) convertView.findViewById(R.id.textEvaluationCount);
	/*		holder.imageGroupPricePromotionType = (ImageView) convertView.findViewById(R.id.imageGroupPricePromotionType);
			holder.imageXianShiPricePromotionType = (ImageView) convertView.findViewById(R.id.imageXianShiPricePromotionType);*/
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		
		holder.textName.setText(bean.getNickname());
		holder.textNum.setText(bean.getPhonenum());
//		holder.textEvaluationCount.setText("("+bean.getEvaluation_count()+"人)");
		
		/*	holder.imageGroupPricePromotionType.setBackgroundResource(R.drawable.product_price_tuan);
			holder.imageXianShiPricePromotionType.setBackgroundResource(R.drawable.product_price_jiang);*/
		
		return convertView;
	}
	class ViewHolder {
		TextView textName;
		TextView textNum;
	}
}
