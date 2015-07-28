package com.example.commonadapter;

import java.util.List;
import android.content.Context;
import com.example.bean.Bean;
import com.example.utils.CommonAdapter;
import com.example.utils.ViewHolder;

public class MyAdapterWidthCommonViewHolder extends CommonAdapter<Bean> {

	public MyAdapterWidthCommonViewHolder(Context context, List<Bean> mDatas,int layoutId) {
		super(context, mDatas,layoutId);
	}

	@Override
	public void convert(ViewHolder viewHolder, Bean bean) {

		viewHolder.setText(R.id.id_title, bean.getTitle())
				.setText(R.id.id_dec, bean.getDes())
				.setText(R.id.id_time, bean.getTime())
				.setText(R.id.id_phone, bean.getPhone());

	}

}
