package com.example.utils;

import java.util.List;

import com.example.bean.Bean;
import com.example.commonadapter.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public abstract class CommonAdapter<T> extends BaseAdapter {

	protected Context context;
	protected List<T> mDatas;
	protected LayoutInflater mInflater;
	private int layoutId;
	

	public CommonAdapter(Context context, List<T> datas,int layoutId) {

		this.context = context;
		this.mDatas = datas;
		this.layoutId=layoutId;
		mInflater=LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public T getItem(int arg0) {
		// TODO Auto-generated method stub
		return mDatas.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public  View getView(int postion, View convertView, ViewGroup parsten){
		
		ViewHolder holder = ViewHolder.getViewHolder(context, convertView,
				parsten, layoutId, postion);
		convert(holder,getItem(postion));
		return holder.getConvertView();
		
		
	}
	
	public abstract  void convert(ViewHolder viewHolder,T t);
}