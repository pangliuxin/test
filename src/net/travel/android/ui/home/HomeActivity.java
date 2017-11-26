package net.travel.android.ui.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.cangshengwang.android.mobile2.R;
import net.travel.android.MainActivity;
import net.travel.android.adapter.GoodsListViewAdapter;
import net.travel.android.common.Constants;
import net.travel.android.common.HttpHelper;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyApp;
import net.travel.android.common.MyBackAsynaTask;
import net.travel.android.common.MySrcAsynaTask;
import net.travel.android.common.SystemHelper;
import net.travel.android.handler.RemoteDataHandler;
import net.travel.android.handler.RemoteDataHandler.Callback;
import net.travel.android.model.AdvertList;
import net.travel.android.model.GoodsList;
import net.travel.android.model.HistoryBrowse;
import net.travel.android.model.Home1List;
import net.travel.android.model.Home2List;
import net.travel.android.model.MyStore;
import net.travel.android.model.ResponseData;
import net.travel.android.ui.mystore.LoginActivity;
import net.travel.android.ui.mystore.MyStoreActivity;
import net.travel.android.ui.type.MeetBorrowListViewActivity;
import net.travel.android.ui.type.MeetRoomDetailsActivity;
import net.travel.android.ui.type.MeetBookListViewActivity;
import net.travel.android.ui.type.MessageViewActivity;
import net.travel.android.ui.type.MeetRoomListViewActivity;
import net.travel.android.ui.type.TypeListViewActivity;
import net.travel.android.ui.widget.Utility;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	private LinearLayout ll_point;
	private ArrayList<View> arrayList;
	private ArrayList<ImageView> imageViews;
	private Timer timer;
	private MyApp myApp;
	private LayoutInflater HeadlayoutInflater;
	private ViewPager viewPager;
	private int i;
	private int count;
	private GoodsListViewAdapter goodsListAdapter;
	private TextView textHomeSearch;
	private ScrollView myScrollView;
	private ListView listRecommendGoods;
	private LinearLayout linearLayoutCategory0;
	private LinearLayout linearLayoutCategory1;
	private LinearLayout linearLayoutCategory2;
	private LinearLayout linearLayoutCategory3;
	private LinearLayout linearLayoutCategory4;
	private LinearLayout linearLayoutCategory5;
	private LinearLayout circle_layout;
	private Button buttonSeeAll;
	private Button buttonClickSign;
	private Button buttonHomeLogin;
	private LinearLayout linearLayoutHomeLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		myApp = (MyApp) HomeActivity.this.getApplication();

		textHomeSearch = (TextView) findViewById(R.id.textHomeSearch);
		myScrollView = (ScrollView) findViewById(R.id.myScrollView);
		linearLayoutCategory0 = (LinearLayout) findViewById(R.id.linearLayoutCategory0);
		linearLayoutCategory1 = (LinearLayout) findViewById(R.id.linearLayoutCategory1);
		linearLayoutCategory2 = (LinearLayout) findViewById(R.id.linearLayoutCategory2);
		linearLayoutCategory3 = (LinearLayout) findViewById(R.id.linearLayoutCategory3);
		linearLayoutCategory4 = (LinearLayout) findViewById(R.id.linearLayoutCategory4);
		linearLayoutCategory5 = (LinearLayout) findViewById(R.id.linearLayoutCategory5);
		linearLayoutHomeLogin = (LinearLayout) findViewById(R.id.linearLayoutHomeLogin);

		// loadingHomeData();

		CategoryOnClickListener categoryLister = new CategoryOnClickListener();
		linearLayoutCategory0.setOnClickListener(categoryLister);
		linearLayoutCategory1.setOnClickListener(categoryLister);
		linearLayoutCategory2.setOnClickListener(categoryLister);
		linearLayoutCategory3.setOnClickListener(categoryLister);
		linearLayoutCategory4.setOnClickListener(categoryLister);
		linearLayoutCategory5.setOnClickListener(categoryLister);

		RegisterBroadcastReceiver();
		/**
		 * buttonClickSign.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { if(myApp.getLoginKey() ==null
		 *           || myApp.getLoginKey().equals("") ||
		 *           myApp.getLoginKey().equals("null")){ //未登录
		 *           Toast.makeText(HomeActivity.this, "未登录，请先登录",
		 *           Toast.LENGTH_SHORT).show(); return; }else{ //已登录
		 *           clickToSign(); } } });
		 **/
		/**
		 * buttonHomeLogin.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { Intent intent = new
		 *           Intent(HomeActivity.this, LoginActivity.class);
		 *           HomeActivity.this.startActivity(intent); } });
		 * 
		 *           linearLayoutHomeLogin.setOnClickListener(new
		 *           OnClickListener() {
		 * @Override public void onClick(View v) { Intent intent = new
		 *           Intent(HomeActivity.this, LoginActivity.class);
		 *           HomeActivity.this.startActivity(intent); } });
		 **/

	}

	public void clickToSign() {
		// TODO Auto-generated method stub
		String url = Constants.URL_SIGN;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("key", myApp.getLoginKey());
		RemoteDataHandler.asyncPost2(url, params, new Callback() {
			@Override
			public void dataLoaded(ResponseData data) {
				if (data.getCode() == HttpStatus.SC_OK) {
					String json = data.getJson();
					JSONObject obj2;
					try {
						obj2 = new JSONObject(json);
						String flag = obj2.getString("flag");
						if (flag.equals("1")) {
							Toast.makeText(HomeActivity.this, "签到成功",
									Toast.LENGTH_SHORT).show();
							;
						} else if (flag.equals("2")) {
							Toast.makeText(HomeActivity.this, "上午已签到",
									Toast.LENGTH_SHORT).show();
							;
						} else if (flag.equals("3")) {
							Toast.makeText(HomeActivity.this, "下午已签到",
									Toast.LENGTH_SHORT).show();
							;
						} else if (flag.equals("4")) {
							Toast.makeText(HomeActivity.this, "今日已签到",
									Toast.LENGTH_SHORT).show();
							;
						}

					} catch (JSONException e) {
						e.printStackTrace();
					}

				} else {
					Toast.makeText(HomeActivity.this, "数据加载失败，请稍后重试",
							Toast.LENGTH_SHORT).show();
					;
				}
			}
		});

	}

	private BroadcastReceiver homeBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action == Constants.APP_BORADCASTRECEIVER) {
				linearLayoutHomeLogin.setVisibility(View.GONE);
			}
		}
	};

	public void RegisterBroadcastReceiver() {
		IntentFilter homeIntentFilter = new IntentFilter();
		homeIntentFilter.addAction(Constants.APP_BORADCASTRECEIVER);
		HomeActivity.this.registerReceiver(homeBroadcastReceiver,
				homeIntentFilter);
	}

	public class CategoryOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Bundle b = new Bundle();
			Intent intent = null;
			switch (v.getId()) {
			case R.id.linearLayoutCategory0:// 农业生物信息

				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							MeetRoomListViewActivity.class);
					b = new Bundle();
					b.putInt("type", 0);
					intent.putExtras(b);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;
			case R.id.linearLayoutCategory1:// 分析软件和工具
				if (myApp.getLoginKey() != "") {
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}

				break;
			case R.id.linearLayoutCategory2:// 成功案例
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							MessageViewActivity.class);
					b = new Bundle();
					b.putInt("type", 2);
					intent.putExtras(b);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;
			case R.id.linearLayoutCategory3:// 农业生物信息

				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							MeetBookListViewActivity.class);
					b = new Bundle();
					b.putInt("type", 0);
					intent.putExtras(b);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;
			case R.id.linearLayoutCategory4:// 分析软件和工具
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							MeetBorrowListViewActivity.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}

				break;
			case R.id.linearLayoutCategory5:// 成功案例
				if (myApp.getLoginKey() != "") {
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;

			}
			if (intent != null) {
				startActivity(intent);
			}
		}
	}

	public void initPoint(ArrayList<AdvertList> list) {
		imageViews = new ArrayList<ImageView>();
		ImageView imageView;

		for (i = 0; i < list.size(); i++) {
			imageView = new ImageView(this);
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
					new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,
							LayoutParams.WRAP_CONTENT));
			layoutParams.leftMargin = 10;
			layoutParams.rightMargin = 10;
			ll_point.addView(imageView, layoutParams);

			imageViews.add(imageView);
		}
	}

	/***
	 * 初始化 PagerChild
	 */
	public void initPagerChild(ArrayList<AdvertList> list) {
		arrayList = new ArrayList<View>();
		for (int i = 0; i < list.size(); i++) {
			final AdvertList advert = list.get(i);
			ImageView imageView = new ImageView(HomeActivity.this);
			imageView.setScaleType(ScaleType.FIT_XY);

			System.out
					.println("in initpagechild advert-->" + advert.toString());

			MyBackAsynaTask mTask = new MyBackAsynaTask(advert.getImage(),
					imageView);
			mTask.execute();
			imageView.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String keyword = advert.getKeyword();

					System.out.println("imageview onclick advert:-->"
							+ advert.toString());

					if (keyword.equals("") || keyword.equals("")
							|| keyword == null) {
					} else {
					}
				}
			});
			arrayList.add(imageView);
		}
		initPoint(list);
	}

	public int initGetW(String result) {
		int w = 250;
		Bitmap bitmap;
		try {
			bitmap = HttpHelper.downloadBitmap(result);
			w = bitmap.getWidth();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return w;
	}

	public int initGetH(String result) {
		int h = 250;
		Bitmap bitmap;
		try {
			bitmap = HttpHelper.downloadBitmap(result);
			h = bitmap.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return h;
	}

	/***
	 * 初始化 HeadImage
	 */
	public void initHeadImage(ArrayList<AdvertList> list) {
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		ll_point = (LinearLayout) findViewById(R.id.ll_point);
		initPagerChild(list);
		int sw = SystemHelper.getScreenInfo(HomeActivity.this).widthPixels;
		int sh = SystemHelper.getScreenInfo(HomeActivity.this).heightPixels;
		int h = 250;
		if (list.size() != 0) {
			AdvertList bean = list.get(0);
			// int w = initGetW(bean.getImage());
			int oh = initGetH(bean.getImage());
			oh = oh * (sw / sh);
			// if(w == sw){
			// h=oh;
			// }else{
			// h=oh-(w-sw);
			// }
		}
		RelativeLayout.LayoutParams childLinerLayoutParames = new RelativeLayout.LayoutParams(
				LinearLayout.LayoutParams.FILL_PARENT, h);
		viewPager.setLayoutParams(childLinerLayoutParames);

		viewPager.setAdapter(new ViewPagerAdapter(arrayList));
		draw_Point(0);// 默认首次进入

		timer = new Timer(true);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						int index = viewPager.getCurrentItem();
						if (index == arrayList.size() - 1)
							index = 0;
						else
							index++;
						viewPager.setCurrentItem(index);

					}
				});
			}
		}, 5000, 5000);

		/***
		 * viewpager PageChangeListener
		 */
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int arg0) {
				draw_Point(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	/***
	 * 更新选中点
	 * 
	 * @param index
	 */
	public void draw_Point(int index) {
		for (int i = 0; i < imageViews.size(); i++) {
			imageViews.get(i).setImageResource(R.drawable.point_gray);
		}
		imageViews.get(index).setImageResource(R.drawable.point_red);
	}

	/***
	 * 对图片处理
	 * 
	 * @author zhangjia
	 */
	public Bitmap getBitmap(Bitmap bitmap, int width) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Matrix matrix = new Matrix();
		float scale = (float) width / w;
		// 保证图片不变形.
		matrix.postScale(scale, scale);
		// w,h是原图的属性.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}

	public class ViewPagerAdapter extends PagerAdapter {
		// 界面列表
		private List<View> views;

		public ViewPagerAdapter(List<View> views) {
			this.views = views;
		}

		// 销毁arg1位置的界面
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(views.get(arg1));
		}

		// 获得当前界面数
		@Override
		public int getCount() {
			if (views != null) {
				// 返回一个比较大的数字
				return views.size();
			}
			return 0;
		}

		// 初始化arg1位置的界面
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(views.get(arg1));
			return views.get(arg1);
		}

		// 判断是否由对象生成界面
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return (arg0 == arg1);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		count = 1;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(homeBroadcastReceiver);
	}

	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	// if (keyCode == KeyEvent.KEYCODE_BACK) {
	// count++;
	// if (count >= 3) {
	// HomeActivity.this.finish();
	// return true;
	// } else {
	// Toast.makeText(HomeActivity.this, "再点击一次退出程序",
	// Toast.LENGTH_SHORT).show();
	// return true;
	// }
	// } else {
	// return super.onKeyDown(keyCode, event);
	// }
	// }
}
