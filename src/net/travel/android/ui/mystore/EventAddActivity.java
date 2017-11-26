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
import net.travel.android.common.Constants;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyApp;
import net.travel.android.handler.RemoteDataHandler;
import net.travel.android.handler.RemoteDataHandler.Callback;
import net.travel.android.model.HistoryBrowse;
import net.travel.android.model.Login;
import net.travel.android.model.ResponseData;
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
public class EventAddActivity extends Activity implements View.OnTouchListener{
	private EditText editeventname;
	private EditText eventtime;
	private ImageView imageBack;
	private Button buttonSend;
	private MyApp myApp;
	private String jingdianid;
	private String currenttime;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.event_add_view);
		myApp = (MyApp) EventAddActivity.this.getApplication();
		editeventname = (EditText) findViewById(R.id.editeventname);
		eventtime = (EditText) findViewById(R.id.eventtime);
		imageBack = (ImageView) findViewById(R.id.imageBack);
		
		
		eventtime.setOnTouchListener(this);
		buttonSend = (Button) findViewById(R.id.buttonSend);
		buttonSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String eventname = editeventname.getText().toString();
				String currenttime = eventtime.getText().toString();
				
				if(eventname.equals("") || eventname==null){
					Toast.makeText(EventAddActivity.this, "不能为空", Toast.LENGTH_SHORT).show();;
					return ;
				}
//				System.out.println(currenttime);
				
				SendData(eventname,currenttime);
			}
		});
		imageBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EventAddActivity.this.finish();
			}
		});
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
   
   
            if (v.getId() == R.id.eventtime) { 
                final int inType = eventtime.getInputType(); 
                eventtime.setInputType(InputType.TYPE_NULL); 
                eventtime.onTouchEvent(event); 
                eventtime.setInputType(inType); 
                eventtime.setSelection(eventtime.getText().length()); 
               
                builder.setTitle("设置日期"); 
                builder.setPositiveButton("确  定", new DialogInterface.OnClickListener() { 
   
                    @Override 
                    public void onClick(DialogInterface dialog, int which) { 
   
                        StringBuffer sb = new StringBuffer(); 
                        sb.append(String.format("%d-%02d-%02d",  
                                datePicker.getYear(),  
                                datePicker.getMonth() + 1, 
                                datePicker.getDayOfMonth())); 
                        sb.append("#");
                        sb.append(timePicker.getCurrentHour()).append(":").append(timePicker.getCurrentMinute());
   
                        eventtime.setText(sb); 
                        eventtime.requestFocus(); 
                           
                        dialog.cancel(); 
                    } 
                }); 
                   
            } 
               
            Dialog dialog = builder.create(); 
            dialog.show(); 
        } 
   
        return true; 
	}
	public void SendData(String eventname, String eventtime) {
		String url = HttpUtil.URL_EVENTADD;
		String query = "";
		query += "message.userid=" + myApp.getLoginKey() + "&";
		query += "message.name=" + eventname + "&";
		query += "message.uptimestr=" + eventtime;

		/*
		 * try { query=URLEncoder.encode(query , "utf-8"); } catch
		 * (UnsupportedEncodingException e1) { e1.printStackTrace(); }
		 */

		url += query;
		/*
		 * HashMap<String, String> params = new HashMap<String,String>();
		 * params.put("username", username); params.put("password", password);
		 * params.put("sex", sex); params.put("city", city);
		 * params.put("birthday", birthday); params.put("signature", signature);
		 * params.put("nickname", nickname);
		 */

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
					// JSONObject obj = new JSONObject(json);
					if (arrlist != "" && !arrlist.equals("arrlist")
							&& arrlist != null && !arrlist.equals("[]")) {
						// Login login=Login.newInstanceList(arrlist);
						// myApp.setLoginKey(login.getKey());
						// myApp.setLoginName(login.getUsername());

						if (arrlist.equals("1")) {
							Toast.makeText(EventAddActivity.this, "恭喜，添加成功",
									Toast.LENGTH_SHORT).show();
							;
							EventAddActivity.this.finish();
						} else {
							Toast.makeText(EventAddActivity.this, "抱歉，添加失败",
									Toast.LENGTH_SHORT).show();
							;
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				/*
				 * InputMethodManager imm =
				 * (InputMethodManager)getSystemService(
				 * Context.INPUT_METHOD_SERVICE);
				 * imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT,
				 * InputMethodManager.HIDE_NOT_ALWAYS);
				 */

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(EventAddActivity.this, result, Toast.LENGTH_SHORT)
					.show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(EventAddActivity.this, result, Toast.LENGTH_SHORT)
					.show();
			;
		}

	}

}
