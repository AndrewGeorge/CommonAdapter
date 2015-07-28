package com.example.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

	private SparseArray<View> mViews;
	private int mOption;
	private View mConvertView;

	public ViewHolder(Context context, ViewGroup parsten, int layoutId,
			int postion) {

		this.mOption = postion;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parsten,
				false);
		mConvertView.setTag(this);
	}

	public static ViewHolder getViewHolder(Context context, View convertView,
			ViewGroup parsten, int layoutId, int postion) {

		if (convertView == null) {
			return new ViewHolder(context, parsten, layoutId, postion);
		} else {
			ViewHolder viewHolder = (ViewHolder) convertView.getTag();
			viewHolder.mOption=postion;
			return viewHolder;
		}
	}
	
	public  View getConvertView() {
		return mConvertView;
	}
	
	/**
	 * ͨ��ViewId��ȡ�ؼ�
	 * @param ViewId
	 * @return
	 */
	public <T extends View > T getView(int ViewId){
		
		View view=mViews.get(ViewId);
		if (view==null) {
			
			view =mConvertView.findViewById(ViewId);
			mViews.put(ViewId, view);
		}
		return (T)view;
	}
	/***
	 * ΪTextView����ֵ
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHolder setText(int viewId,String text){
		
		TextView tv= getView(viewId);
		tv.setText(text);
		return this;
	}
	/***
	 * ����resourceIdΪimageView����ֵ
	 * @param viewId
	 * @param resId
	 * @return
	 */
	public ViewHolder setImageResource(int viewId,int resId){
		
		ImageView imageview= getView(viewId);
		imageview.setImageResource(resId);
		return this;
	}
	
	/**
	 * ����bitmapΪImageview����ֵ
	 * @param viewId
	 * @param bitmap
	 * @return
	 */
public ViewHolder setImageitmap(int viewId,Bitmap bitmap){
		
		ImageView imageview= getView(viewId);
		imageview.setImageBitmap(bitmap);
		return this;
	}	
	
/**
 * ʹ��URLΪimageView����ֵ()
 * ps:��demo����δʹ��imageloaderʹ�����Լ�����
 * @param viewId
 * @param url
 * @return
 */
public ViewHolder setImageUrl(int viewId,String url){
	
	ImageView imageview= getView(viewId);
	//imageloader��getinstence().loading(view,url);
	return this;
}

public int getmOption() {
	return mOption;
}	


}
