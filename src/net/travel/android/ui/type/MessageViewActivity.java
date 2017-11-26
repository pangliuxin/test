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
import net.travel.android.MainActivity;
import net.travel.android.adapter.EmployeeListViewAdapter;
import net.travel.android.adapter.GoodsListViewAdapter;
import net.travel.android.adapter.MeetBookListViewAdapter;
import net.travel.android.adapter.MessageListViewAdapter;
import net.travel.android.common.Constants;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyApp;
import net.travel.android.handler.RemoteDataHandler;
import net.travel.android.handler.RemoteDataHandler.Callback;
import net.travel.android.model.EmployeeList;
import net.travel.android.model.GoodsList;
import net.travel.android.model.MeetBookList;
import net.travel.android.model.HistoryBrowse;
import net.travel.android.model.MessageList;
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
import android.content.BroadcastReceiver;
import android.content.Context;
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
public class MessageViewActivity extends Activity implements OnScrollListener {

	private ListView goodsListView;
	private MessageListViewAdapter adapter;
	private String keyword;
	private ArrayList<MessageList> lists;
	private EditText textHomeSearch;
	private ImageButton imageSearch; 
	private String shop_id;
	private MyApp myApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.message_list);
		keyword = MessageViewActivity.this.getIntent().getStringExtra("keyword");
		myApp = (MyApp) MessageViewActivity.this.getApplication();
		goodsListView = (ListView) findViewById(R.id.goodsListView);
		textHomeSearch = (EditText) findViewById(R.id.textHomeSearch);
		imageSearch = (ImageButton) findViewById(R.id.imageSearch);
		lists= new ArrayList<MessageList>();
		adapter =  new MessageListViewAdapter(MessageViewActivity.this);
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
		
/*		goodsListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				
				GoodsList bean = (GoodsList) goodsListView
						.getItemAtPosition(arg2);
				
				 //用intent启动拨打电话  
                Intent intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+bean.getPhonenum()));  
                startActivity(intent); 
				
				
			}
		});*/
	}
	


	
	
	
	public void loadingGoodsListData(){
	
		String url = HttpUtil.URL_MESSAGELST+"userid="+myApp.getLoginKey();
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
					
						ArrayList<MessageList> goods_list=MessageList.newInstanceList(arrlist);
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
			Toast.makeText(MessageViewActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MessageViewActivity.this, result, Toast.LENGTH_SHORT).show();;
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
