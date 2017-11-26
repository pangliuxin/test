/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.ui.type
 * FileNmae:GoodsDetailsActivity.java
 */
package net.travel.android.ui.type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

import net.cangshengwang.android.mobile2.R;
import net.travel.android.adapter.GoodsDetailCommentsListViewAdapter;
import net.travel.android.adapter.GoodsDetailsGalleryAdapter;
import net.travel.android.common.Constants;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyApp;
import net.travel.android.handler.RemoteDataHandler;
import net.travel.android.handler.RemoteDataHandler.Callback;
import net.travel.android.model.CommendList;
import net.travel.android.model.CommentsList;
import net.travel.android.model.GoodComments;
import net.travel.android.model.GoodsDetails;
import net.travel.android.model.GoodsList;
import net.travel.android.model.Login;
import net.travel.android.model.ManSongInFo;
import net.travel.android.model.ManSongRules;
import net.travel.android.model.ResponseData;
import net.travel.android.model.Spec;
import net.travel.android.model.TypeList;
import net.travel.android.ui.custom.MyGridView;
import net.travel.android.ui.custom.MyListView;
import net.travel.android.ui.mystore.CommentsActivity;
import net.travel.android.ui.mystore.LoginActivity;
import net.travel.android.ui.mystore.MyStoreActivity;
import net.travel.android.ui.mystore.RoomBookActivity;
import net.travel.android.ui.mystore.RoomBorrowActivity;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014-1-9 下午3:15:36
 */
public class MeetRoomDetailsActivity extends Activity {
	private GoodsDetailsGalleryAdapter adapter;
	private TextView textGoodsDetailsName;
	private TextView textGoodsDetailsPrice;
	private TextView textGoodsDetailsMarketPrice;
	private TextView textGoodsDetailsStorage;
	private TextView textGoodsOriginalprice;
	private TextView textGoodsCurrentprice;
	private TextView textGoodsDetailsWeb;
	private MyListView goodsCommentsListView;
	private LinearLayout linearLayoutSpecView;
//	private MyGridView gridViewCommend;
//	private CommendGridViewAdapter commendAdapter;
	private GoodsDetailCommentsListViewAdapter gooddetailcommentsAdapter;
	private ScrollView SView;
	private LinearLayout linearlayoutManSong;
	private LinearLayout linearLayoutStorage;
	private LinearLayout linearLayoutNumber;
	private LinearLayout linearLayoutBuy;
	private ArrayList<CommentsList> lists = new ArrayList<CommentsList>();
	private ImageButton imageBackButton;
	private ImageButton imageButtonFavoritesAdd;
	private MyApp myApp;
	private Button buttonAddShopCart,buttonAddFolder;
	private Button buttonBook;
	
//	private Button buttonGoodsNumberMinus;
//	private Button buttonGoodsNumberADD;
//	private TextView textGoodsNumberValues;
	private int GoodsNumberCount =1;
	private int upper_limit = 0;
	private int goods_kucun = 0;
	private int goods_default_buynum = 1;
	private String goods_isbuy;
//	private ListView commentslistViewOrder;
	private int productpoint;
	private int memberpoint;
	private String room_id;
	private String ticketid;
	private String jingdianzuobiao;
	private String jingdian;
	private String weburl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.goods_details_view);
		myApp =  (MyApp) MeetRoomDetailsActivity.this.getApplication();
		
		textGoodsDetailsName = (TextView) findViewById(R.id.textGoodsDetailsName);
		textGoodsDetailsPrice = (TextView) findViewById(R.id.textGoodsDetailsPrice);
		textGoodsDetailsMarketPrice = (TextView) findViewById(R.id.textGoodsDetailsMarketPrice);
		
		textGoodsOriginalprice = (TextView) findViewById(R.id.textGoodsOriginalprice);
		textGoodsCurrentprice = (TextView) findViewById(R.id.textGoodsCurrentprice);
//		textGoodsDetailsStorage =(TextView) findViewById(R.id.textGoodsDetailsStorage);
		textGoodsDetailsWeb = (TextView) findViewById(R.id.textGoodsDetailsWeb);
		linearLayoutSpecView =(LinearLayout) findViewById(R.id.linearLayoutSpecView);
		goodsCommentsListView = (MyListView) findViewById(R.id.goodsCommentsListView);
