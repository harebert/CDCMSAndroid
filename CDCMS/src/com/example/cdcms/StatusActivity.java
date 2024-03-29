package com.example.cdcms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class StatusActivity extends Activity {
	private String[] jifangString =new String[]{"机房1","机房1","机房2","机房3","机房3","机房4","机房5","机房7"};
	private String[] jigui =new String[]{"机柜1","机柜2","机柜3","机柜4","机柜5","机柜6","机柜7","机柜8"};
	private String[] temperturesStrings =new String[]{"34","35","33","37","38","33","32","26"};
	private String[] humidityStrings =new String[]{"60","45","37","67","40","50","30","57"};
	private String[] statuStrings =new String[]{"正常","警告","正常","正常","报警","正常","正常","正常"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_status);
		// Show the Up button in the action bar.
		setupActionBar();
		List<Map<String, Object>> listItems=new ArrayList<Map<String,Object>>();
		for (int i = 0; i < jifangString.length; i++) {
			Map<String, Object> listItemMap=new HashMap<String, Object>();
			listItemMap.put("jifang", jifangString[i]);
			listItemMap.put("jigui", jigui[i]);
			listItemMap.put("temperture", temperturesStrings[i]);
			listItemMap.put("humidity", humidityStrings[i]);
			listItemMap.put("status", statuStrings[i]);
			listItems.add(listItemMap);
			
		}
		SimpleAdapter simpleAdapter=new SimpleAdapter(this, listItems, R.layout.listitem, new String[]{"jifang","jigui","temperture","humidity","status" }, new int[]{R.id.id_jifang,R.id.id_jigui,R.id.id_temp,R.id.id_humidity,R.id.id_status});
		ListView listView=(ListView)findViewById(R.id.statusList);
		listView.setAdapter(simpleAdapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Intent goToStatusIntent=new Intent();
				goToStatusIntent.setClass(StatusActivity.this, ChartActivity.class);
				startActivity(goToStatusIntent);
				//System.out.println("asdfasdfasdfasdf");
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.status, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
