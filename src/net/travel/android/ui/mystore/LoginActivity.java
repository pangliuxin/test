/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.ui.mystore
 * FileNmae:LoginActivity.java
 */
package net.travel.android.ui.mystore;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import net.cangshengwang.android.mobile2.R;
import net.travel.android.common.Constants;
import net.travel.android.common.HttpUtil;
import net.travel.android.common.MyApp;
import net.travel.android.handler.RemoteDataHandler;
import net.travel.android.handler.RemoteDataHandler.Callback;
import net.travel.android.model.Login;
import net.travel.android.model.ResponseData;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014-1-9 下午12:02:21
 */
public class LoginActivity extends Activity{
		private EditText editLoginName;
		private EditText editLoginPassWord;
		private Button buttonLoginSubmit;
		private CheckBox checkboxMyAuto;
		private MyApp myApp;
		private Button buttonBack;
		private Button buttonRegister;
		private Button buttonFindpwd;
		private String tabFlag;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.login_view);
			myApp = (MyApp) LoginActivity.this.getApplication();
			tabFlag = LoginActivity.this.getIntent().getStringExtra("tabFlag");
			editLoginName = (EditText) findViewById(R.id.editLoginName);
			editLoginPassWord = (EditText) findViewById(R.id.editLoginPassWord);
			buttonLoginSubmit = (Button) findViewById(R.id.buttonLoginSubmit);
			checkboxMyAuto = (CheckBox) findViewById(R.id.checkboxMyAuto);
			buttonBack = (Button) findViewById(R.id.buttonBack);
			buttonRegister = (Button) findViewById(R.id.buttonRegister);
			buttonFindpwd = (Button) findViewById(R.id.buttonFindpwd);
			myApp.setIsCheckLogin(true);
			checkboxMyAuto.setChecked(myApp.isIsCheckLogin());
			
			//checkboxMyAuto.setChecked(true);
			
			buttonLoginSubmit.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					String loginName = editLoginName.getText().toString();
					String loginPassword = editLoginPassWord.getText().toString();
					boolean isCheck = checkboxMyAuto.isChecked();
					infoLoginCheck(loginName, loginPassword, isCheck);
				}
			});
			buttonBack.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					LoginActivity.this.finish();
				}
			});
			buttonRegister.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, RegisteredActivity.class);
                    LoginActivity.this.startActivity(intent);
                    LoginActivity.this.finish();
                }
            });
			
			buttonFindpwd.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                	
                }
            });
		}
		
		public void infoLoginCheck(String loginName,String loginPassword,final boolean isCheck){
			String url = HttpUtil.URL_LOGIN;
			String query ="";
			query+="user.username="+loginName+"&";
			query+="user.password="+loginPassword;
			
			url+=query;
			
			HttpPost request = HttpUtil.getHttpPost(url);
			String result = null;
			try {
				// 获得响应对象
				HttpResponse response = HttpUtil.getHttpResponse(request);
				// 判断是否请求成功
				if(response.getStatusLine().getStatusCode()==200){
					// 获得响应
					result = EntityUtils.toString(response.getEntity());
					
					
					Login login=Login.newInstanceList(result);
					if(login !=null){
						myApp.setLoginKey(login.getKey());
						myApp.setLoginName(login.getUsername());
						myApp.setRole(login.getRole());
						Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();;
					/*	Intent mIntent = new Intent(Constants.APP_BORADCASTRECEIVER); 
						sendBroadcast(mIntent); */
						InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
		                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
		            	Intent intent = new Intent(LoginActivity.this,MyStoreActivity.class);
		            	LoginActivity.this.startActivity(intent);
					}else{
						Toast.makeText(LoginActivity.this, "用户名或者密码错误", 1).show();;
					}
					
				}
			} catch (ClientProtocolException e) {
				e.printStackTrace();
				result = "网络异常！";
				Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();;
			} catch (IOException e) {
				e.printStackTrace();
				result = "网络异常！";
				Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();;
			}
			
			
		}
}