//		gridViewCommend= (MyGridView) findViewById(R.id.goodsCommentsListView);
		linearlayoutManSong = (LinearLayout) findViewById(R.id.linearlayoutManSong);
		linearLayoutStorage = (LinearLayout) findViewById(R.id.linearLayoutStorage);
//		linearLayoutNumber = (LinearLayout) findViewById(R.id.linearLayoutNumber);
//		linearLayoutBuy = (LinearLayout) findViewById(R.id.linearLayoutBuy);
		imageBackButton = (ImageButton) findViewById(R.id.imageBackButton);
		imageButtonFavoritesAdd = (ImageButton) findViewById(R.id.imageButtonFavoritesAdd);
		
		
		
		buttonAddShopCart = (Button) findViewById(R.id.buttonAddShopCart);
		buttonAddFolder = (Button) findViewById(R.id.buttonAddFolder);
		buttonBook = (Button) findViewById(R.id.buttonBook);
		/*buttonAddShopCart = (Button) findViewById(R.id.buttonAddShopCart);
		buttonAddComments = (Button) findViewById(R.id.buttonAddComments);
		buttonBaidumap = (Button) findViewById(R.id.buttonBaidumap);*/
//		buttonNowBuy = (Button) findViewById(R.id.buttonNowBuy);
		SView = (ScrollView) findViewById(R.id.SView);
//		buttonGoodsNumberMinus = (Button) findViewById(R.id.buttonGoodsNumberMinus);
//		buttonGoodsNumberADD = (Button) findViewById(R.id.buttonGoodsNumberADD);
//		textGoodsNumberValues = (TextView) findViewById(R.id.textGoodsNumberValues);
//		commentslistViewOrder =(ListView)findViewById(R.id.goodsCommentsListView);
//		SView.smoothScrollTo(0,20);
		
		
		gooddetailcommentsAdapter = new GoodsDetailCommentsListViewAdapter(MeetRoomDetailsActivity.this);
		goodsCommentsListView.setAdapter(gooddetailcommentsAdapter);
		
	/*	manSongRulesAdapter = new ManSongRulesListViewAdapter(MeetRoomDetailsActivity.this);
		listViewManSongRules.setAdapter(manSongRulesAdapter);*/
//		manSongRulesAdapter.notifyDataSetChanged();
		
//		commendAdapter = new CommendGridViewAdapter(MeetRoomDetailsActivity.this);
//		gridViewCommend.setAdapter(commendAdapter);
//		commendAdapter.notifyDataSetChanged();
		
/*		gridViewCommend.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				CommendList bean = (CommendList) gridViewCommend.getItemAtPosition(arg2);
				Intent intent = new Intent(GoodsDetailsActivity.this,GoodsDetailsActivity.class);
				intent.putExtra("goods_id", bean.getGoods_id());
				GoodsDetailsActivity.this.startActivity(intent);
				GoodsDetailsActivity.this.finish();
			}
		});*/
		
//		adapter.notifyDataSetChanged();
		
//		loadingGoodsDetailsData(goods_id);
//		loadingGoodsDetailCommentsData(goods_id);
		room_id = getIntent().getExtras().getString("room_id");
		
		loadingGoodsDetailData(room_id);
		loadingCommentsData(room_id);
		/**
		 * 		// 设置显示
		tv_main_title.setVisibility(View.VISIBLE);
		// 设置不显示也不占用空间
		tv_main_title.setVisibility(View.GONE);
		// 设置不显示但占用空间
		tv_main_title.setVisibility(View.INVISIBLE);
		 * 
		 */
		//System.out.println(goods_isbuy+"-------------------------------------------");
	/*	if(goods_isbuy != "1"){
			linearLayoutStorage.setVisibility(View.GONE);
			linearLayoutNumber.setVisibility(View.GONE);
			linearLayoutBuy.setVisibility(View.GONE);
			}else{
			linearLayoutStorage.setVisibility(View.VISIBLE);
			linearLayoutNumber.setVisibility(View.VISIBLE);
			linearLayoutBuy.setVisibility(View.VISIBLE);
			}*/
		
		imageBackButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				MeetRoomDetailsActivity.this.finish();
			}
		});
		
	
		
		textGoodsDetailsWeb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			/*	Intent intent = new Intent(GoodsDetailsActivity.this,GoodsDetailsWebAcivity.class);
				intent.putExtra("goods_id", goods_id);
				GoodsDetailsActivity.this.startActivity(intent);*/
			}
		});
		
		
		
		buttonBook.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLogin()) {
					book();
				} else {
					goToLogin();
				}
				
			}
		});
		buttonAddShopCart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLogin()) {
				    shopAddCart();
				} else {
				    goToLogin();
				}
				
			}
		});
		buttonAddFolder.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLogin()) {
					Intent intent = new Intent(MeetRoomDetailsActivity.this,CommentsActivity.class);
					Bundle bundle = new Bundle();
					bundle.putString("jingdianid", room_id);
					intent.putExtras(bundle);
					startActivity(intent);
				} else {
					goToLogin();
				}
				
			}
		});
