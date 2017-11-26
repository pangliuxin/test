/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.ui.type
 * FileNmae:GoodsListViewActivity.java
 */
package net.travel.android.ui.type;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import net.cangshengwang.android.mobile2.R;
import net.travel.android.adapter.EmployeeListViewAdapter;
import net.travel.android.adapter.GoodsListViewAdapter;
import net.travel.android.adapter.MeetBookListViewAdapter;
import net.travel.android.adapter.MeetBorrowListViewAdapter;
import net.travel.android.adapter.MeetBorrowListViewAdapter2;
import net.travel.android.common.Constants;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyApp;
import net.travel.android.handler.RemoteDataHandler;
import net.travel.android.handler.RemoteDataHandler.Callback;
import net.travel.android.model.EmployeeList;
import net.travel.android.model.GoodsList;
import net.travel.android.model.MeetBookList;
import net.travel.android.model.HistoryBrowse;
import net.travel.android.model.ResponseData;
import net.travel.android.model.WishList;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;



import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014-1-9 上午11:33:44
 */
public class MeetBorrowListViewActivity2 extends Activity implements OnScrollListener {

	private ListView goodsListView;
	private MeetBorrowListViewAdapter2 adapter;
	private String keyword;
	private ArrayList<MeetBookList> lists;
	private EditText textHomeSearch;
	private ImageButton imageSearch; 
	private String shop_id;
	private MyApp myApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.health_list2_);
		myApp =  (MyApp) MeetBorrowListViewActivity2.this.getApplication();
		keyword = MeetBorrowListViewActivity2.this.getIntent().getStringExtra("keyword");
		goodsListView = (ListView) findViewById(R.id.goodsListView);
		textHomeSearch = (EditText) findViewById(R.id.textHomeSearch);
		imageSearch = (ImageButton) findViewById(R.id.imageSearch);
		lists= new ArrayList<MeetBookList>();
		adapter =  new MeetBorrowListViewAdapter2(MeetBorrowListViewActivity2.this);
		goodsListView.setAdapter(adapter);
		goodsListView.setSelection(0);
		
			loadingGoodsListData();
		
//		loadingGoodsListData(gc_id,gc_type,order,goods_type);
//		loadingGoodsListData(null);
		
	/*	imageSearch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String searchtext = textHomeSearch.getText().toString();
				
				loadingGoodsListData(searchtext);
				
			}
		});*/
		
	/*	goodsListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				MeetBookList bean = (MeetBookList) goodsListView
						.getItemAtPosition(arg2);
				ShowSureDialog(bean.getId());
				
				
				
			}
		});*/
	}
	

	private void ShowSureDialog(final String roomid) {
		final AlertDialog alertDialog = new AlertDialog.Builder(MeetBorrowListViewActivity2.this)
				.setTitle("确认信息")
				.setMessage("确认审核通过本次借阅？")
				.setPositiveButton("确认",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								shenhe(roomid);
							}
						})
				.setNegativeButton("取消",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
								// startActivity(new Intent(StepTwo.this,
								// StepOne.class));
							}
						}).create();
		alertDialog.show();
	}
	
	public void shenhe(String roomid){
		
		String url = HttpUtil.URL_MEETBOOKDEL+"meetbook.id="+roomid;
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
						Toast.makeText(MeetBorrowListViewActivity2.this, "取消成功", Toast.LENGTH_LONG).show();
						loadingGoodsListData();
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
			Toast.makeText(MeetBorrowListViewActivity2.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetBorrowListViewActivity2.this, result, Toast.LENGTH_SHORT).show();;
		}
	}
	
	public void loadingGoodsListData(){
	
		String url = HttpUtil.URL_MEETBORROWLSTALL;
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
					
						ArrayList<MeetBookList> goods_list=MeetBookList.newInstanceList(arrlist);
						lists.addAll(goods_list);
						adapter.setGoodsLists(goods_list);
						adapter.notifyDataSetChanged();
					}else{
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetBorrowListViewActivity2.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetBorrowListViewActivity2.this, result, Toast.LENGTH_SHORT).show();;
		}
	}






	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		
	}






	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}
