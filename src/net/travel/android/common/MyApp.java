package net.travel.android.common;

import java.io.File;
import java.util.LinkedList;
import java.util.List;


import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.Toast;

import com.activeandroid.app.Application;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;

/**
 * 全局变量类
 * @author hjgang
 */
public class MyApp extends Application {
	/** 系统初始化配置文件操作器 */
	private SharedPreferences sysInitSharedPreferences;
	
	/** 记录用户登录后的KEY*/
	private String loginKey;
	/** 记录用户登录后的用户名*/
	private String loginName;
	private String role;
	
	private boolean IsCheckLogin;
	
	private TabHost tabHost;
	private RadioButton MyStoreButton;
	private RadioButton searchButton;
	private RadioButton cartButton;
	private RadioButton HomeButton;
    public boolean m_bKeyRight = true;
    public BMapManager mBMapManager = null;
    private static MyApp mInstance = null;
    public static final String strKey = "fwHPLe53R8WYfOXwdPwatKN8";//q1xYafI8KExQIxGpKtqdqMDl
	
	private List<Activity> activityList = new LinkedList();
	
	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
//		CrashHandler crashHandler = CrashHandler.getInstance();
//		crashHandler.init(this);
		sysInitSharedPreferences = getSharedPreferences(Constants.SYSTEM_INIT_FILE_NAME, MODE_PRIVATE);
		loginKey = sysInitSharedPreferences.getString("loginKey", "");
		IsCheckLogin = sysInitSharedPreferences.getBoolean("IsCheckLogin", false);
		createCacheDir();
		initEngineManager(this);
	}

	
	public void initEngineManager(Context context) {
        if (mBMapManager == null) {
            mBMapManager = new BMapManager(context);
        }

        if (!mBMapManager.init(strKey,new MyGeneralListener())) {
        }
	}
	
	public static MyApp getInstance() {
		return mInstance;
	}
	
	// 常用事件监听，用来处理通常的网络错误，授权验证错误等
    public static class MyGeneralListener implements MKGeneralListener {
        
        @Override
        public void onGetNetworkState(int iError) {
            if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
                Toast.makeText(MyApp.getInstance().getApplicationContext(), "您的网络出错啦！",
                    Toast.LENGTH_LONG).show();
            }
            else if (iError == MKEvent.ERROR_NETWORK_DATA) {
                Toast.makeText(MyApp.getInstance().getApplicationContext(), "输入正确的检索条件！",
                        Toast.LENGTH_LONG).show();
            }
            // ...
        }
    	
        @Override
        public void onGetPermissionState(int iError) {
        	//非零值表示key验证未通过
            if (iError != 0) {
                //授权Key错误：
//                Toast.makeText(MyApp.getInstance().getApplicationContext(), 
//                        "请件输入正确的授权Key,并检查您的网络连接是否正常！error: "+iError, Toast.LENGTH_LONG).show();
                MyApp.getInstance().m_bKeyRight = false;
            }
            else{
            	MyApp.getInstance().m_bKeyRight = true;
            	Toast.makeText(MyApp.getInstance().getApplicationContext(), 
                        "key认证成功", Toast.LENGTH_LONG).show();
            }
        }
    }
	public RadioButton getHomeButton() {
		return HomeButton;
	}

	public void setHomeButton(RadioButton homeButton) {
		HomeButton = homeButton;
	}

	public RadioButton getCartButton() {
		return cartButton;
	}

	public void setCartButton(RadioButton cartButton) {
		this.cartButton = cartButton;
	}



	public RadioButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(RadioButton searchButton) {
		this.searchButton = searchButton;
	}

	public RadioButton getMyStoreButton() {
		return MyStoreButton;
	}

	public void setMyStoreButton(RadioButton myStoreButton) {
		MyStoreButton = myStoreButton;
	}

	public TabHost getTabHost() {
		return tabHost;
	}

	public void setTabHost(TabHost tabHost) {
		this.tabHost = tabHost;
	}

	public SharedPreferences getSysInitSharedPreferences() {
		return sysInitSharedPreferences;
	}

	public void setSysInitSharedPreferences(
			SharedPreferences sysInitSharedPreferences) {
		this.sysInitSharedPreferences = sysInitSharedPreferences;
	}

	public String getLoginKey() {
		String loginKey = sysInitSharedPreferences.getString("loginKey", "");
		return loginKey;
	}

	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
		sysInitSharedPreferences.edit().putString("loginKey", this.loginKey).commit();
	}

	public String getLoginName() {
		String loginName = sysInitSharedPreferences.getString("loginName", "");
		return loginName;
	}

	public String getRole() {
		String role = sysInitSharedPreferences.getString("role", "");
		return role;
	}


	public void setRole(String role) {
		this.role = role;
		sysInitSharedPreferences.edit().putString("role", this.role).commit();
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
		sysInitSharedPreferences.edit().putString("loginName", this.loginName).commit();
	}

	public boolean isIsCheckLogin() {
		/*boolean IsCheckLogin = sysInitSharedPreferences.getBoolean("IsCheckLogin", false);
		return IsCheckLogin;*/
	    return IsCheckLogin;
	}

	public void setIsCheckLogin(boolean isCheckLogin) {
		IsCheckLogin = isCheckLogin;
		sysInitSharedPreferences.edit().putBoolean("IsCheckLogin", this.IsCheckLogin).commit();
	}
	
	
	public String getVersionName() throws Exception
	   {
	           // 获取packagemanager的实例
	           PackageManager packageManager = getPackageManager();
	           // getPackageName()是你当前类的包名，0代表是获取版本信息
	           PackageInfo packInfo = packageManager.getPackageInfo(getPackageName(),0);
	           String version = packInfo.versionName;
	           return version;
	   }
	
	public int checkVersion() throws NumberFormatException, Exception{
	
		
		float currentVersion = Float.parseFloat(getVersionName() );
		
		if(currentVersion < 1.7f){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	// 创建SD卡缓存目录
	private void createCacheDir() {
	
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			File f = new File(Constants.CACHE_DIR);
			if (f.exists()) {
				System.out.println("SD卡缓存目录:已存在!");
			} else {
				if (f.mkdirs()) {
					System.out.println("SD卡缓存目录:" + f.getAbsolutePath()
							+ "已创建!");
				} else {
					System.out.println("SD卡缓存目录:创建失败!");
				}
			}
	
			File ff = new File(Constants.CACHE_DIR_IMAGE);
			if (ff.exists()) {
				System.out.println("SD卡照片缓存目录:已存在!");
			} else {
				if (ff.mkdirs()) {
					System.out.println("SD卡照片缓存目录:" + ff.getAbsolutePath()
							+ "已创建!");
				} else {
					System.out.println("SD卡照片缓存目录:创建失败!");
				}
			}
		}
	}
	
	
	// 添加Activity到容器中
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}
	// 遍历所有Activity并finish

		public void exit(Context context) {

			for (Activity activity : activityList) {
				activity.finish();
			}
			
			ActivityManager activityMgr= (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE );

	        activityMgr.restartPackage(context.getPackageName());

			System.exit(0);

		}
}
