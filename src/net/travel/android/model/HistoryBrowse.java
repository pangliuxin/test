package net.travel.android.model;

import java.util.Comparator;
import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name = "shopnc_history_browse")
public class HistoryBrowse extends Model {

	@Column(name = "goodsID")
	public String goodsID;

	@Column(name = "imageURL")
	public String imageURL;

	@Column(name = "goodsName")
	public String goodsName;

	@Column(name = "goodsPrice")
	public String goodsPrice;

	public HistoryBrowse() {
	}

	public HistoryBrowse(String goodsID, String imageURL, String goodsName,
			String goodsPrice) {
		super();
		this.goodsID = goodsID;
		this.imageURL = imageURL;
		this.goodsName = goodsName;
		this.goodsPrice = goodsPrice;
	}

	/**
	 * 保存历史浏览
	 * */
	public static void historyBrowseSava(GoodsList bean) {
		HistoryBrowse hb = new HistoryBrowse();
	/*	hb.goodsID = bean.getGoods_id();
		hb.goodsName = bean.getGoods_name();
		hb.goodsPrice = bean.getGoods_price();
		hb.imageURL = bean.getGoods_image_url();*/
		hb.save();
	}

	/**
	 * 保存历史浏览2
	 * */
	public static void historyBrowseSava2(GoodsList bean) {
		List<HistoryBrowse> hblist = null;//new Select().from(HistoryBrowse.class).where("goodsID = ?" , bean.getGoods_id()).execute();
		if (hblist.size()>0) {
		}else{
			List<HistoryBrowse> hisBro = new Select().from(HistoryBrowse.class).execute();
			int count = hisBro.size();
			if (count >= 30) {
				HistoryBrowse hb =hisBro.get(0);
				deleteID(hb.goodsID);
			} 
			HistoryBrowse hb = new HistoryBrowse();
			/*hb.goodsID = bean.getGoods_id();
			hb.goodsName = bean.getGoods_name();
			hb.goodsPrice = bean.getGoods_price();
			hb.imageURL = bean.getGoods_image_url();*/
			hb.save();
		}
	}

	/**
	 * 查询所有历史浏览
	 * */
	public static List<HistoryBrowse> searchQueryList(int pageno, int pagesize) {
		int no = 0;
		if(pageno ==1 ){
			no = 0;
		}else{
			no = (pageno * pagesize) - pagesize - 1;
		}
		List<HistoryBrowse> HBList=new Select().from(HistoryBrowse.class)
				.limit(no + "," + pagesize).execute();
		return HBList;
	}

	/**
	 * 判断有没有下一页
	 * */
	public static boolean HistortBrowseMoreFlag(int pageno, int pagesize) {
		boolean moreFlag = false;
		int allCount = new Select().from(HistoryBrowse.class).execute().size();
		int count = allCount - (pageno * pagesize);
		if (count > 0) {
			moreFlag = true;
		} else {
			moreFlag = false;
		}
		return moreFlag;
	}

	/**
	 * 删除全部历史浏览
	 * */
	public static void deleteAll() {
		new Delete().from(HistoryBrowse.class).execute();
	}
	
	/**
	 * 删除指定ID历史浏览
	 * */
	public static void deleteID(String goodsID) {
		new Delete().from(HistoryBrowse.class).where("goodsID = ?" ,goodsID).execute();
	}

	@Override
	public String toString() {
		return "HistoryBrowse [goodsID=" + goodsID + ", imageURL=" + imageURL
				+ ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice
				+ "]";
	}
}

class ComparatorHistoryBrowse implements Comparator {

	public int compare(Object objHistoryBrowse0, Object objHistoryBrowse1) {
		HistoryBrowse bean0=(HistoryBrowse)objHistoryBrowse0;
		HistoryBrowse bean1=(HistoryBrowse)objHistoryBrowse1;
		int flag = bean0.getId().compareTo(bean1.getId());
		return flag;
	}

}