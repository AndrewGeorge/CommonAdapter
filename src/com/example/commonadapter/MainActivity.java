package com.example.commonadapter;

import java.util.ArrayList;
import java.util.List;

import com.example.bean.Bean;
import com.example.utils.CommonAdapter;
import com.example.utils.ViewHolder;

import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView listview;
	private List<Bean> mDatas;
	private MyAdapter mMyadapter;
	private MyAdapterWidthCommonViewHolder myAdapterWidthCommonViewHolder;
	private List<Integer> mPos = new ArrayList<Integer>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initDatas();
		initView();
	}

	/**
	 * 初始化UI
	 */
	private void initView() {

		listview = (ListView) findViewById(R.id.listview);
		// 直接使用commonAdapter来实现
		listview.setAdapter(new CommonAdapter<Bean>(MainActivity.this, mDatas,R.layout.item_listview) {

			@Override
			public void convert(final ViewHolder viewHolder, final Bean bean) {
				viewHolder.setText(R.id.id_title, bean.getTitle())
						.setText(R.id.id_dec, bean.getDes())
						.setText(R.id.id_time, bean.getTime())
						.setText(R.id.id_phone, bean.getPhone());

				final CheckBox cb = viewHolder.getView(R.id.id_cbox);
				// 使用bean中的属性来标记是否选中
				// cb.setChecked(bean.isCkecked());

				cb.setChecked(false);
				if (mPos.contains(viewHolder.getmOption())) {
					cb.setChecked(true);
				}
				cb.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// bean.setCkecked(cb.isChecked());
						if (cb.isChecked()) {
							mPos.add(viewHolder.getmOption());
						} else {
							mPos.remove((Integer) viewHolder.getmOption());
						}
					}
				});

			}
		});

		// myAdapterWidthCommonViewHolder继承commonAdapter
		// listview.setAdapter(myAdapterWidthCommonViewHolder);
	}

	private void initDatas() {

		mDatas = new ArrayList<Bean>();
		for (int i = 0; i < 20; i++) {
			Bean bean = new Bean("Android万能适配器" + i, "来学习一哈Android万能适配器",
					"2015-7-27", "10086");
			mDatas.add(bean);
		}
		// mMyadapter=new MyAdapter(this, mDatas);
//		 myAdapterWidthCommonViewHolder=new
//		 MyAdapterWidthCommonViewHolder(this, mDatas,R.layout.item_listview);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