/*		buttonAddShopCart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLogin()) {
				    shopAddCart(ticketid);
				} else {
				    goToLogin();
				}
				
			}
		});
		buttonAddComments.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLogin()) {
					Intent intent = new Intent(GoodsDetailsActivity.this,CommentsActivity.class);
					intent.putExtra("jingdianid", jingdian_id);
					GoodsDetailsActivity.this.startActivity(intent);
				} else {
					goToLogin();
				}
				
			}
		});
		buttonBaidumap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(isLogin()) {
					Intent intent = new Intent(GoodsDetailsActivity.this,LocationActivity.class);
					intent.putExtra("jingdianzuobiao", jingdianzuobiao);
					intent.putExtra("jingdian", jingdian);
					GoodsDetailsActivity.this.startActivity(intent);
				} else {
					goToLogin();
				}
				
			}
		});
		*/
/*		buttonNowBuy.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(goods_kucun == 0){
					Toast.makeText(GoodsDetailsActivity.this, "库存不足", Toast.LENGTH_SHORT).show();;
					return ;
				}
				if(isLogin()) {
					
					
					loadLogedUserPoints(myApp.getLoginKey());
					
					if(productpoint < memberpoint){
						Toast.makeText(GoodsDetailsActivity.this, "积分不够", Toast.LENGTH_SHORT).show();;
						return;
					}
				    Intent intent = new Intent(GoodsDetailsActivity.this,BuyStep1Activity.class);
	                intent.putExtra("cart_id", goods_id+"|"+GoodsNumberCount);
	                intent.putExtra("cartFlag", "goodsDetailsFlag");
	                GoodsDetailsActivity.this.startActivity(intent);
				} else {
				    goToLogin();
				}
			}
		});*/
		
		if(GoodsNumberCount <= goods_default_buynum){
			GoodsNumberCount = goods_default_buynum;
//			buttonGoodsNumberMinus.setBackgroundResource(R.drawable.edit_product_num_des_no_enable);
		}
		
/*		buttonGoodsNumberADD.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				GoodsNumberCount ++;
				if(upper_limit != 0 && GoodsNumberCount >= upper_limit){
					GoodsNumberCount = upper_limit;
					Toast.makeText(GoodsDetailsActivity.this, "限购"+upper_limit+"个", Toast.LENGTH_SHORT).show();;
					buttonGoodsNumberADD.setBackgroundResource(R.drawable.edit_product_num_add_no_enable);
				}
				if(GoodsNumberCount >= goods_kucun){
					GoodsNumberCount = goods_kucun;
					Toast.makeText(GoodsDetailsActivity.this, "库存不足", Toast.LENGTH_SHORT).show();;
					buttonGoodsNumberADD.setBackgroundResource(R.drawable.edit_product_num_add_no_enable);
				}
				textGoodsNumberValues.setText(""+GoodsNumberCount);
				buttonGoodsNumberMinus.setBackgroundResource(R.drawable.edit_product_num_des_normal);
			}
		});*/
		
