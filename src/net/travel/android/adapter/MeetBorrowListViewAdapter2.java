/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.adapter
 * FileNmae:GoodsListViewAdapter.java
 */
package net.travel.android.adapter;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import net.cangshengwang.android.mobile2.R;
import net.travel.android.StartActivity;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyBackAsynaTask;
import net.travel.android.model.EmployeeList;
import net.travel.android.model.GoodsList;
import net.travel.android.model.MeetBookList;
import net.travel.android.ui.home.HomeActivity;
import net.travel.android.ui.type.MeetBorrowListViewActivity;
import net.travel.android.ui.type.MessageViewActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014-1-6 下午12:06:09
 */
public class MeetBorrowListViewAdapter2 extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<MeetBookList> goodsLists;
	public MeetBorrowListViewAdapter2(Context context) {
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
	public void guihuan(String roomid){
		
		String url = HttpUtil.URL_ROOMGUIHUAN+"meetroom.id="+roomid;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
					
					if(arrlist.equals("1")){
						Toast.makeText(context, "操作成功", Toast.LENGTH_LONG).show();
						Intent intent = new Intent(context,
								MeetBorrowListViewActivity.class);
						context.startActivity(intent);
					}
					}else{
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(context, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(context, result, Toast.LENGTH_SHORT).show();;
		}
	}
	public void deletebook(String id){
		
		String url = HttpUtil.URL_ROOMDELBORROW+"meetborrow.id="+id;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
						
						if(arrlist.equals("1")){
						/*	Toast.makeText(context, "操作成功", Toast.LENGTH_LONG).show();
							Intent intent = new Intent(context,
									MeetBorrowListViewActivity.class);
							context.startActivity(intent);*/
						}
					}else{
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(context, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(context, result, Toast.LENGTH_SHORT).show();;
		}
	}
	public void guashi(String roomid){
		
		String url = HttpUtil.URL_ROOMDGUASHI+"meetroom.id="+roomid;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
						
						if(arrlist.equals("1")){
							Toast.makeText(context, "操作成功", Toast.LENGTH_LONG).show();
							Intent intent = new Intent(context,
									MeetBorrowListViewActivity.class);
							context.startActivity(intent);
						}
					}else{
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(context, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(context, result, Toast.LENGTH_SHORT).show();;
		}
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		final MeetBookList bean= goodsLists.get(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_health_item2, null);
			holder = new ViewHolder();
			holder.textName = (TextView) convertView.findViewById(R.id.textName);
			holder.textStart = (TextView) convertView.findViewById(R.id.textStart);
			holder.textEnd = (TextView) convertView.findViewById(R.id.textEnd);
			holder.textStatus = (TextView) convertView.findViewById(R.id.textStatus);
			holder.buttonAddShopCart = (Button) convertView.findViewById(R.id.buttonAddShopCart);
			holder.buttonAddShopCart2 = (Button) convertView.findViewById(R.id.buttonAddShopCart2);
//  		holder.textEvaluationCount = (TextView) convertView.findViewById(R.id.textEvaluationCount);
	/*		holder.imageGroupPricePromotionType = (ImageView) convertView.findViewById(R.id.imageGroupPricePromotionType);
			holder.imageXianShiPricePromotionType = (ImageView) convertView.findViewById(R.id.imageXianShiPricePromotionType);*/
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		
		holder.textName.setText("书籍名称:"+bean.getRoomname()+"\n借阅用户:"+bean.getUsername());
		holder.textStart.setText("借阅开始时间:"+bean.getStarttimestr());
		holder.textEnd.setText("归还时间:"+bean.getEndtimestr());
		holder.buttonAddShopCart.setVisibility(View.GONE);
		holder.buttonAddShopCart2.setVisibility(View.GONE);
		holder.buttonAddShopCart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				deletebook(bean.getId());
				guihuan(bean.getRoomid());
				
			}
		});
		holder.buttonAddShopCart2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				guashi(bean.getRoomid());
			}
		});
		
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
		Button buttonAddShopCart;
		Button buttonAddShopCart2;
	}
}
