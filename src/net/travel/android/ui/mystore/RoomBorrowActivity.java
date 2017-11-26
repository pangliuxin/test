/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.cangshengwang.android.ui.mystore
 * FileNmae:RegisteredActivity.java
 */
package net.travel.android.ui.mystore;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import net.cangshengwang.android.mobile2.R;
import net.travel.android.MainActivity;
import net.travel.android.common.Constants;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyApp;
import net.travel.android.handler.RemoteDataHandler;
import net.travel.android.handler.RemoteDataHandler.Callback;
import net.travel.android.model.HistoryBrowse;
import net.travel.android.model.Login;
import net.travel.android.model.ResponseData;
import net.travel.android.ui.type.MeetBookListViewActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014年3月10日 下午2:02:39
 */
public class RoomBorrowActivity extends Activity implements View.OnTouchListener{
	private EditText editStarttime;
	private EditText editEndTime;
	private ImageView imageBack;
	private Button buttonSend;
	private MyApp myApp;
	private String jingdianid;
	private String currenttime;
	private String room_id;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.health_add_view2);
		myApp = (MyApp) RoomBorrowActivity.this.getApplication();
		editEndTime = (EditText) findViewById(R.id.editEndTime);
		editStarttime = (EditText) findViewById(R.id.editStarttime);
		imageBack = (ImageView) findViewById(R.id.imageBack);
		
		room_id = getIntent().getExtras().getString("room_id");
		editStarttime.setOnTouchListener(this);
		editEndTime.setOnTouchListener(this);
		buttonSend = (Button) findViewById(R.id.buttonSend);
		buttonSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String EndTime = editEndTime.getText().toString();
				String Starttime = editStarttime.getText().toString();
				
				if(EndTime.equals("") || EndTime==null){
					Toast.makeText(RoomBorrowActivity.this, "不能为空", Toast.LENGTH_SHORT).show();;
					return ;
				}
				if(Starttime.equals("") || Starttime==null){
					Toast.makeText(RoomBorrowActivity.this, "不能为空", Toast.LENGTH_SHORT).show();;
					return ;
				}
				
				SendData(EndTime,Starttime);
			}
		});
		imageBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				RoomBorrowActivity.this.finish();
			}
		});
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) { 
			   
            AlertDialog.Builder builder = new AlertDialog.Builder(this); 
            View view = View.inflate(this, R.layout.date_time_dialog, null); 
            final DatePicker datePicker = (DatePicker) view.findViewById(R.id.date_picker); 
            final TimePicker timePicker = (android.widget.TimePicker) view.findViewById(R.id.time_picker); 
            timePicker.setIs24HourView(true);
            builder.setView(view); 
   
            Calendar cal = Calendar.getInstance(); 
            cal.setTimeInMillis(System.currentTimeMillis()); 
            datePicker.init(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), null); 
   
   
            if (v.getId() == R.id.editEndTime) { 
                final int inType = editEndTime.getInputType(); 
                editEndTime.setInputType(InputType.TYPE_NULL); 
                editEndTime.onTouchEvent(event); 
                editEndTime.setInputType(inType); 
                editEndTime.setSelection(editEndTime.getText().length()); 
               
                builder.setTitle("设置日期"); 
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() { 
   
                    @Override 
                    public void onClick(DialogInterface dialog, int which) { 
   
                        StringBuffer sb = new StringBuffer(); 
                        sb.append(String.format("%d-%02d-%02d",  
                                datePicker.getYear(),  
                                datePicker.getMonth() + 1, 
                                datePicker.getDayOfMonth())); 
                        sb.append(" ");
                        sb.append(timePicker.getCurrentHour()).append(":").append(timePicker.getCurrentMinute());
   
                        editEndTime.setText(sb); 
//                        editEndTime.requestFocus(); 
                           
                        dialog.cancel(); 
                    } 
                }); 
                   
            } 
            if (v.getId() == R.id.editStarttime) { 
            	final int inType = editStarttime.getInputType(); 
            	editStarttime.setInputType(InputType.TYPE_NULL); 
            	editStarttime.onTouchEvent(event); 
            	editStarttime.setInputType(inType); 
            	editStarttime.setSelection(editStarttime.getText().length()); 
            	
            	builder.setTitle("设置日期"); 
            	builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() { 
            		
            		@Override 
            		public void onClick(DialogInterface dialog, int which) { 
            			
            			StringBuffer sb = new StringBuffer(); 
            			sb.append(String.format("%d-%02d-%02d",  
            					datePicker.getYear(),  
            					datePicker.getMonth() + 1, 
            					datePicker.getDayOfMonth())); 
            			sb.append(" ");
            			sb.append(timePicker.getCurrentHour()).append(":").append(timePicker.getCurrentMinute());
            			
            			editStarttime.setText(sb); 
//            			editStarttime.requestFocus(); 
            			
            			dialog.cancel(); 
            		} 
            	}); 
            	
            } 
               
            Dialog dialog = builder.create(); 
            dialog.show(); 
        } 
   
        return true; 
	}
	class TimeListener implements OnTimeChangedListener {

		/**
		 * view 当前选中TimePicker控件 hourOfDay 当前控件选中TimePicker 的小时 minute
		 * 当前选中控件TimePicker 的分钟
		 */
		@Override
		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			System.out.println("h:" + hourOfDay + " m:" + minute);
			
			currenttime =hourOfDay+":"+minute;
		}

	}

	public void SendData(String end, String start) {
		String url = HttpUtil.URL_MEETBORROWADD;
		String query = "";
	
		try {
			start=URLEncoder.encode(start , "utf-8");
			end=URLEncoder.encode(end , "utf-8");
			
			
			query += "meetborrow.userid=" + myApp.getLoginKey() + "&";
			query += "meetborrow.roomid=" + room_id + "&";
			query += "meetborrow.starttimestr=" + start + "&";
			query += "meetborrow.endtimestr=" + end ;
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		url += query;

		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());

				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					if (arrlist != "" && !arrlist.equals("arrlist")
							&& arrlist != null && !arrlist.equals("[]")) {

						if (arrlist.equals("1")) {
							Toast.makeText(RoomBorrowActivity.this, "恭喜，借阅成功",
									Toast.LENGTH_SHORT).show();
							;
							
							Intent intent = new Intent(RoomBorrowActivity.this,MainActivity.class);
							startActivity(intent);
						} else if (arrlist.equals("0")) {
							Toast.makeText(RoomBorrowActivity.this, "抱歉，借阅失败",
									Toast.LENGTH_SHORT).show();
							;
						} else if (arrlist.equals("2")) {
							Toast.makeText(RoomBorrowActivity.this, "抱歉这个时间段，已被预订",
									Toast.LENGTH_LONG).show();
							;
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(RoomBorrowActivity.this, result, Toast.LENGTH_SHORT)
					.show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(RoomBorrowActivity.this, result, Toast.LENGTH_SHORT)
					.show();
			;
		}

	}

}
