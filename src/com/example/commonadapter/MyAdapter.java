package com.example.commonadapter;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.Bean;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context context;
	private List<Bean> mDatas;
	private LayoutInflater mInflater;

	public MyAdapter(Context context, List<Bean> mDatas) {
		mInflater = LayoutInflater.from(context);
		this.context = context;
		this.mDatas = mDatas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mDatas.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mDatas.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		
		ViewHolder holder=null;
		if (arg1==null) {
			arg1=mInflater.inflate(R.layout.item_listview, arg2, false);
			holder=new ViewHolder();
			holder.title=(TextView) arg1.findViewById(R.id.id_title);
			holder.des=(TextView) arg1.findViewById(R.id.id_dec);
			holder.time=(TextView) arg1.findViewById(R.id.id_time);
			holder.phone=(TextView) arg1.findViewById(R.id.id_phone);
			arg1.setTag(holder);
		}else {
			
			holder=(ViewHolder) arg1.getTag();
		}
		
		Bean bean=mDatas.get(arg0);
		holder.title.setText(bean.getTitle());
		holder.des.setText(bean.getDes());
		holder.time.setText(bean.getTime());
		holder.phone.setText(bean.getPhone());
		
		
		
		return arg1;
	}

	private class ViewHolder {

		private TextView title;
		private TextView des;
		private TextView time;
		private TextView phone;

	}

}
