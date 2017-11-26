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
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014年3月10日 下午2:02:39
 */
public class CommentsActivity extends Activity {
	private EditText editComments;
	private ImageView imageBack;
	private Button buttonSend;
	private MyApp myApp;
	private String jingdianid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comments_view);
		myApp = (MyApp) CommentsActivity.this.getApplication();
		editComments = (EditText) findViewById(R.id.editComments);
		imageBack = (ImageView) findViewById(R.id.imageBack);
		buttonSend = (Button) findViewById(R.id.buttonSend);
		jingdianid= getIntent().getExtras().getString("jingdianid");
		buttonSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String comments = editComments.getText().toString();
				if(comments.equals("") || comments==null){
					Toast.makeText(CommentsActivity.this, "不能为空", Toast.LENGTH_SHORT).show();;
					return ;
				}
				
				SendData(comments);
			}
		});
		imageBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CommentsActivity.this.finish();
			}
		});
	}
	
	public void SendData(String comments){
		String url = HttpUtil.URL_COMMENTSADD;
		String query ="";
		query+="comment="+comments+"&";
		query+="bioid="+jingdianid+"&";
		query+="userid="+myApp.getLoginKey();

	
		
		
		/*try {
			query=URLEncoder.encode(query , "utf-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}*/
		
		
		url+=query;
		/*HashMap<String, String> params = new HashMap<String,String>();
		params.put("username", username);
		params.put("password", password);
		params.put("sex", sex);
		params.put("city", city);
		params.put("birthday", birthday);
		params.put("signature", signature);
		params.put("nickname", nickname);*/
		
	
		
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
//						Login login=Login.newInstanceList(arrlist);
//						myApp.setLoginKey(login.getKey());
//						myApp.setLoginName(login.getUsername());
						
						if(arrlist.equals("1")){
							Toast.makeText(CommentsActivity.this, "恭喜，评论成功", Toast.LENGTH_SHORT).show();;
							CommentsActivity.this.finish();
						}else{
							Toast.makeText(CommentsActivity.this, "抱歉，评论失败", Toast.LENGTH_SHORT).show();;
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
				
		/*		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
        */
				
		
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CommentsActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CommentsActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
		
		
		
		
	}

}