/*		buttonGoodsNumberMinus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				GoodsNumberCount --;
				if(GoodsNumberCount <=goods_default_buynum){
					GoodsNumberCount = goods_default_buynum;
//					Toast.makeText(GoodsDetailsActivity.this, "最少买一个吧", Toast.LENGTH_SHORT).show();;
					buttonGoodsNumberMinus.setBackgroundResource(R.drawable.edit_product_num_des_no_enable);
				}
				textGoodsNumberValues.setText(""+GoodsNumberCount);
				buttonGoodsNumberADD.setBackgroundResource(R.drawable.edit_product_num_add_normal);
			}
		});*/
		
	}
	

	public void loadingCommentsData(String roomid){
		
		String url = HttpUtil.URL_ROOMBOOKCOMMENTSL+roomid;
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
					
						ArrayList<CommentsList> goods_list=CommentsList.newInstanceList(arrlist);
						lists.addAll(goods_list);
						gooddetailcommentsAdapter.setGoodsDatas(lists);
						gooddetailcommentsAdapter.notifyDataSetChanged();
					}else{
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
	}	
	
	
	public void AddtoHistory(String goodid){
		
		String url = HttpUtil.URL_HISTORYADD+"history.useid="+myApp.getLoginKey()+"&history.productid="+goodid;
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
					
						/*ArrayList<CommentsList> goods_list=CommentsList.newInstanceList(arrlist);
						lists.addAll(goods_list);
//						gooddetailcommentsAdapter.setGoodsDatas(lists);
						adapter.notifyDataSetChanged();*/
						if(arrlist.equals("1")){
							Toast.makeText(MeetRoomDetailsActivity.this, "已标记浏览", Toast.LENGTH_SHORT).show();;
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
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
	}	
public void addToFolder(String jingdianid){
		
		String url = HttpUtil.URL_ADDJINGDIANFOLDER+"folder.productid="+jingdianid+"&folder.userid="+myApp.getLoginKey();
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
							Toast.makeText(MeetRoomDetailsActivity.this, "收藏成功", Toast.LENGTH_LONG).show();
						}else{
							Toast.makeText(MeetRoomDetailsActivity.this, "收藏失败", Toast.LENGTH_LONG).show();
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
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
	}

	public void shopAddCart(){
	
		Intent intent = new Intent(MeetRoomDetailsActivity.this,RoomBookActivity.class);
		intent.putExtra("room_id", room_id);
		MeetRoomDetailsActivity.this.startActivity(intent);

	}
	public void book(){
		
		Intent intent = new Intent(MeetRoomDetailsActivity.this,RoomBorrowActivity.class);
		intent.putExtra("room_id", room_id);
		MeetRoomDetailsActivity.this.startActivity(intent);
		
	}
	
	
	public void loadLogedUserPoints(String key){
		String url = Constants.URL_MEMBER_POINTS;
		HashMap<String, String> params = new HashMap<String,String>();
		params.put("key", key);

		RemoteDataHandler.asyncPost2(url, params, new Callback() {
			@Override
			public void dataLoaded(ResponseData data) {
				if(data.getCode() == HttpStatus.SC_OK){
					String json = data.getJson();
					
					try {
						JSONObject obj = new JSONObject(json);
						String member_points = obj.getString("member_points");
						if(member_points !=null && member_points.length()>0){
							memberpoint = Integer.parseInt(member_points);
						}
					
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}else{
					Toast.makeText(MeetRoomDetailsActivity.this, "数据加载失败，请稍后重试", Toast.LENGTH_SHORT).show();;
				}
			}
		});
	}
	public boolean isLogin() {
	    String key = myApp.getLoginKey();
	    if(key!=null && key!="") {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public void goToLogin() {
	    Intent intent = new Intent(MeetRoomDetailsActivity.this, LoginActivity.class);
	    startActivity(intent);
	}
	

	
	
	
	public void loadingGoodsDetailData(String goods_id){
		String url = HttpUtil.URL_ROOMDETAIL+goods_id;
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
					String jsonStr = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					System.out.println(jsonStr);
					JSONObject goods = new JSONObject(jsonStr);
//					textGoodsDetailsMarketPrice.setText("￥"+goods.optDouble("ticketoprice"));
					textGoodsDetailsPrice.setText("书籍名称:"+goods.optString("name"));
					textGoodsDetailsName.setText("作者:"+goods.optString("description"));
					textGoodsOriginalprice.setText("版本号:"+goods.optString("device"));
//					textGoodsOriginalprice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG); //删除线
					textGoodsCurrentprice.setText("出版社:"+goods.optString("capability"));
				
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(MeetRoomDetailsActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
	}

	
}
