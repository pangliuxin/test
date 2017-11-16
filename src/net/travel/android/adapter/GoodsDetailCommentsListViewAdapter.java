package net.travel.android.adapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import net.cangshengwang.android.mobile2.R;
import net.travel.android.handler.ImageLoader;
import net.travel.android.model.CommentsList;
import net.travel.android.model.GoodComments;
import net.travel.android.model.OrderGoodsList;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;


/**
 * 收藏列表ListView适配器
 * @author hjgang
 */
public class GoodsDetailCommentsListViewAdapter extends BaseAdapter{
	private LayoutInflater inflater;
	public ViewHolder vh;
	private Context ctx;

	private ArrayList<CommentsList> goodcomments;


	/**
	 * 构造方法
	 * @param ctx
	 */
	public GoodsDetailCommentsListViewAdapter(Context ctx){
		this.ctx = ctx;
		inflater = LayoutInflater.from(ctx);
	}

	@Override
	public int getCount() {
		return goodcomments == null ? 0: goodcomments.size();
	}

	public Object getItem(int index) {
		return goodcomments.get(index);
	}

	public long getItemId(int index) {
		return index;
	}
	


	public ArrayList<CommentsList> getGoodsDatas() {
		return goodcomments;
	}

	public void setGoodsDatas(ArrayList<CommentsList> goodcomments) {
		this.goodcomments = goodcomments;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listivew_goods_detail_comment, null);
			vh = new ViewHolder();
			vh.textusername = (TextView) convertView.findViewById(R.id.textusername);
			vh.textstart = (TextView) convertView.findViewById(R.id.textstart);
			vh.textend = (TextView) convertView.findViewById(R.id.textend);
			
			convertView.setTag(vh);
			
		}else{
			vh = (ViewHolder)convertView.getTag();
			
		}
		final CommentsList bean = goodcomments.get(position);

	

		
		vh.textusername.setText(bean.getUsername());
		vh.textstart.setText(bean.getStarttimestr());
		vh.textend.setText(bean.getEndtimestr());
		

//		SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		String textGoodCommentsdate_ =time.format(Long.parseLong(bean.getGeval_addtime())*1000);
	
		
		

		

		
		return convertView;
	}

	public class ViewHolder{
		
		TextView textusername;
		TextView textstart;
		TextView textend;
	}
}
